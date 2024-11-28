package org.nott.grpc.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.nott.grpc.model.DataInfo;

/**
 * @author Nott
 * @date 2024-11-28
 */
public class GrpcClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        DataInfo.Student msg = DataInfo.Student.newBuilder().setName("客户端")
                .setAge(1).setAddress("从Localhost来").build();
        ctx.channel().writeAndFlush(msg);
    }
}
