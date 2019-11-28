package com.tatelucky.yduts.design.single;

/**
 * 懒汉式
 *
 * @author tangsheng
 * @since 2019-11-28
 */
public class SingleDemo2 {

    private static SingleDemo2 singleDemo2 = null;

    public SingleDemo2() {
    }

    public static synchronized SingleDemo2 getInstance() {
        return null == singleDemo2 ? new SingleDemo2() : singleDemo2;
    }
}
