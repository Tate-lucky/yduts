package com.tatelucky.yduts.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者的 await -> lock -> signal 版本
 * 线程 操作 资源类 高内聚 低耦合 防止虚假唤醒
 *
 * @author tangsheng
 * @since 2019-10-29
 */
class Resource {
    private volatile Integer num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void add() {
        lock.lock();
        try {

            //多线程的判断，不要用if
            while (num != 0) {
                try {
                    // 等待
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            num++;
            System.out.println(Thread.currentThread().getName() + "\t add: " + num);
            //通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void sub() {
        lock.lock();
        try {
            while (num == 0) {
                try {
                    // 等待
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "\t sub: " + num);
            //通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}

public class ProdConsumerLockDemo {
    public static void main(String[] args) {
        Resource resource = new Resource();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                resource.add();
            }, "t1").start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                resource.sub();
            }, "t2").start();
        }
    }
}
