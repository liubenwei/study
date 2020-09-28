package com.liu.juc.base;

/**
 * @author liu
 * @Date 2020/9/28 11:51
 */
public class ThreadBase {
    public static final String PREFIX = "liu-";

    public static void main(String[] args) {

    }

    public static Thread threadNameWithStream(final int intName) {
        return new Thread(() -> System.out.println(Thread.currentThread().getName()), PREFIX + intName);
    }
}
