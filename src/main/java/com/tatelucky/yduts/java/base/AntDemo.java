package com.tatelucky.yduts.java.base;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

/**
 * spring的ant的匹配模式demo
 *
 * @author tangsheng
 * @since 2020-03-06
 */
public class AntDemo {
    public static void main(String[] args) {
        String classUrl = "com.abc.efg.dao";
        String classUrl2 = "com.abcwwwww.efg.dao";
        String rule = "com.abc.**.dao";

        PathMatcher pathMatcher = new AntPathMatcher();

        System.out.println(pathMatcher.match(rule, classUrl));
        System.out.println(pathMatcher.match(rule, classUrl2));

    }
}
