package org.nott.grpc.sever.initializer;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import org.nott.grpc.sever.handler.GrpcSeverHandler;
import org.nott.grpc.model.DataInfo;

/**
 * @author Nott
 * @date 2024-11-28
 */
public class GrpcServiceInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pip = socketChannel.pipeline();
        pip.addLast(new ProtobufVarint32FrameDecoder());
        pip.addLast(new ProtobufDecoder(DataInfo.Student.getDefaultInstance()));
        pip.addLast(new ProtobufVarint32LengthFieldPrepender());
        pip.addLast(new ProtobufEncoder());
        pip.addLast(new GrpcSeverHandler());
    }
}
