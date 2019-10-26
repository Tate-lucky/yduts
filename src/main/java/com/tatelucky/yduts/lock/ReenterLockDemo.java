package com.tatelucky.yduts.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReenterLockDemo,sync 可重入(递归)
 * 一定要记得lock和unlock配合使用
 *
 * @author tangsheng
 * @since 2019-10-27
 */

class Phone implements Runnable {
    public synchronized void sendMsg() {
        System.out.println(Thread.currentThread().getName() + " sendMsg");
        sendEmail();
    }

    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getName() + " sendEmail");
    }

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        get();
    }

    public void get() {
        lock.lock();
        //没有配对的话线程就会卡住
        //lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " get");
            set();
        } finally {
            lock.unlock();
        }
    }

    public void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " set");

        } finally {
            lock.unlock();
        }
    }
}

public class ReenterLockDemo {
    public static void main(String[] args) {

        Phone phone = new Phone();
        new Thread(() -> {
            phone.sendMsg();
        }, "t1").start();

        new Thread(() -> {
            phone.sendMsg();
        }, "t2").start();


        try {
            Thread.sleep(300L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t3 = new Thread(phone, "t3");
        Thread t4 = new Thread(phone, "t4");

        t3.start();
        t4.start();

    }
}
