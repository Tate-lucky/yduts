package com.tatelucky.yduts.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

        //固定5个线程,一般不要这样创建  LinkedBlockingQueue  适用于一些长期任务，性能好
//        ThreadPoolExecutor(nThreads, nThreads,
//                0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>());
        ExecutorService executorService = Executors.newFixedThreadPool(5);


        //单线程 LinkedBlockingQueue  适用于一个任务一个任务执行的
//        (new ThreadPoolExecutor(1, 1,
//                0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>()));
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();

        //指不定多少个线程  SynchronousQueue 适用于执行一些异步小任务，负载较轻的

        ExecutorService executorService3 = Executors.newCachedThreadPool();
//        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
//                60L, TimeUnit.SECONDS,
//                new SynchronousQueue<Runnable>());

        //ExecutorService executorService4 = Executors.newScheduledThreadPool(3);

        try {
            for (int i = 0; i < 50; i++) {
                executorService3.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t execute");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService3.shutdown();

        }
    }
}
