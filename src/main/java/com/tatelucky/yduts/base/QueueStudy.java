package com.tatelucky.yduts.base;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Queue : 双端队列，    阻塞队列，    非阻塞队列
 * <p>
 * Deaue    BlockingQueue   AbstractQueue
 * <p>
 * 先进先出
 *
 * @author tangsheng
 * @since 2019-10-12
 */
public class QueueStudy {
    public static void main(String[] args) {

        //Queue<Integer> queue = new ArrayBlockingQueue<>(5);

        Deque<Integer> deque = new ArrayDeque<Integer>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        deque.add(5);

        deque.addFirst(0);

        //会报错  NPE
        //deque.addFirst(null);

        deque.addLast(6);

        deque.add(7);

        //尾部添加
        deque.offer(0);

        //删除第一个
        deque.remove();


        //poll null的话报异常
        System.out.println("队列头部的元素" + deque.peek());
        System.out.println("队列头部的元素" + deque.element());

        while (!deque.isEmpty()) {
            System.out.println("出队：" + deque.poll());
        }
    }
}
