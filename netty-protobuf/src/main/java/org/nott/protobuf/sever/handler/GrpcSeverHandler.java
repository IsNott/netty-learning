package org.nott.protobuf.sever.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import org.nott.protobuf.model.DataInfo;

/**
 * @author Nott
 * @date 2024-11-28
 */
@Slf4j
public class GrpcSeverHandler extends SimpleChannelInboundHandler<DataInfo.Student> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DataInfo.Student student) throws Exception {
        log.info("接收到Student反序列化对象...");
        log.info(student.getName());
        log.info(student.getAddress());
        log.info(student.getAge() + "");
    }
}
