package com.liu.netty.demo.acceptAndSend;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String string = "接受的消息:" + msg + "\n";
        log.info("接受到的消息：{}", msg);
        ByteBuf buf = Unpooled.buffer(string.getBytes().length);
        buf.writeBytes(string.getBytes("UTF-8"));
        ctx.writeAndFlush(buf);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("客户端:{}断开连接", ctx.channel().localAddress().toString());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("异常信息:{}", cause.getMessage());
    }
}
