package com.tatelucky.yduts.guava;

import com.google.common.collect.HashMultimap;

import java.util.Set;

/**
 * 可以用来做一些信息的聚合
 *
 * @author tangsheng
 * @since 2019-10-11
 */
public class MultimapStudy {
    public static void main(String[] args) {
        HashMultimap<Integer, Integer> map = HashMultimap.create();
        map.put(1, 2);
        map.put(1, 3);
        map.put(1, 2);

        map.put(2, 3);

        map.put(4, 2);
        map.put(4, 3);
        map.put(4, 2);
        map.put(4, 3);


        System.out.println(map.get(1));

        Set<Integer> a = map.get(4);
        System.out.println(a);
    }
}
