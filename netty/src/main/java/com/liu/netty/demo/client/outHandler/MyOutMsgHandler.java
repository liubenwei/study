package com.liu.netty.demo.client.outHandler;


import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author liu
 * @Date 2020/11/24 14:51
 */
public class MyOutMsgHandler implements ChannelHandler {
    @Override
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        StringBuilder bs = new StringBuilder();
        bs.length();
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) throws Exception {

    }
}
