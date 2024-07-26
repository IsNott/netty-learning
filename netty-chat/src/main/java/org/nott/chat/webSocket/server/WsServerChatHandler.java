package org.nott.chat.webSocket.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;

/**
 * WebSocket的聊天handler
 * @author Nott
 * @date 2024-7-26
 */

/**
 * WebSockets 在“帧”里面来发送数据，其中每一个都代表了一个消息的一部分。
 * 一个完整的消息可以利用了多个帧。 WebSocket “Request for Comments” (RFC) 定义了六中不同的 frame;
 * Netty 给他们每个都提供了一个 POJO 实现 ，而我们的程序只需要使用下面4个帧类型：
 *
 * CloseWebSocketFrame
 * PingWebSocketFrame
 * PongWebSocketFrame
 * TextWebSocketFrame
 * 在这里我们只需要显示处理 TextWebSocketFrame，其他的会由 WebSocketServerProtocolHandler 自动处理。
 */
@Slf4j
public class WsServerChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    // 实现Chat room的Group
    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        Channel say = ctx.channel();
        for (Channel member : channels) {
            if (say != member) {
                member.writeAndFlush(new TextWebSocketFrame(String.format("[%s say]: %s.\n", say.remoteAddress(), msg.text())));
            } else {
                member.writeAndFlush(new TextWebSocketFrame(String.format("[You say]: %s.\n", msg.text())));
            }
        }
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("服务器异常：{}", cause.getMessage(), cause);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel in = ctx.channel();
        channels.writeAndFlush(new TextWebSocketFrame(String.format("[Chat Room]: %s,join in chat.\n", in.remoteAddress())));
        channels.add(in);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel left = ctx.channel();
        channels.writeAndFlush(new TextWebSocketFrame(String.format("[Chat Room]: %s,has left.\n", left.remoteAddress())));
        channels.remove(left);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("{}上线\n", ctx.channel().remoteAddress());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("{}离开\n", ctx.channel().remoteAddress());
    }
}
