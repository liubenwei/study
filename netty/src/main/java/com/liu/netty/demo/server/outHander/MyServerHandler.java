package com.liu.netty.demo.server.outHander;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liu
 * @Date 2020/11/24 14:57
 */
@Slf4j
public class MyServerHandler extends ChannelInboundHandlerAdapter {
    /**
     * 当客户端主动连接服务端的连接后，这个通道就是活跃的。也就是客户端与服务端建立了通信通信并且可以传输数据
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        SocketChannel channel = (SocketChannel) ctx.channel();
        log.info("channelId:{}", channel.id());
        log.info("连接ip:{}", channel.localAddress().getHostString());
        log.info("连接port:{}", channel.localAddress().getPort());
        String string = "连接成功";

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("断开连接");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("接受的消息:{}", msg);
//        ctx.writeAndFlush("服务端收到消息" + msg + "\r\n");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        log.error(cause.getMessage());
    }
}
