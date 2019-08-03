package com.tatelucky.yduts.lock;

/**
 * @author tangsheng
 * @since 2019-07-18
 */
public abstract class LockArea {


    private LockModel lockModel;

    public LockArea(LockModel lockModel) {
        this.lockModel = lockModel;
    }

    /**
     * 用户需要加锁的域
     */
    public abstract void doing();

    public void setLockModel(LockModel lockModel) {
        this.lockModel = lockModel;
    }

    public LockModel getLockModel() {
        return lockModel;
    }
}
