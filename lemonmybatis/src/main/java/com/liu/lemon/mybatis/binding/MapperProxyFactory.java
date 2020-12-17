package com.liu.lemon.mybatis.binding;

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
    public T newInstance() {
        MapperProxy<T> mapperProxy =
    }
}
