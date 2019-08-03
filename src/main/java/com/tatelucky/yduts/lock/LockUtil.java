package com.tatelucky.yduts.lock;

/**
 * @author tangsheng
 * @since 2019-07-18
 */
public class LockUtil<T extends LockTemplate> {
    private LockArea lockArea;

    private T lockTemplate;


    public LockUtil(LockArea lockArea, T lockTemplate) {
        this.lockArea = lockArea;
        this.lockTemplate = lockTemplate;
    }

    /**
     * 执行lockArea要去实现的逻辑部分
     */
    public void run() {
        if (null != lockArea) {
            LockModel lockModel = lockArea.getLockModel();
            if (null == lockModel) {
                throw new RuntimeException("lockModel can not be null");
            }

            if (null == lockTemplate) {
                throw new RuntimeException("lockTemplate can not be null");
            }

            System.out.println("lockModel:" + lockModel.toString());

            System.out.println("加锁逻辑");
            boolean flag = lockTemplate.lock(lockModel.getLockKey(), lockModel.getLockTime());
            if (!flag) {
                //没有获取到锁直接返回
                return;
            }

            System.out.println("加锁成功");
            try {
                lockArea.doing();

            } finally {
                System.out.println("解锁逻辑");
                lockTemplate.releaseLock(lockModel.getLockKey());
            }
        }
    }
}
