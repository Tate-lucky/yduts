package com.tatelucky.yduts.thread;

/**
 * @author tangsheng
 * @since 2019-11-21
 */
public class SyncDemo {
    public static volatile Object object = new Object();

    public void test() {
        synchronized (object) {
            System.out.println("obj");
        }
    }
}
