package com.tatelucky.yduts.design.single;

/**
 * 饿汉模式
 *
 * @author tangsheng
 * @since 2019-11-28
 */
public class SingleDemo1 {

    public SingleDemo1() {
    }

    public static SingleDemo1 getInstance() {
        return new SingleDemo1();
    }
}
