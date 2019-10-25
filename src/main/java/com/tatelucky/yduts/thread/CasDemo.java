package com.tatelucky.yduts.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * cas
 *
 * @author tangsheng
 * @since 2019-10-24
 */
public class CasDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);

        atomicInteger.incrementAndGet();

        System.out.println(atomicInteger.toString());

        atomicInteger.compareAndSet(2, 3);

        System.out.println(atomicInteger.toString());

        boolean falg = atomicInteger.compareAndSet(2, 3);

        System.out.println(falg);

//        unsafe.getAndAddInt(this, valueOffset, 1);
//        this当前对象，valueOffset内存偏移量（内存地址）， 1 加一
//        public final int getAndAddInt(Object var1, long var2, int var4) {
//            int var5;
//            do {
//                var5 = this.getIntVolatile(var1, var2);
        //直到成功为止
//            } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));
//
//            return var5;
//        }
        atomicInteger.getAndIncrement();
        System.out.println(atomicInteger.toString());
    }
}
