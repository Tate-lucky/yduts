package com.tatelucky.yduts.jvm;

/**
 * 模拟频繁的young gc
 *
 * @author tangsheng
 * @since 2019-09-09
 */
public class Demo {

    public static void main(String[] args) {
        //分配了三个数组，每个数组1mb
        //在eden区放入了一个1mb的对象
        byte[] array1 = new byte[1024 * 1024];
        //继续在eden区放入了一个1mb的对象，上面的数组就变成了垃圾对象
        array1 = new byte[1024 * 1024];
        //继续在eden区放入了一个1mb的对象，上面的数组就变成了垃圾对象
        array1 = new byte[1024 * 1024];

        //局部变量什么都不指向了，上面的数组对象都变成了垃圾对象
        array1 = null;

        //分配一个2mb的对象到eden区，此时eden是存放不下的，之前的已经占了3mb，还剩1mb，触发young gc
        byte[] array2 = new byte[2 * 1024 * 1024];

    }
}
