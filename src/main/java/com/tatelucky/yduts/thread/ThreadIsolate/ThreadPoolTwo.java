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
public class ThreadPoolTwo extends HystrixCommand<String> {

    private String name;

    public ThreadPoolTwo(String name) {
        super(Setter.withGroupKey(
                HystrixCommandGroupKey.Factory.asKey("ThreadPoolTwoGroup"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ThreadPoolTwo"))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                        .withCoreSize(2).withKeepAliveTimeMinutes(2).withMaxQueueSize(10).withQueueSizeRejectionThreshold(10000))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD))
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
