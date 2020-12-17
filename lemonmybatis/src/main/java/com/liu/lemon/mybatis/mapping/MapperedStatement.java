package com.liu.lemon.mybatis.mapping;

import com.liu.lemon.mybatis.constants.Constants;

/**
 * @author liu
 * @Date 2020/12/15 14:10
 */
public class MapperedStatement {
    /**
     * mapper文件的namespace
     */
    private String namespace;

    /**
     * mapper文件的id
     */
    private String sqlId;

    private String sql;

    private String resultType;

    private Constants.SqlType sqlCommandType;

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getSqlId() {
        return sqlId;
    }

    public void setSqlId(String sqlId) {
        this.sqlId = sqlId;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public Constants.SqlType getSqlCommandType() {
        return sqlCommandType;
    }

    public void setSqlCommandType(Constants.SqlType sqlCommandType) {
        this.sqlCommandType = sqlCommandType;
    }
}
