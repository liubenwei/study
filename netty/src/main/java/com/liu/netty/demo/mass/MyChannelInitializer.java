package com.liu.netty.demo.mass;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;

@Slf4j
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        log.info("连接ip:{}", socketChannel.localAddress().getHostString());
        log.info("连接端口:{}", socketChannel.localAddress().getPort());

        socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
        socketChannel.pipeline().addLast(new StringDecoder(Charset.forName("UTF-8")));
        socketChannel.pipeline().addLast(new StringEncoder(Charset.forName("UTF-8")));
        socketChannel.pipeline().addLast(new MyServerHandler());
    }
}
