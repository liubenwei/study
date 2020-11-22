package com.liu.netty.demo.accept.data;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        log.info("连接ip:{}", socketChannel.localAddress().getHostString());
        log.info("连接端口:{}", socketChannel.localAddress().getPort());
        socketChannel.pipeline().addLast(new MyServerHandler());
    }
}
