package org.nott.rpc.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.DefaultThreadFactory;
import lombok.extern.slf4j.Slf4j;


/**
 * @author Nott
 * @date 2024-7-23
 */
@Slf4j
public class NettySocketServer {

    private Integer port;

    private ChannelFuture channelFuture;

    private EventLoopGroup bossGroup;

    public static NettySocketServer Default(){
        return new NettySocketServer();
    }

    public void start(int port){
        DefaultThreadFactory boss = new DefaultThreadFactory("boss", Thread.MAX_PRIORITY);
        DefaultThreadFactory worker = new DefaultThreadFactory("worker", Thread.MAX_PRIORITY);

        NioEventLoopGroup bGroup = new NioEventLoopGroup(1, boss);
        NioEventLoopGroup wGroup = new NioEventLoopGroup(Runtime.getRuntime().availableProcessors() << 1, worker);

        this.bossGroup = bGroup;
        ChannelFuture future = new ServerBootstrap().group(bGroup, wGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new SocketServerInitializer())
                .bind(port);

        if(future.isSuccess()){
            this.channelFuture = future;
            this.port = port;
            log.info("Rpc server run at {}",port);
        }

        try {
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void close(){
        try {
            if(channelFuture != null){
                channelFuture.channel().closeFuture().sync();
                bossGroup.shutdownGracefully();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
