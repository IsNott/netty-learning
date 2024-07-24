package org.nott.netty.time;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author Nott
 * @date 2024-7-24
 */

public class TimeSever {

    private Integer port;

    private NioEventLoopGroup boss;

    public TimeSever(Integer port) {
        this.port = port;
    }

    public void start() throws Exception{
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        this.boss = boss;
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boss,worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast(new TimeEncoder());
                        pipeline.addLast(new TimeServerHandler());
                    }
                });

        ChannelFuture cf = bootstrap.bind(port).sync();
        cf.channel().closeFuture().sync();
    }

    public static void main(String[] args) {
        try {
            new TimeSever(99).start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
