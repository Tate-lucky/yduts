package com.tatelucky.yduts.lock;

import org.junit.Test;

/**
 * @author tangsheng
 * @since 2019-07-18
 */
public class LockTest {
    @Test
    public void test() {
        LockUtil<MyLock> lockUtil = new LockUtil(new LockArea(new LockModel("testKey", 10)) {
            @Override
            public void doing() {
                System.out.println("业务逻辑");


            }
        }, new MyLock());
        lockUtil.run();
    }
}
