package com.tatelucky.yduts.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * BlockingQueueDemo
 * <p>
 * ArrayBlockingQueue 基于数组的fifo的有界队列
 * LinkedBlockingQueue 基于链表的fifo的有界队列
 * SynchronousQueue 不存储元素的阻塞队列，每个插入操作必须等到另一个线程调用移除参数，否则一直阻塞
 * <p>
 * 阻塞队列：队列空的时候   获取时候被阻塞
 * 队列满的时候   添加的时候会被阻塞
 *
 * @author tangsheng
 * @since 2019-10-28
 */
public class BlockingQueueDemo {


    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(2);
        queue.add(1);
        queue.add(2);
        try {
            queue.put(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
