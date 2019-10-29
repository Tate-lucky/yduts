package com.tatelucky.yduts.thread;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatchDemo
 * 让一些线程阻塞await直到另一些线程完成一系列的操作后才被唤醒，直到减到0
 * 倒计数
 *
 * @author tangsheng
 * @since 2019-10-27
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        closeDoor();
    }

    private static void closeDoor() {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " \t + get out");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        try {
            //阻塞当前线程
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("shutdown");
    }
}
