package com.tatelucky.yduts.thread.design.observable;

/**
 * @author tangsheng
 * @since 2019-11-25
 */
public interface Observable {
    //任务生命周期
    enum Cycle {
        STARTED, RUNNING, DONE, ERROR
    }

    //获取当前的任务状态
    Cycle getCycle();

    //启动线程
    void start();

    //线程中断
    void interrupt();
}
