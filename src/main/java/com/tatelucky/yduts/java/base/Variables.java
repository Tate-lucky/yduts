package com.tatelucky.yduts.java.base;

/**
 * 类变量:JVM的方法区
 * 成员变量:堆内存
 * 局部变量:栈内存中
 *
 * @author tangsheng
 * @since 2019-07-23
 */
public class Variables {
    /**
     * 类变量
     */
    private static int a;

    /**
     * 成员变量
     */
    private int b;

    /**
     * 局部变量
     *
     * @param c
     */
    public void test(int c) {
        int d;
    }

    public static void main(String[] args) {
        print("aa");  //实参"aa"
    }

    private static void print(String str) {  //形参str
        System.out.println(str);
    }
}
