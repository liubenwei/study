package com.liu.lemon.mybatis.session;

/**
 * @author liu
 * @Date 2020/12/15 16:46
 */
public interface SqlSessionFactory {
    /**
     * 开启数据库会话
     *
     * @return sqlSession
     */
    SqlSession openSqlSession();
}
