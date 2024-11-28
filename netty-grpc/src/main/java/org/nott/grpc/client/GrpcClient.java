package org.nott.grpc.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;

import io.netty.channel.socket.nio.NioSocketChannel;
import org.nott.grpc.client.initializer.GrpcClientInitializer;
import org.nott.grpc.sever.initializer.GrpcServiceInitializer;

/**
 * @author Nott
 * @date 2024-11-28
 */
public class GrpcClient {

    public void run() throws Exception {
        NioEventLoopGroup boss = null;

        try {
            boss = new NioEventLoopGroup();

            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(boss)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new GrpcClientInitializer())
                    .bind(9999)
                    .sync();
            ChannelFuture channelFuture = bootstrap.connect("localhost", 8888).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            boss.shutdownGracefully();

        }
    }

    public static void main(String[] args) throws Exception{
        new GrpcClient().run();
    }
}
