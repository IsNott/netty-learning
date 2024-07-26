package org.nott.chat.socket.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import lombok.Data;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Nott
 * @date 2024-7-24
 */

@Data
public class ChatClient {

    private String host;

    private Integer port;

    private NioEventLoopGroup boss;

    private Channel channel;

    public ChatClient(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    public void run() throws Exception{
        boss = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(boss)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel sc) throws Exception {
                            ChannelPipeline pipeline = sc.pipeline();
                            pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
                            pipeline.addLast("decoder", new StringDecoder());
                            pipeline.addLast("encoder", new StringEncoder());
                            pipeline.addLast("handler",new ChatClientHandler());
                        }
                    })
                    .option(ChannelOption.SO_KEEPALIVE,true);

            ChannelFuture future = bootstrap.connect(host, port).sync();
            this.channel = future.channel();
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                channel.writeAndFlush(in.readLine() + "\r\n");
            }

        } finally {
            boss.shutdownGracefully();
        }
    }
}
