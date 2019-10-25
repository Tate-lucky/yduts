package com.tatelucky.yduts.thread;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * ABA的问题，中间被修改过，单纯比较值是无法去解决的
 *
 * @author tangsheng
 * @since 2019-10-25
 */
public class AbaDemo {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {

        System.out.println("ABA 问题的开始");
        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);

        }, "t1").start();

        new Thread(() -> {

            //让t1线运行完毕
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(atomicReference.compareAndSet(100, 9999) + "\t" + atomicReference.get());

        }, "t2").start();

        //让t2线运行完毕
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ABA 问题的结束");


        new Thread(() -> {
            int stmp = atomicStampedReference.getStamp();
            System.out.println("t3 version is: " + stmp);

            //暂停，让t4拿到同一个版本号
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println("t3 version is: " + atomicStampedReference.getStamp());

            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println("t3 version is: " + atomicStampedReference.getStamp());

        }, "t3").start();

        new Thread(() -> {
            int stmp = atomicStampedReference.getStamp();
            System.out.println("t4 version is: " + stmp);

            //暂停，让t3能够完成一次aba操作
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicStampedReference.compareAndSet(100, 999, stmp, stmp + 1) + "  t4 version is: " + atomicStampedReference.getStamp());
        }, "t4").start();
    }
}
