package com.liu.lemon.mybatis.session;

import jdk.internal.util.xml.impl.Input;

import java.io.InputStream;

/**
 * @author liu
 * @Date 2020/12/15 16:48
 */
public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(String fileName) {
        InputStream inputStream = SqlSessionFactoryBuilder.class.getClassLoader().getResourceAsStream(fileName);

    }

    public SqlSessionFactory build(InputStream inputStream) {

    }
}
