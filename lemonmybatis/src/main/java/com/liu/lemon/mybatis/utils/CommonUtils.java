package com.liu.lemon.mybatis.utils;

import java.util.Collection;
import java.util.Map;

/**
 * @author liu
 * @Date 2020/12/15 16:15
 */
public class CommonUtils {
    public static boolean isNotEmpty(String src) {
        return src != null && src.trim().length() > 0;
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return collection != null && !collection.isEmpty();
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return map != null && !map.isEmpty();
    }

    public static boolean isNotEmpty(Object[] arr) {
        return arr != null && arr.length > 0;
    }

    public static String stringTrim(String src) {
        return src != null ? src.trim() : src;
    }
}
