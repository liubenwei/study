package com.liu.base.design.pattern.proxy.dynamic.javademo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liu
 * @Date 2020/9/28 16:40
 */
public class ActorProxy implements InvocationHandler {
	private Actor actor;

	public Object newInstance(Actor actor) {
		this.actor = actor;
		return Proxy.newProxyInstance(actor.getClass().getClassLoader(),
				actor.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("进入代理");
		actor.act();
		System.out.println("完成代理");
		return null;
	}
}
