package com.tatelucky.yduts.design.ob.role;

import com.tatelucky.yduts.design.ob.event.Event;

/**
 * @author tangsheng
 * @since 2019-06-09
 */
public class ObRoler {

    public void record(Event event){
        System.out.println("record: " + event);
    }
}
