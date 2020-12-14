package com.liu.lemon.mybatis.session;

import java.io.Closeable;

/**
 * @author liu
 * @Date 2020/12/14 19:40
 */
public interface Cursor<T> extends Closeable, Iterable<T> {

    /**
     * @return true if the cursor has started to fetch items from database.
     */
    boolean isOpen();

    /**
     * @return true if the cursor is fully consumed and has returned all elements matching the query.
     */
    boolean isConsumed();

    /**
     * Get the current item index. The first item has the index 0.
     *
     * @return -1 if the first cursor item has not been retrieved. The index of the current item retrieved.
     */
    int getCurrentIndex();
}