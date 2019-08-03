package com.tatelucky.yduts.java.base;

/**
 * @author tangsheng
 * @since 2019-07-23
 */
public class ValueOrReference {
    public static void main(String[] args) {
        int i = 10;
        System.out.println(i);


    }

    private static void printInt(int i) {
        i = 20;
        System.out.println(i);
    }
}
