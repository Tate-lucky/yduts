package com.tatelucky.yduts.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupportDemo
 *
 * @author tangsheng
 * @since 2019-11-20
 */
public class LockSupportDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            //阻塞
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t start");
        }, "t1");

        //提前unpark
        LockSupport.unpark(t1);

        t1.start();

        System.out.println("main start");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //唤醒t1
        LockSupport.unpark(t1);
    }
}
