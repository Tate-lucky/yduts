package com.tatelucky.yduts.thread;

/**
 * 可见性的验证
 *
 * @author tangsheng
 * @since 2019-10-23
 */
public class VolatileStudy {

    public static void main(String[] args) {
        MyData myData = new MyData();

        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData.addPlusPlus();
                }
            }, String.valueOf(i)).start();
        }

        //等上线全部计算完成，2是因为main线程和gc线程
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        //少于20000 说明不具备原子性  main：19565，也有可能执行到结果是20000
        System.out.println(Thread.currentThread().getName() + "：" + myData.number);

    }

    /**
     * 保证可见性，通知其他线程，主内存被修改了
     */
    public static void seeOk() {
        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " coming");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + " now data is:" + myData.number);
        }, "A").start();


        while (myData.number == 0) {
            //System.out.println("0");
        }

        System.out.println("done!");
    }
}

class MyData {
    //    int number = 0;  无可见性
    volatile int number = 0;  //保证可见性

    public void addTo60() {
        this.number = 60;
    }

    public void addPlusPlus() {
        //一般不具有原子性，在并发环境下一般会去用atomicInteger,可以看CasDemo
        number++;
    }
}
