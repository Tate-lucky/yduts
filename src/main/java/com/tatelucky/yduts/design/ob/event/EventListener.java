package com.tatelucky.yduts.design.ob.event;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tangsheng
 * @since 2019-06-09
 */
public class EventListener {

    protected Map<Enum, Event> enumEventMap = new HashMap<>();

    public void addListener(Enum eventType, Object target, Method callback) {
        enumEventMap.put(eventType, new Event(target, callback));
    }

    protected void trigger(Event event) {
        event.setSource(this);
        event.setTime(System.currentTimeMillis());
        try {
            event.getCallback().invoke(event.getTarget(), event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void trigger(Enum call) {
        if (!this.enumEventMap.containsKey(call)) {
            return;
        }
        trigger(this.enumEventMap.get(call).setTrigger(call.toString()));
    }
}
