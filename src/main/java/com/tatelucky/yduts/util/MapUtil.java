package com.tatelucky.yduts.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author tangsheng
 * @since 2019-04-30
 */
public class MapUtil {

    public static final String COMMA_EN = ",";

    public static final String EQUAL = "=";


    /**
     * 安全地向一个map的list型value中增加一个条目
     *
     * @param map
     * @param key  map的key值，若增加时该key值不存在，则先创建
     * @param item 条目值
     */
    public static <KEY, ITEM> void putValueItem(Map<KEY, List<ITEM>> map, KEY key, ITEM item) {
        List<ITEM> poss = map.get(key);
        if (poss == null) {
            poss = new ArrayList<ITEM>();
            map.put(key, poss);
        }
        //记住位置
        poss.add(item);
    }

    public static Map<String, String> mapStringToMap(String str) {
        str = str.substring(1, str.length() - 1);
        String[] strs = str.split(COMMA_EN);
        Map<String, String> map = new HashMap<>();
        for (String s : strs) {
            String key = s.split(EQUAL)[0];
            String value = s.split(EQUAL)[1];
            map.put(key, value);
        }
        return map;
    }

    /**
     * map包含所有的key
     *
     * @param keys
     * @param map
     * @return
     */
    public static boolean containsAllKey(List<Object> keys, Map map) {
        for (Object o : keys) {
            if (!map.containsKey(o)) {
                return false;
            }
        }
        return true;
    }

    /**
     * list转map
     *
     * @param collection
     * @param fun
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> toMap(Collection<V> collection, Function<V, K> fun) {
        if (collection == null) {
            return Collections.emptyMap();
        }
        return collection.stream().collect(Collectors.toMap(fun, e -> e, (e1, e2) -> e2));
    }

    /**
     * 返回默认值
     *
     * @param map
     * @param k
     * @param defaultValue
     * @param <T>
     * @param <K>
     * @return
     */
    public static <T, K> T defaultValue(Map<K, T> map, K k, T defaultValue) {
        T t = map.get(k);
        if (t == null) {
            return defaultValue;
        }
        return t;
    }
}
