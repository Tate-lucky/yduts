package com.tatelucky.yduts.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * oom demo
 * 启动配置参数：
 * -Xmx10M -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/tate/Desktop/dump/
 * 堆最大内存 10m  溢出时候输出信息  产生dump文件
 * 10 * 1024 / 64 = 160 ，不到200肯定就oom了
 * <p>
 * 模拟产生oom的demo，模拟一个不断的创建对象，导致溢出的场景,输出dump文件
 * ...
 * 127
 * 128
 * 129
 * 130
 * 131
 * 132
 * 133
 * java.lang.OutOfMemoryError: Java heap space
 * Dumping heap to /Users/tate/Desktop/dump/java_pid9917.hprof ...
 * <p>
 * 获取到这个文件后，我们可以通过jvisualvm查看相关的信息
 *
 * @author tangsheng
 * @since 2019-10-14
 */
public class OomDemo {
    static class OomInsance {
        public byte[] a = new byte[64 * 1024];
    }

    public static void fill(List<OomInsance> list, int num) {
        for (int i = 0; i < num; i++) {
            System.out.println(i);
            list.add(new OomInsance());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<OomInsance> list = new ArrayList<>();
        fill(list, 200);
        Thread.sleep(999999999);
    }

}
