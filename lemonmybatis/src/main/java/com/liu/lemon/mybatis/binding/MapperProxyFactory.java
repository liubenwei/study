package com.liu.lemon.mybatis.binding;

import com.liu.lemon.mybatis.session.SqlSession;

import java.lang.reflect.Proxy;

/**
 * @author liu
 * @Date 2020/12/15 10:58
 */
public class MapperProxyFactory<T> {
    private final Class<T> mapperInterface;

    /**
     * 初始化方法
     *
     * @param mapperInterface
     */
    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    /**
     * 根据sqlSession创建一个代理
     *
     * @return
     */
    public T newInstance(SqlSession sqlSession) {
        MapperProxy<T> mapperProxy = new MapperProxy<T>(sqlSession, this.mapperInterface);
        return newInstance(mapperProxy);
    }

    /**
     * 根据mapper代理生成 一个实例
     *
     * @param mapperProxy mapper代理
     * @return
     */
    public T newInstance(MapperProxy<T> mapperProxy) {
        return (T) Proxy.newProxyInstance(this.mapperInterface.getClassLoader(), new Class[]{this.mapperInterface}, mapperProxy);
    }
}
