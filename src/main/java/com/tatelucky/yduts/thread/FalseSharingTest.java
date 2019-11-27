package com.tatelucky.yduts.thread;

import lombok.Data;

/**
 * 伪共享
 * 避免伪共享主要是为了不要让不相干的变量出现在同一个缓存中
 * 可以通过下面三种方法避免
 *
 * @author tangsheng
 * @since 2019-11-20
 */
@Data
class Pointer {
    volatile long x;
    //加了这一行速度从2000多降到700多 一个缓存64字节，long 8字节
    long p1, p2, p3, p4, p5, p6, p7;
    volatile long y;
}

class Pointer2 {
    MyLong x = new MyLong();
    MyLong y = new MyLong();
}

class MyLong {
    volatile long val;
    long p1, p2, p3, p4, p5, p6, p7;
}

//启动参数添加 -XX:-RestrictContended  ConcurrentHashMap的size方法就用到了这个，CounterCell
@sun.misc.Contended
class MyLong2 {
    volatile long val;
}

public class FalseSharingTest {
    public static void main(String[] args) {
        test(new Pointer());
    }

    private static void test(Pointer p) {
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000000; i++) {
                p.x++;
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000000; i++) {
                p.y++;
            }
        }, "t2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("time: " + (end - start));
        System.out.println(p);
    }
}
