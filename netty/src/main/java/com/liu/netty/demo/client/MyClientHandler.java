package com.liu.netty.demo.client;

import com.liu.netty.demo.server.mass.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liu
 * @date 2020/11/22 17:20
 */
@Slf4j
public class MyClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        SocketChannel socketChannel = (SocketChannel) ctx.channel();
        System.out.println("链接报告IP:" + socketChannel.localAddress().getHostString());
        System.out.println("链接报告Port:" + socketChannel.localAddress().getPort());
        System.out.println("链接报告完毕");
        String string = "建立连接成功:" + socketChannel.localAddress().getHostString() + "\r\n";
        ctx.writeAndFlush("246878324699632482693");
//        ctx.writeAndFlush("2468696869");
//        ctx.writeAndFlush("3");
//        ctx.writeAndFlush("23468696869324686968693");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String string = "接受的消息:" + msg + "\n";
        log.info("{}",msg);
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
