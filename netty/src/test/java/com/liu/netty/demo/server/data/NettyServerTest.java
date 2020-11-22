package com.liu.netty.demo.server.data;

import org.junit.Test;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class NettyServerTest {
    @Test
    public void nettySendDataTest(){
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress("127.0.0.1" , 8088));
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream  = socket.getOutputStream();
            outputStream.write("02 hello1\n03".getBytes());
            outputStream.flush();
            outputStream.write("0x02 hello1\n0x03".getBytes());
            outputStream.flush();
            outputStream.write("02 hello1\n03".getBytes());
            outputStream.flush();
            InputStream ips = socket.getInputStream();
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            String s = "";
            while((s = br.readLine()) != null)
                System.out.println(s);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void nettySendDataTest2(){
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress("127.0.0.1" , 8088));
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream  = socket.getOutputStream();
            outputStream.write("hello2\n".getBytes());
            outputStream.flush();
            InputStream ips = socket.getInputStream();
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            String s = "";
            while((s = br.readLine()) != null)
                System.out.println(s);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}