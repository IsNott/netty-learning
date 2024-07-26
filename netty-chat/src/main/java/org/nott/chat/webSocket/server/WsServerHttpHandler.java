package org.nott.chat.webSocket.server;

import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.stream.ChunkedNioFile;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author Nott
 * @date 2024-7-26
 */
@Slf4j
public class WsServerHttpHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    public final String wsUri;

    public static final String HTML_NAME = "WebSocketChatClient.html";

    public static final File INDEX;

    static {
        URL location = WsServerHttpHandler.class.getProtectionDomain().getCodeSource().getLocation();
        try {
            String path = location.toURI() + HTML_NAME;
            path = !path.contains("file:") ? path : path.substring(5);
            INDEX = new File(path);
        } catch (URISyntaxException e) {
            throw new RuntimeException("Can't set the index file for " + HTML_NAME, e);
        }
    }

    public WsServerHttpHandler(String wsUri){
        this.wsUri = wsUri;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest req) throws Exception {
        log.info(req.uri());
        if (wsUri.equalsIgnoreCase(req.uri())) {
            // if request uri equals "/ws",trans msg to next handler.
            // retain() 是必要的，因为 channelRead() 完成后，它会调用 FullHttpRequest 上的 release() 来释放其资源
            ctx.fireChannelRead(req.retain());
        } else {
            if(HttpUtil.is100ContinueExpected(req)){
                FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.CONTINUE);
                ctx.writeAndFlush(response);
            }

            // read html
            RandomAccessFile file = null;
            try {
                file = new RandomAccessFile(INDEX, "r");

                // new Http Response
                DefaultHttpResponse response = new DefaultHttpResponse(req.protocolVersion(), HttpResponseStatus.OK);

                // add headers
                response.headers().add("Content-Type", "text/html; charset=UTF-8");
                boolean keepAlive = HttpUtil.isKeepAlive(req);
                if (keepAlive) {
                    response.headers().add("Content-Length", file.length());
                    response.headers().add("Connection", "keep-alive");
                }
                // 写入缓冲
                ctx.write(response);

                ChannelPipeline pipeline = ctx.pipeline();
                // 判断是否使用ssl
                if (pipeline.get(SslHandler.class) == null) {
                    ctx.write(new DefaultFileRegion(file.getChannel(), 0L, file.length()));
                } else {
                    ctx.write(new ChunkedNioFile(file.getChannel()));
                }

                ChannelFuture future = ctx.writeAndFlush(LastHttpContent.EMPTY_LAST_CONTENT);
                if (!keepAlive) {
                    // 不需要keepAlive监听关闭
                    future.addListener(ChannelFutureListener.CLOSE);
                }
            } finally {
                if (file != null) {
                    file.close();
                }
            }
        }

    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error(cause.getMessage(),cause);
        ctx.close();
    }
}
