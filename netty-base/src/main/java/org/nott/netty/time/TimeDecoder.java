package org.nott.netty.time;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;
import org.nott.netty.time.pojo.UnixTime;

import java.util.List;

/**
 * @author Nott
 * @date 2024-7-24
 */
@Slf4j
public class TimeDecoder extends ByteToMessageDecoder {
    // 每当有新数据接收的时候，ByteToMessageDecoder 都会调用 decode() 方法来处理内部的那个累积缓冲
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        // 针对TimeServer发送的四个字节的数据进行处理
        if(byteBuf.readableBytes() < 4){
            return;
        }
        long unsignedInt = byteBuf.readUnsignedInt();
        log.info("dncode time value===={}",unsignedInt);
//        list.add(byteBuf.readBytes(4));
        list.add(new UnixTime(unsignedInt));
    }
}
