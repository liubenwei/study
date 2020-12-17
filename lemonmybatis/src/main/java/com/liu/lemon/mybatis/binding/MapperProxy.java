package com.liu.lemon.mybatis.binding;

import com.liu.lemon.mybatis.session.SqlSession;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author liu
 * @Date 2020/12/15 14:17
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {
    private static final long serialVersionUID = -6432020415256547370L;

    private final SqlSession sqlSession;
    private final Class<T> mapperInterface;

    public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if (Object.class.equals(method.getDeclaringClass())) {

            }
        } catch (Exception e) {

        }
        return null;
    }

    public Object execute(Method method, Object[] args) {
        String statementId = this.mapperInterface.getName() + "." + method.getName();
        return null;
    }
}
