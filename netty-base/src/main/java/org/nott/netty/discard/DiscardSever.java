package org.nott.netty.discard;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * reference: <a href="https://waylau.gitbooks.io/netty-4-user-guide/content/Getting-Started/Writing-a-Discard-Server.html"/>
 * 抛弃式服务端
 * @author Nott
 * @date 2024-7-24
 */
@Slf4j
public class DiscardSever {

    private Integer port;

    public DiscardSever(Integer port) {
        this.port = port;
    }

    public void run() throws Exception{
        NioEventLoopGroup boss = new NioEventLoopGroup();
        try {
            // NioEventLoopGroup 是用来处理 I/O 操作的多线程事件循环器
            // 服务端的应用有两个Group
            // 第一个经常被叫做‘boss’，用来接收进来的连接。第二个经常被叫做‘worker’，用来处理已经被接收的连接，一旦‘boss’接收到连接，就会把连接信息注册到‘worker’上。
            // 如何知道多少个线程已经被使用，如何映射到已经创建的 Channel上都需要依赖于 EventLoopGroup 的实现，并且可以通过构造函数来配置他们的关系。
            NioEventLoopGroup worker = new NioEventLoopGroup();

            // 启动辅助类
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boss,worker)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new DiscardHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG,128)
                    .childOption(ChannelOption.SO_KEEPALIVE,true);

            // 绑定端口
            ChannelFuture cf = bootstrap.bind(port).sync();
            log.info("Discard server run at {}",port);
            // 等待socket关闭
            cf.channel().closeFuture().sync();
        } finally {
            boss.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        Integer port = 80;
        DiscardSever sever = new DiscardSever(port);
        try {
            sever.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
