package com.tatelucky.yduts.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author tangsheng
 * @since 2019-11-01
 */
class Mythread implements Runnable {
    @Override
    public void run() {
        System.out.println("run");
    }
}

class Mythread2 extends Thread {

}

class Mythread3 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t call");
        Thread.sleep(2000L);
        return 1;
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        //FutureTask，多个线程抢一个FutureTask只有一个结果
        FutureTask futureTask = new FutureTask(new Mythread3());
        //和上面等价
        FutureTask futureTask2 = new FutureTask(() -> new Mythread3().call());

        //public Thread(Runnable target, String name)
        Thread thread = new Thread(futureTask, "futureTask");
        thread.start();

        //多线程，其实自旋也是在占用资源，只是没阻塞
        while (!futureTask.isDone()) {

        }
        try {
            //一般get放后面，避免被阻塞
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
