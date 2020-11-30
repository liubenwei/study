package com.liu.netty.demo.client.outHandler;


import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * @author liu
 * @Date 2020/11/24 14:51
 */
public class MyOutMsgHandler extends ChannelOutboundHandlerAdapter {
    @Override
    public void read(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("channelOut.read 发来消息\n");
        super.read(ctx);
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        ctx.writeAndFlush("channelOut.write 发来消息\n");
        super.write(ctx, msg, promise);
    }
}
