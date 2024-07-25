package org.nott.chat.server;


import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;

/**
 * 聊天服务端处理器
 *
 * @author Nott
 * @date 2024-7-24
 */

@Slf4j
public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        Channel say = ctx.channel();
        for (Channel member : channels) {
            if (say != member) {
                channels.writeAndFlush(String.format("[%s say]: %s.\n", say.remoteAddress(), s));
            } else {
                channels.writeAndFlush(String.format("[You say]: %s.\n", s));
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
        channels.writeAndFlush(String.format("[Chat Room]: %s,join in chat.\n", in.remoteAddress()));
        channels.add(in);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel left = ctx.channel();
        channels.writeAndFlush(String.format("[Chat Room]: %s,has left.\n", left.remoteAddress()));
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
