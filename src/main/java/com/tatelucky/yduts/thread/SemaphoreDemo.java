package com.tatelucky.yduts.thread;

import java.util.concurrent.Semaphore;

/**
 * SemaphoreDemo
 * 其实就是为了抢资源,多个线程抢多个资源的场景，甚至可以去代替sync和reetrantlock这种（一个资源的场景）
 * 相比较countdownlatch和syclicbarrier 他可以增加，减少，比他们可以使用的场景多了
 *
 * @author tangsheng
 * @since 2019-10-28
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        //默认非公平锁实现
        Semaphore semaphore = new Semaphore(3, false);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    //等同acquire(1)
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t get");
                    Thread.sleep(3000L);
                    //等同release(1)
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                }
            }, String.valueOf(i)).start();
        }
    }
}
