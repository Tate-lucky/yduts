package com.tatelucky.yduts.design.single;

/**
 * 枚举模式
 *
 * @author tangsheng
 * @since 2019-11-28
 */
public enum SingleDemo5 {
    INSTANCE;

    SingleDemo5() {
        System.out.println("init");
    }

    public static void method() {
        //调用此方法会主动使用 SingleDemo5,INSTANCE 会被实例化
    }

    public static SingleDemo5 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        SingleDemo5.getInstance();
    }
}

