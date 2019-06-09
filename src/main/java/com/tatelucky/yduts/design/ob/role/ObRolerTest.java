package com.tatelucky.yduts.design.ob.role;

import com.tatelucky.yduts.design.ob.event.Event;

import java.lang.reflect.Method;

/**
 * @author tangsheng
 * @since 2019-06-09
 */
public class ObRolerTest {

    public static void main(String[] args) {
        try {
            //观察者
            ObRoler obRoler = new ObRoler();
            Method method = ObRoler.class.getMethod("record", new Class[]{Event.class});

            //发布者
            Publisher publisher = new Publisher();
            publisher.addListener(PublisherEventType.EAT, obRoler, method);
            publisher.addListener(PublisherEventType.SLEEP, obRoler, method);

            publisher.eat();
            publisher.sleep();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
