package com.tatelucky.yduts.thread.design.observable;

/**
 * @author tangsheng
 * @since 2019-11-25
 */
public interface TaskLifeCycle<T> {
    /**
     * 启动触发onStart
     *
     * @param thread
     */
    void onStart(Thread thread);

    /**
     * 任务正在运行触发onRunning
     *
     * @param thread
     */
    void onRunning(Thread thread);

    /**
     * 任务完成触发onFinish
     *
     * @param thread
     * @param result
     */
    void onFinish(Thread thread, T result);

    /**
     * 任务出错时候触发
     *
     * @param thread
     * @param e
     */
    void onError(Thread thread, Exception e);
}
