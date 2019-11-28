package com.tatelucky.yduts.design.single;

/**
 * holder 模式
 * 推荐使用
 *
 * @author tangsheng
 * @since 2019-11-28
 */
public class SingleDemo4 {

    private static class Holder {
        private static SingleDemo4 singleDemo = new SingleDemo4();
    }

    public SingleDemo4() {

    }

    public static SingleDemo4 getInstance() {
        return Holder.singleDemo;
    }
}
