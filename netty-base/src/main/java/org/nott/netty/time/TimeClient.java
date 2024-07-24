package org.nott.netty.time;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Time客户端
 * @author Nott
 * @date 2024-7-24
 */
public class TimeClient {

    public static void main(String[] args) {
        // 在 Netty 中,编写服务端和客户端最大的并且唯一不同的使用了不同的BootStrap 和 Channel的实现
        Integer port = 99;
        String host = "localhost";

        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // BootStrap 和 ServerBootstrap 类似,不过他是对非服务端的 channel 而言，
            // 比如客户端或者无连接传输模式的 channel
            Bootstrap bootstrap = new Bootstrap();

            //如果你只指定了一个 EventLoopGroup，那他就会即作为一个 boss group ，
            // 也会作为一个 workder group，尽管客户端不需要使用到 boss worker
            bootstrap.group(workerGroup)
                    // 代替NioServerSocketChannel的是NioSocketChannel,这个类在客户端 channel 被创建时使用
                    .channel(NioSocketChannel.class)
                    // 客户端的 SocketChannel 没有父亲，因此没有childOption
                    .option(ChannelOption.SO_KEEPALIVE,true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            // 先对数据进行解码，再处理数据
                            socketChannel.pipeline().addLast(new TimeDecoder(), new TimeClientHandler());
                        }
                    });

            // 用 connect() 方法代替了 bind() 方法
            ChannelFuture channelFuture = bootstrap.connect(host, port).sync();

            channelFuture.channel().closeFuture().sync();
            System.out.println("Time sever connect to " + host + ":" + port);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
