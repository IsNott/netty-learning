package org.nott.netty.time;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
import org.nott.netty.time.pojo.UnixTime;

/**
 * @author Nott
 * @date 2024-7-24
 */
@Slf4j
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    // channelActive() 方法将会在连接被建立并且准备进行通信时被调用
//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        final ByteBuf time = ctx.channel().alloc().buffer(4);
//        time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));
//
//        log.info("write time=====>{}",time);
//        //  ChannelFuture 代表了一个还没有发生的 I/O 操作
//        final ChannelFuture future = ctx.writeAndFlush(time);
//
//        // 当一个写请求已经完成是如何通知到我们？
//        // 这个只需要简单地在返回的 ChannelFuture 上增加一个ChannelFutureListener。
//        // 这里我们构建了一个匿名的 ChannelFutureListener 类用来在操作完成时关闭 Channel。
//        //或者，你可以使用简单的预定义监听器代码: f.addListener(ChannelFutureListener.CLOSE);
//        future.addListener(new ChannelFutureListener() {
//            @Override
//            public void operationComplete(ChannelFuture channelFuture) throws Exception {
//                assert future == future;
//                ctx.close();
//            }
//        });
//
//    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ChannelFuture f = ctx.writeAndFlush(new UnixTime());
        f.addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
