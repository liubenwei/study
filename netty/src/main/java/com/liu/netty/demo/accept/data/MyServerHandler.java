package com.liu.netty.demo.accept.data;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf bu = (ByteBuf) msg;
        byte[] msgByte = new byte[bu.readableBytes()];
        bu.readBytes(msgByte);
        log.info("接受到的消息：{}", new String(msgByte));
    }
}
