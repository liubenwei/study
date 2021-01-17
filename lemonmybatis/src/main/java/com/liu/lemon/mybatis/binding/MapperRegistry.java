package com.liu.lemon.mybatis.binding;

import com.liu.lemon.mybatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu
 * @Date 2020/12/15 10:54
 */
public class MapperRegistry {
    private final Map<Class<?>, MapperProxyFactory<?>> knowMappers = new HashMap<>();

    /**
     * 注册代理工厂
     *
     * @param type
     * @param <T>
     */
    public <T> void addMapper(Class<T> type) {
        this.knowMappers.put(type, new MapperProxyFactory<T>(type));
    }

    /**
     * 获取代理工厂实例
     *
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) this.knowMappers.get(type);
        return mapperProxyFactory.newInstance(sqlSession);
    }
}
