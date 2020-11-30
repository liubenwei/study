package com.liu.netty.demo.server.outHander;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author liu
 * @Date 2020/11/24 14:57
 */
@Slf4j
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        log.info("连接ip:{}", socketChannel.localAddress().getHostString());
        log.info("连接端口:{}", socketChannel.localAddress().getPort());

        socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
        socketChannel.pipeline().addLast(new StringDecoder(StandardCharsets.UTF_8));
        socketChannel.pipeline().addLast(new StringEncoder(StandardCharsets.UTF_8));
        socketChannel.pipeline().addLast(new MyServerHandler());
    }


}
