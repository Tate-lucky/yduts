package com.tatelucky.yduts.design.ob.role;

import com.tatelucky.yduts.design.ob.event.EventListener;

/**
 * @author tangsheng
 * @since 2019-06-09
 */
public class Publisher extends EventListener {

    //TODO  后面用动态代理实现
    public void eat() {
        System.out.println("eat");
        trigger(PublisherEventType.EAT);
    }

    public void sleep() {
        System.out.println("sleep");
        trigger(PublisherEventType.SLEEP);
    }
}
