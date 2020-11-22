package com.liu.netty.demo.server.mass;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ChannelHandler.channels.add(ctx.channel());
        SocketChannel socketChannel = (SocketChannel) ctx.channel();
        System.out.println("链接报告IP:" + socketChannel.localAddress().getHostString());
        System.out.println("链接报告Port:" + socketChannel.localAddress().getPort());
        System.out.println("链接报告完毕");
        String string = "建立连接成功:" + socketChannel.localAddress().getHostString() + "\r\n";
        ctx.writeAndFlush(string);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String string = "接受的消息:" + msg + "\n";
        log.info("服务器接收的消息：{}", msg);
        ChannelHandler.channels.writeAndFlush(string);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("客户端:{}断开连接", ctx.channel().localAddress().toString());
        ChannelHandler.channels.remove(ctx.channel());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("异常信息:{}", cause.getMessage());
    }
}
