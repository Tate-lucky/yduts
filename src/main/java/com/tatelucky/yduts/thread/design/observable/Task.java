package com.tatelucky.yduts.thread.design.observable;

/**
 * @author tangsheng
 * @since 2019-11-25
 */
@FunctionalInterface
public interface Task<T> {
    //任务执行接口
    T call();
}
