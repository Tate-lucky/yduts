package com.tatelucky.yduts.lock;

/**
 * @author tangsheng
 * @since 2019-07-18
 */
public abstract class LockTemplate {

    public abstract boolean lock(String lockKey, int time);

    public abstract void releaseLock(String lockKey);
}
