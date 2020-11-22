package com.liu.netty.demo.server.acceptAndSend;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;

@Slf4j
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        log.info("deocde连接ip:{}", socketChannel.localAddress().getHostString());
        log.info("decode连接端口:{}", socketChannel.localAddress().getPort());
        //基于换行符
        socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
        //基于指定字符串【这里指定换行符，这样等同于LineBasedFrameDecoder】
        //socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024,false, Delimiters.lineDelimiter()));
        //基于最大长度
//        socketChannel.pipeline().addLast(new FixedLengthFrameDecoder(1024));
        //解码转换成string
        socketChannel.pipeline().addLast(new StringDecoder(Charset.forName("UTF-8")));

        socketChannel.pipeline().addLast(new MyServerHandler());
    }
}
