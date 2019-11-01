package com.tatelucky.yduts.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock 绑定多个 condition demo
 * 输出5个5 10个10 15个15 循环10次
 * 一把锁，3个钥匙
 *
 * @author tangsheng
 * @since 2019-10-31
 */
class Cache {

    private volatile int num = 1;//1 a 2 b 3 c
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();


    public void prit5() {
        lock.lock();
        try {
            //判断：while
            while (num != 1) {
                condition.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t 5");
            }
            //通知线程2
            num = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void prit10() {

        lock.lock();
        try {
            //判断：while
            while (num != 2) {
                condition2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t 10");
            }

            //通知线程3
            num = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void prit15() {

        lock.lock();
        try {
            //判断：while
            while (num != 3) {
                condition3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t 15");
            }

            //通知线程1
            num = 1;
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ConditionLockDemo {
    public static void main(String[] args) {
        Cache cache = new Cache();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                cache.prit5();
            }, "t1").start();

            new Thread(() -> {
                cache.prit10();
            }, "t2").start();

            new Thread(() -> {
                cache.prit15();
            }, "t3").start();

        }
    }
}
