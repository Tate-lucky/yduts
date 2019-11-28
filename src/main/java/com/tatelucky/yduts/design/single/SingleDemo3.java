package com.tatelucky.yduts.design.single;

/**
 * DC check
 *
 * @author tangsheng
 * @since 2019-11-28
 */
public class SingleDemo3 {
    private static volatile SingleDemo3 singleDemo3 = null;

    public SingleDemo3() {
    }

    public static SingleDemo3 getInstance() {
        if (null == singleDemo3) {
            synchronized (SingleDemo3.class) {
                if (null == singleDemo3) {
                    return new SingleDemo3();
                }
            }
        }
        return singleDemo3;
    }
}
