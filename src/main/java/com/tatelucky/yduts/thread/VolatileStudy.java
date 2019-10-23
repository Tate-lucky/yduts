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
    //    int number = 0;
    volatile int number = 0;

    public void addTo60() {
        this.number = 60;
    }
}
