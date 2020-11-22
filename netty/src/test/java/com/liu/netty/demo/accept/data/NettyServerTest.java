package com.liu.netty.demo.accept.data;

import io.netty.channel.ChannelFuture;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import static org.junit.Assert.*;

public class NettyServerTest {
    @Test
    public void nettySendDataTest(){
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress("127.0.0.1" , 8088));
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream  = socket.getOutputStream();
            outputStream.write("hello\n".getBytes());
            outputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}