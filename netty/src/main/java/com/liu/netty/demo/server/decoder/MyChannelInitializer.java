package com.liu.netty.demo.server.decoder;

import com.liu.netty.demo.decoder.MyDeocder;
import com.liu.netty.demo.decoder.MyEncoder;
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


        socketChannel.pipeline().addLast(new MyDeocder());
        socketChannel.pipeline().addLast(new MyEncoder());
        socketChannel.pipeline().addLast(new MyServerHandler());
    }
}
