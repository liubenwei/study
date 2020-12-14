package com.liu.lemon.mybatis.constants;

/**
 * @author liu
 * @Date 2020/12/14 19:25
 */
public interface Constants {
    /**
     * 编码格式
     */
    String CHARSET_UTF8 = "UTF-8";


    /**
     * mapper的地址 配置
     */
    String MAPPER_LOCATION = "mapper.location";

    /**
     * 数据库驱动
     */
    String DB_DEIVER_CONF = "db.driver";

    /**
     * 数据库地址
     */
    String DB_URL = "db.url";

    /***
     * 数据库用户名
     */
    String DB_USERNAME = "db.username";

    /**
     * 数据库密码
     */
    String DB_PASSWORD = "db.password";


    /***
     * mapper文件后缀
     */
    String MAPPER_FILE_SUFFIX = ".xml";

    String XML_ROOT_LABEL = "mapper";

    String XML_ELEMENT_ID = "id";

    String XML_SELECT_NAMESPACE = "namespace";

    String XML_SELECT_RESULTTYPE = "resultType";

    /**
     * SQL枚举类型
     */

    public enum SqlType {
        //@formatt
        SELECT("select"),
        INSERT("insert"),
        UPDATE("update"),
        DEFAULT("default");
        private String value;

        private SqlType(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }
}
