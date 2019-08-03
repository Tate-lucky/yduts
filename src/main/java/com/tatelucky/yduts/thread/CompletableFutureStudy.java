package com.tatelucky.yduts.thread;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 解决场景：
 * 1.两个异步操作的结果合并，两者逻辑独立存在，但结果又相互依赖
 * 2.等待future集合的所有任务都结束
 * 3.仅等待future集合中最快结束的任务完成，返回它的结果
 *
 * @author tangsheng
 * @since 2019-07-25
 */
@Slf4j
public class CompletableFutureStudy {

    public static void main(String[] args) {

        //手动创建一个线程池
        ExecutorService executor = Executors.newFixedThreadPool(4);

        //无返回值的任务，这里没指定线程池，会使用ForkJoinPool.commonPool去执行
        CompletableFuture.runAsync(() -> {
            log.info("无返回值的任务,使用的是ForkJoinPool");
        });

        //指定自己的线程池去做
        CompletableFuture.runAsync(() -> {
            log.info("使用自定义的线程池执行无返回值的任务");
        }, executor);


        //有返回值的任务，无指定线程池
        CompletableFuture<Person> personCompletableFuture = CompletableFuture.supplyAsync(() -> {
            Person p = new Person();
            p.setName("test");
            return p;
        }).thenApplyAsync(  //把获取的结果进行转化
                person -> {
                    person.setAge(12);
                    log.info("使用ForkJoinPool带返回值的方式去构造一个person");
                    return person;
                });

        try {
            Person person = personCompletableFuture.get();
            System.out.println(person.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        //关闭线程池
        executor.shutdown();
    }

    @Data
    private static class Person {
        private String name;

        private Integer age;
    }
}
