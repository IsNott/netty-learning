package org.nott.netty.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * reference: <a href="https://waylau.gitbooks.io/netty-4-user-guide/content/Getting-Started/Writing-a-Discard-Server.html"/>
 * discard服务端处理器
 *
 * @author Nott
 * @date 2024-7-24
 */
@Slf4j
public class DiscardHandler extends ChannelInboundHandlerAdapter { // ChannelInboundHandlerAdapter 实现 ChannelInboundHandler 接口

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 1.print msg
        // ByteBuf 是一个引用计数对象
        // discard every msg
        ByteBuf buf = (ByteBuf) msg;
        log.info(buf.toString(CharsetUtil.US_ASCII));
        // 2.response same msg
        ctx.write(msg);
        ctx.flush();
        // Don't need release msg after write and flush
//        buf.release();

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("Server error >>>>>>>>{}", cause.getMessage(), cause);
        // When sever wrong then close
        ctx.close();
    }
}
