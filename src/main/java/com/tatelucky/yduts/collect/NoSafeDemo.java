package com.tatelucky.yduts.collect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 并发环境下集合异常demo和解决方案
 *
 * @author tangsheng
 * @since 2019-10-25
 */
public class NoSafeDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        //一个线程安全的list，verctor性能太低了(只能在尾部进行插入和删除操作)，
        // 类似StringBuffer,扩容是一倍,分配内存的时候需要连续的存储空间，如果数据太多，容易分配内存失败
        List<String> list2 = Collections.synchronizedList(new ArrayList<>());

        //使用juc包提供的类，写时复制，读写分离的思想
        CopyOnWriteArrayList list3 = new CopyOnWriteArrayList();

        //多运行几次会出现： java.util.ConcurrentModificationException
        // 并发修改导致的数据不一致，
        // 推荐使用并发集合类
        for (int i = 1; i <= 40; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list3);
            }, String.valueOf(i)).start();
        }
    }
}
