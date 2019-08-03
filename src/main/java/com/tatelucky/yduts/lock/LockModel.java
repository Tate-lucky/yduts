package com.tatelucky.yduts.lock;

/**
 * @author tangsheng
 * @since 2019-07-18
 */
public class LockModel {
    /**
     * 被锁的key
     */
    private String lockKey;

    /**
     * 加锁的时间
     */
    private Integer lockTime;

    public LockModel(String lockKey, Integer lockTime) {
        this.lockKey = lockKey;
        this.lockTime = lockTime;
    }

    public String getLockKey() {
        return lockKey;
    }

    public void setLockKey(String lockKey) {
        this.lockKey = lockKey;
    }

    public Integer getLockTime() {
        return lockTime;
    }

    public void setLockTime(Integer lockTime) {
        this.lockTime = lockTime;
    }

    @Override
    public String toString() {
        return "LockModel{" +
                "lockKey='" + lockKey + '\'' +
                ", lockTime=" + lockTime +
                '}';
    }
}
