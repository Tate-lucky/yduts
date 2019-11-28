package com.tatelucky.yduts.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tangsheng
 * @since 2019-10-15
 */
public class Test {
    private static final int MAXIMUM_CAPACITY = 1 << 30;


    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>(1);

        //key 和 value 都不能为空
        //map.put(null,"1");
        //map.put("1",null);

        map.put("1", "1");

        System.out.println(tableSizeFor(16));


    }

    /**
     * 变成2的整数次方数
     *
     * @param c
     * @return
     */
    private static final int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        // |0000100 与操作
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
