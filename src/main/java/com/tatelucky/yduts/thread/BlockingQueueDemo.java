package com.tatelucky.yduts.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * BlockingQueueDemo
 * <p>
 * ArrayBlockingQueue 基于数组的fifo的有界队列
 * LinkedBlockingQueue 基于链表的fifo的有界队列 默认最大Integer.MAX 的阻塞队列 比价坑，太大了，基本是个无界队列21亿
 * PriorityBlockQueue 优先级无界阻塞列队
 * DealyQueue 优先级延迟无界阻塞队列
 * SynchronousQueue 不存储元素的阻塞队列，每个插入操作必须等到另一个线程调用移除参数，否则一直阻塞，也叫单个元素队列
 * LinkedTransferQueue 链表无界阻塞队列
 * LinkedBlockingDueue 链表双向阻塞队列  Deque:双向队列 Queue:单向队列
 * <p>
 * 阻塞队列：队列空的时候   获取时候被阻塞
 * 队列满的时候   添加的时候会被阻塞
 * 方法   异常       特殊值       阻塞       超时
 * 插入  add(e)     offer(e)    put(e)   offer(e,t,unit)
 * 移除  remove     poll        take     pool(t,unit)
 * 检查  element    peek         \             \
 *
 * 适用于一些生产者消费者模型的地方，线程池，消息中间件
 *
 * @author tangsheng
 * @since 2019-10-28
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(2);
        BlockingQueue queue2 = new LinkedBlockingQueue();
        //非公平
        BlockingQueue<String> queue3 = new SynchronousQueue();

        //--------------------------异常 超过容量，没有元素报异常 不建议使用--------------------------

        System.out.println(queue.add(1));
        System.out.println(queue.add(2));
        //add 超过了容量，就报异常  Exception in thread "main" java.lang.IllegalStateException: Queue full
        //queue.add(3);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        //remove 队列空了，就报异常   Exception in thread "main" java.util.NoSuchElementException
        //System.out.println(queue.remove());

        queue.add(1);
        queue.add(2);
        // 取队首元素，空的话，异常
        System.out.println(queue.element());
        queue.remove();
        System.out.println(queue.element());
        queue.remove();
        // Exception in thread "main" java.util.NoSuchElementException
        //System.out.println(queue.element());

        //--------------------------特殊值 超过容量返回false，没有元素返回null--------------------------

        System.out.println(queue.offer(1));
        System.out.println(queue.offer(2));
        //超过容量返回false
        System.out.println(queue.offer(3));

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        //没有的话返回null
        System.out.println(queue.poll());

        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.peek());
        queue.poll();
        System.out.println(queue.peek());
        queue.poll();
        //没有的话返回null
        System.out.println(queue.peek());


        //--------------------------阻塞 放的时候超过了容量，阻塞，空了的时候取，阻塞 谨慎使用 --------------------------
        try {
            queue.put(1);
            queue.put(2);

            // 阻塞了
            //queue.put(3);

            System.out.println("queue.take(): " + queue.take());
            System.out.println("queue.take(): " + queue.take());
            // 阻塞了
            //System.out.println("queue.take(): " + queue.take());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //--------------------------超时 超过容量false 没有元素了null,带超时的，比上面阻塞"温柔"，过时不候--------------------------
        queue.offer(1);
        queue.offer(2);
        //返回false
        try {
            System.out.println(queue.offer(3, 1, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        //返回null
        try {
            System.out.println(queue.poll(1, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //异常NullPointerException
        //queue.offer(null);

        //------------------------SynchronousQueue 同步队列，一次一个，put后必须等take----------------------------
//        t1	 t1 put 111
//        t2 take: 111
//        t1	 t1 put 222
//        t2 take: 222
//        t1	 t1 put 333
//        t2 take: 333
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t t1 put 111");
                queue3.put("111");
                System.out.println(Thread.currentThread().getName() + "\t t1 put 222");
                queue3.put("222");
                System.out.println(Thread.currentThread().getName() + "\t t1 put 333");
                queue3.put("333");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                Thread.sleep(50);
                System.out.println("t2 take: " + queue3.take());
                Thread.sleep(50);
                System.out.println("t2 take: " + queue3.take());
                Thread.sleep(50);
                System.out.println("t2 take: " + queue3.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
}
