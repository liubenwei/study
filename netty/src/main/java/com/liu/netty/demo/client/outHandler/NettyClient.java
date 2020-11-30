package com.liu.netty.demo.client.outHandler;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author liu
 * @Date 2020/11/24 14:51
 */
public class NettyClient {
    public static void main(String[] args) {
        new NettyClient().connect("127.0.0.1", 8088);
    }

    private void connect(String host, int port) {
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workGroup)
            ;
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.AUTO_READ, true);
            bootstrap.handler(new MyChannelInitializer());
            ChannelFuture f = bootstrap.connect(host, port).sync();
//            f.channel().writeAndFlush(Unpooled.wrappedBuffer("0x02 34 68 69 68 69 0x03".getBytes()));
//            f.channel().writeAndFlush(Unpooled.wrappedBuffer("02 34 68 69 68 69 03 02 34 68 69 68 69 03".getBytes()));
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workGroup.shutdownGracefully();
        }
    }
}
