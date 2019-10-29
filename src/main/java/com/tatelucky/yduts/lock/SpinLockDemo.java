package com.tatelucky.yduts.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁的简单实现
 * 不过这种简单的实现方式会十分的占用cpu资源，所以有clh队列·
 * 好处，非阻塞
 *
 * @author tangsheng
 * @since 2019-10-27
 */
class SpinLock {
    private AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "\t lock");
        //不阻塞，循环的去获取
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    public void unlock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName() + "\t unlock");
    }
}


public class SpinLockDemo {
    public static void main(String[] args) {
        SpinLock spinLock = new SpinLock();

        new Thread(() -> {
            spinLock.lock();
            //spinLock.lock();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLock.unlock();
        }, "t1").start();

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            spinLock.lock();
            spinLock.unlock();
        }, "t2").start();
    }
}
