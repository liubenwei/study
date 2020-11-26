package com.liu.netty.demo.client.outHandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author liu
 * @Date 2020/11/24 8:55
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
        socketChannel.pipeline().addLast(new StringDecoder(StandardCharsets.UTF_8));
        socketChannel.pipeline().addLast(new StringEncoder(StandardCharsets.UTF_8));
        socketChannel.pipeline().addLast(new MyOutMsgHandler());
        socketChannel.pipeline().addLast(new MyInMsgHandler());
    }
}
