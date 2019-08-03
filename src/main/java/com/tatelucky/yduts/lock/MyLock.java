package com.tatelucky.yduts.lock;

import com.tatelucky.yduts.lock.exception.LockException;

/**
 * @author tangsheng
 * @since 2019-07-18
 */
public class MyLock extends LockTemplate {
    @Override
    public boolean lock(String lockKey, int time) {
        try {
            return true;
        } catch (LockException e) {
            return false;
        }
    }

    @Override
    public void releaseLock(String lockKey) {
        System.out.println("解锁成功");
    }
}
