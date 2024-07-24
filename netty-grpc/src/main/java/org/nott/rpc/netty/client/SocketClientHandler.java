package org.nott.rpc.netty.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Nott
 * @date 2024-7-23
 */
@Slf4j
public class SocketClientHandler extends SimpleChannelInboundHandler<Object> {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object o) throws Exception {
        log.info("客户端收到来自"+ctx.channel().remoteAddress()+"的"+o);
        ctx.flush();
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent e = (IdleStateEvent) evt;
            switch (e.state()) {
                case WRITER_IDLE:
                    /**
                     *  利用写空闲发送心跳检测消息
                     */
                    String msg = "ping";
                    ctx.writeAndFlush(msg);
                    log.info("send ping to server----------");
                    break;
                default:
                    break;
            }
        }
    }
}
