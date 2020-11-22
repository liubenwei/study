package com.liu.netty.demo.mass;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @author liu
 * @date 2020/11/22 16:41
 */
public class ChannelHandler {
    //用于存放用户的Channel信息 也可以建立map模拟不同的消息群
    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
}
