package com.liu.bytecode.unit1;

import java.lang.instrument.Instrumentation;

/**
 * @author liu
 * @Date 2020/10/3 15:02
 */
public class Myagent {
	public static void main(String[] args) {
		System.out.println("asdf");
	}
	/**
	 * jvm首先尝试在代理类上调用该方法
	 * 
	 * @param agentArgs
	 * @param instrumentation
	 */

	public static void premain(String agentArgs,
			Instrumentation instrumentation) {
		System.out.println("hi! javaagent:" + agentArgs);
		MyMonitorTransformer monitorTransformer = new MyMonitorTransformer();
		instrumentation.addTransformer(monitorTransformer);
	}

	/**
	 * 如果代理类上没有实现上面的方法 那么jvm会调用这个方法
	 */

	public static void premain(String agentArgs) {
		System.out.println("no agent :" + agentArgs);
	}
}
