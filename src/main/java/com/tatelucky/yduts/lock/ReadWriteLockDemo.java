package com.tatelucky.yduts.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁demo
 * 读读 共存
 * 读写 不能
 * 写写 不能
 *
 * @author tangsheng
 * @since 2019-10-27
 */
class Cache {
    private volatile Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(String key, Object val) {
        System.out.println("key: " + key + "val: " + val);

        lock.writeLock().lock();
        try {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, val);
            System.out.println("put ok    " + "key: " + key + "val: " + val);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }

    }

    public Object get(String key) {
        Object result = null;
        lock.readLock().lock();
        try {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result = map.get(key);
            System.out.println("get ok    " + "key: " + key + "result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
        return result;
    }
}


public class ReadWriteLockDemo {
    public static void main(String[] args) {
        Cache cache = new Cache();
        for (int i = 0; i < 5; i++) {
            final int finalI = i;
            new Thread(() -> {
                cache.put(finalI + "", finalI + "");
            }, String.valueOf(i)).start();
        }


        for (int i = 0; i < 5; i++) {
            final int finalI = i;
            new Thread(() -> {
                cache.get(finalI + "");
            }, String.valueOf(i)).start();
        }

    }
}
