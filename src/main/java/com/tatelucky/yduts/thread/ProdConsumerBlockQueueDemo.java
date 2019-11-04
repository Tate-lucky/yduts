package com.tatelucky.yduts.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者消费者的 阻塞队列版本
 * 多线程情况下千万别要 ++ -- 操作！！！
 * 不需要自己去控制wait notify，也不需要去await 和 signal，操作起来很麻烦，现在根本不需要去处理，只要控制一个flag
 *
 * @author tangsheng
 * @since 2019-10-29
 */
class Ziyuan {
    //默认消费
    private volatile boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    //适配所有的队列，不是是专门给某个队列，设计成接口，而不是类，通用！
    BlockingQueue blockingQueue = null;

    public Ziyuan(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
        //方便查错，一般用log吧
        System.out.println("this blockingQueue is: " + blockingQueue.getClass().getName());
    }

    public BlockingQueue getBlockingQueue() {
        return blockingQueue;
    }

    public void setBlockingQueue(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void add() throws Exception {
        //多线程用while！！！
        String data = null;
        boolean returnValue;
        while (flag) {
            data = atomicInteger.incrementAndGet() + "";
            returnValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (returnValue) {
                System.out.println(Thread.currentThread().getName() + "\t add success data is: " + data);
            } else {
                System.out.println(Thread.currentThread().getName() + "\t add fail");
            }
        }
        System.out.println(Thread.currentThread().getName() + "\t falg is false");
    }

    public void desc() throws Exception {
        Object returnVal = null;
        while (flag) {
            returnVal = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (null == returnVal || returnVal.equals("")) {
                flag = false;
                System.out.println(Thread.currentThread().getName() + "\t can not get data, falg is false");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t desc success returnVal is: " + returnVal);

        }
    }

    public void stop() {
        this.flag = false;
    }
}


public class ProdConsumerBlockQueueDemo {
    public static void main(String[] args) {
        Ziyuan ziyuan = new Ziyuan(new ArrayBlockingQueue(10));


        new Thread(() -> {
            try {
                ziyuan.add();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "ADD").start();

        new Thread(() -> {
            try {
                ziyuan.desc();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "desc").start();

        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //这里是强制停止，队列里面可能还有没处理完成，但是一般可以在外围去处理判断后去去调用stop
        ziyuan.stop();
    }
}
