package com.tatelucky.yduts.jvm;

/**
 * @author tangsheng
 * @since 2019-11-07
 */
public class GcRootDemo {

    private byte[] bytes = new byte[100 * 1024 * 1024];

    //方法去中类的静态属性引用的对象
    //private static GcRootDemo2 demo2;
    //方法去中类的常量引用对象
    //private static final GcRootDemo3 demo2 = new GcRootDemo3();

    public static void method() {
        GcRootDemo gcRootDemo = new GcRootDemo();
        System.gc();
        System.out.println("gc ok!");
    }

    public static void main(String[] args) {
        method();
    }
}
