package com.tatelucky.yduts.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ThreadPoolDemo
 *
 * @author tangsheng
 * @since 2019-11-04
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {

        //5大参数
        //public ThreadPoolExecutor(int corePoolSize,
        //                              int maximumPoolSize,
        //                              long keepAliveTime,
        //                              TimeUnit unit,
        //                              BlockingQueue<Runnable> workQueue)

//        //固定5个线程,一般不要这样创建  LinkedBlockingQueue  适用于一些长期任务，性能好
////        ThreadPoolExecutor(nThreads, nThreads,
////                0L, TimeUnit.MILLISECONDS,
////                new LinkedBlockingQueue<Runnable>());
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//
//
//        //单线程 LinkedBlockingQueue  适用于一个任务一个任务执行的
////        (new ThreadPoolExecutor(1, 1,
////                0L, TimeUnit.MILLISECONDS,
////                new LinkedBlockingQueue<Runnable>()));
//        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
//
//        //指不定多少个线程  SynchronousQueue 适用于执行一些异步小任务，负载较轻的
//
//        ExecutorService executorService3 = Executors.newCachedThreadPool();
////        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
////                60L, TimeUnit.SECONDS,
////                new SynchronousQueue<Runnable>());
//
//        //ExecutorService executorService4 = Executors.newScheduledThreadPool(3);
//
//        try {
//            for (int i = 0; i < 50; i++) {
//                executorService3.execute(() -> {
//                    System.out.println(Thread.currentThread().getName() + "\t execute");
//                });
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            executorService3.shutdown();
//
//        }

        //上面的基本不用这种，规范不建议使用 Executors去创建线程池，因为队列的数据太多了容易导致OO，21亿的数据
        //自定义7大参数
        //max 小于 core 的时候会报异常 Exception in thread "main" java.lang.IllegalArgumentException
        //	at java.util.concurrent.ThreadPoolExecutor.<init>(ThreadPoolExecutor.java:1314)
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        AtomicInteger atomicInteger = new AtomicInteger(0);


        try {
            for (int i = 0; i < 500; i++) {

                //当阻塞队列过小的时候，容易抛异常 AbortPolicy
                // java.util.concurrent.RejectedExecutionException:
                // Task com.tatelucky.yduts.thread.ThreadPoolDemo$$Lambda$1/333362446@589838eb
                // rejected from java.util.concurrent.ThreadPoolExecutor@402a079c[Running, pool size = 5, active threads = 0, queued tasks = 0, completed tasks = 36]

                //CallerRunsPolicy 会有 main	 execute，有主线程来运行

                //DiscardOldestPolicy，DiscardPolicy 容易丢包

                threadPool.execute(() -> {
                    System.out.println(atomicInteger.incrementAndGet() + "   " + Thread.currentThread().getName() + "\t execute");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();

        }
    }
}
