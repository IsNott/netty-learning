package org.nott.protobuf.client.initializer;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import org.nott.protobuf.client.handler.ProtobufClientHandler;
import org.nott.protobuf.model.DataInfo;

/**
 * @author Nott
 * @date 2024-11-28
 */
public class ProtoBufClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pip = socketChannel.pipeline();
        // Netty 中处理Protobuf数据流的解码器，用Varint32编码规则
        pip.addLast(new ProtobufVarint32FrameDecoder());
        // 为Protobuf协议的消息头部加上32位长度的整形字段
        pip.addLast(new ProtobufVarint32LengthFieldPrepender());
        // Protobuf解码器，为DataInfo.Student对象解码
        pip.addLast(new ProtobufDecoder(DataInfo.Student.getDefaultInstance()));
        // Protobuf编码器
        pip.addLast(new ProtobufEncoder());
        // 自定义的Handler
        pip.addLast(new ProtobufClientHandler());
    }
}
