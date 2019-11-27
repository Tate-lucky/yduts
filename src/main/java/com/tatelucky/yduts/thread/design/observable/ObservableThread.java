package com.tatelucky.yduts.thread.design.observable;

/**
 * @author tangsheng
 * @since 2019-11-25
 */
public class ObservableThread<T> extends java.lang.Thread implements Observable {

//    private final TaskLifeCycle<T> lifeCycle;
//
//    private final Task<T> task;

    private Cycle cycle;

    @Override
    public Cycle getCycle() {
        return null;
    }

    @Override
    public void start() {

    }

    @Override
    public void interrupt() {

    }


    @Override
    public void run() {

    }
}
