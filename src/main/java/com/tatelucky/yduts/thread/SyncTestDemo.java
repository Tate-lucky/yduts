package com.tatelucky.yduts.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author tangsheng
 * @since 2019-11-20
 */
public class SyncTestDemo {

    private final static Object MUTEX = new Object();

    public void accessResource() {
        synchronized (MUTEX) {
            try {
                TimeUnit.SECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        final SyncTestDemo syncTestDemo = new SyncTestDemo();
        for (int i = 0; i < 5; i++) {
            new Thread(syncTestDemo::accessResource).start();
        }
    }

}
