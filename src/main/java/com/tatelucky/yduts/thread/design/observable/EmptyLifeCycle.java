package com.tatelucky.yduts.thread.design.observable;

/**
 * @author tangsheng
 * @since 2019-11-25
 */
public class EmptyLifeCycle<T> implements TaskLifeCycle<T> {
    @Override
    public void onStart(Thread thread) {

    }

    @Override
    public void onRunning(Thread thread) {

    }

    @Override
    public void onFinish(Thread thread, T result) {

    }

    @Override
    public void onError(Thread thread, Exception e) {

    }
}
