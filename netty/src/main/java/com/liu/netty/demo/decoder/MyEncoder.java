package com.liu.netty.demo.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author liu
 * @date 2020/11/22 20:12
 */
public class MyEncoder extends MessageToByteEncoder {
    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        String msgString = msg.toString();
        byte[] bytes = msgString.getBytes();
        byte[] sendMsg = new byte[bytes.length + 2];
        System.arraycopy(bytes, 0, sendMsg, 1, bytes.length);
        sendMsg[0] = 0x02;
        sendMsg[sendMsg.length - 1] = 0x03;
        out.writeInt(sendMsg.length);
        out.writeBytes(sendMsg);
    }
}
