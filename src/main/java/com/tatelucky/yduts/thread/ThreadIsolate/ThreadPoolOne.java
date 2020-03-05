package com.tatelucky.yduts.thread.ThreadIsolate;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import lombok.extern.slf4j.Slf4j;

/**
 * @author tangsheng
 * @since 2020-03-05
 */
@Slf4j
public class ThreadPoolOne extends HystrixCommand<String> {

    private String name;

    public ThreadPoolOne(String name) {
        super(Setter.withGroupKey(
                //线程池分组策略
                HystrixCommandGroupKey.Factory.asKey("ThreadPoolOneGroup"))//一个group下面可能有不同的threadpool
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ThreadPoolOne"))  //一个threadpoolkey一个线程池
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                        .withCoreSize(2) //默认10
                        .withKeepAliveTimeMinutes(2) //默认一分钟
                        .withMaxQueueSize(10) //默认-1，这时候queue是一个syncQueue   正整数是一个linkedblockqueue
                        .withQueueSizeRejectionThreshold(10000))
                //隔离策略
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD))
        );
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        log.info(name);
        Thread.sleep(100L);
        return name;
    }
}
