package com.liu.lemon.mybatis.session;

import java.util.List;

/**
 * @author liu
 * @Date 2020/12/14 19:35
 */
public interface SqlSession {

    /**
     * 查询单条记录
     *
     * @param statementId
     * @param parameter
     * @param <T>
     * @return
     */
    <T> T selectOne(String statementId, Object parameter);

    <T> Cursor<T> selectCursor(String statement, Object parameter);

    /**
     * 查询多条记录
     *
     * @param statementId
     * @param <E>
     * @return
     */
    <E> List<E> selectList(String statementId);

    /**
     * 查询多条记录
     *
     * @param statementId
     * @param <E>
     * @return
     */
    <E> List<E> selectList(String statementId, Object parameter);

    /**
     * 插入
     *
     * @param statement
     * @param parameter
     * @return
     */
    int insert(String statement, Object parameter);

    /**
     * 更新
     *
     * @param statement
     * @param parameter
     * @return
     */
    int update(String statement, Object parameter);

    /**
     * 删除
     *
     * @param statement
     * @param parameter
     * @return
     */
    int delete(String statement, Object parameter);

    /**
     * 获取配置类
     *
     * @return
     */
    Configuration getConfiguration();
}

