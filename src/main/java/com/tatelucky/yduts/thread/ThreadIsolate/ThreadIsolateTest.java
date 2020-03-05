package com.tatelucky.yduts.thread.ThreadIsolate;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author tangsheng
 * @since 2020-03-05
 */
@Slf4j
public class ThreadIsolateTest {

    public static void main(String[] args) {
        ThreadPoolOne threadPoolOne = new ThreadPoolOne("one");
        ThreadPoolOne threadPoolOnePlus = new ThreadPoolOne("onePlus");
        ThreadPoolTwo threadPoolTwo = new ThreadPoolTwo("two");

        try {
            //阻塞方式执行，run方法，使用run的话，降级熔断是不生效的
            String oneResult = threadPoolOne.run();
            String twoResult = threadPoolTwo.run();
            log.info(oneResult);
            log.info(twoResult);

            //非阻塞的方式运行,queue的方式
            Future<String> futureOne = threadPoolOne.queue();
            Future<String> futureTwo = threadPoolTwo.queue();
            oneResult = futureOne.get(5000L, TimeUnit.MILLISECONDS);
            twoResult = futureTwo.get(5000L, TimeUnit.MILLISECONDS);
            log.info(oneResult);
            log.info(twoResult);

            //execute的同步方式
            String plusResult = threadPoolOnePlus.execute();
            log.info(plusResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
