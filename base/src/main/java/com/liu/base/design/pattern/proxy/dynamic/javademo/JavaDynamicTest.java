package com.liu.base.design.pattern.proxy.dynamic.javademo;

import java.lang.reflect.Proxy;

/**
 * @author liu
 * @Date 2020/9/28 16:38
 */
public class JavaDynamicTest {
    public static void main(String[] args) {
        ActorProxy proxy = new ActorProxy();
        Actor actor = (Actor) proxy.newInstance(new ActorImpl());
        actor.act();

    }
}
