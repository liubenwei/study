package com.liu.lemon.mybatis.session;

import com.liu.lemon.mybatis.binding.MapperRegistry;
import com.liu.lemon.mybatis.mapping.MapperedStatement;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * mybatis核心配置类
 *
 * @author liu
 * @Date 2021/1/17 14:12
 */
public class Configuration {
    /**
     * 配置项
     */
    public static Properties PROPS = new Properties();
    /**
     * mapper代理注册器
     */
    protected final MapperRegistry mapperRegistry = new MapperRegistry();


    /**
     * mapper文件 的select/update语句id和sql语句的属性
     */
    private final Map<String, MapperedStatement> mapperedStatementMap = new HashMap<>();


    public <T> void addMapper(Class<T> type) {
        this.mapperRegistry.addMapper(type);
    }

    public <T> T getMapper(Class<?> type, SqlSession sqlSession) {
        return (T) this.mapperRegistry.getMapper(type, sqlSession);
    }
}
