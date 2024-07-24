package org.nott.rpc.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.DefaultThreadFactory;
import lombok.Data;
import org.nott.rpc.RpcRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Nott
 * @date 2024-7-23
 */
@Data
public class NettySocketClient {

    private String ip;

    private Integer port;

    public static final Logger log = LoggerFactory.getLogger(NettySocketClient.class);

    public static NettySocketClient DEFAULT(){
        return new NettySocketClient();
    }

    private Bootstrap bootstrap;

    private SocketChannel channel;

    private ChannelFuture channelFuture;

    private EventLoopGroup group;

    public NettySocketClient() {
    }

    public NettySocketClient(String ip, Integer port) {
        NettySocketClient client = new NettySocketClient();
        client.setIp(ip);
        client.setPort(port);
        client.connect(ip, port);
    }

    public void connect(String inetHost, int inetPort){
        DefaultThreadFactory boss = new DefaultThreadFactory("boss", Thread.MAX_PRIORITY);

        NioEventLoopGroup bGroup = new NioEventLoopGroup(1, boss);
        this.group = bGroup;

        Bootstrap bootstrap = new Bootstrap();

        bootstrap.group(bGroup)
                .remoteAddress(inetHost,inetPort)
                .channel(NioSocketChannel.class)
                .handler(new SocketClientHandler());

        this.bootstrap = bootstrap;

        try {
            ChannelFuture future = bootstrap.connect(inetHost, inetPort).sync();
            if(future.isSuccess()){
                log.info("Rpc client connect to {}:{}", inetHost, inetPort);
                this.channel = (SocketChannel) future.channel();
                this.channelFuture = future;
            }

            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMsg(RpcRequest rpcRequest){
        ChannelFuture future = this.getChannelFuture();
        future.channel().writeAndFlush("hi from client");
    }

    public void sendMsg(){
        ChannelFuture future = this.getChannelFuture();
        future.channel().writeAndFlush("hi from client");
    }

    public void close(){
        try {
            if(this.channelFuture != null){
                this.channelFuture.channel().closeFuture().sync();
                this.group.shutdownGracefully();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
