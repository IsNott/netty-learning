package org.nott.chat.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * 聊天客户端
 * @author Nott
 * @date 2024-7-24
 */

@Slf4j
public class ChatServer {

    private Integer port;

    private NioEventLoopGroup boss;

    private NioEventLoopGroup worker;

    public ChatServer(Integer port) {
        this.port = port;
    }

    public void run() throws Exception{
        boss = new NioEventLoopGroup();
        worker = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        try {
            bootstrap.group(boss,worker)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,128)
                    .childOption(ChannelOption.SO_KEEPALIVE,true)
                    .childHandler(new ChatServerChannelInitializer());
            ChannelFuture future = bootstrap.bind(port).sync();
            future.channel().closeFuture().sync();

        } finally {
            boss.shutdownGracefully();
        }
    }
}
