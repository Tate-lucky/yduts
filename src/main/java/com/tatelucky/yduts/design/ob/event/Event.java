package com.tatelucky.yduts.design.ob.event;

import java.lang.reflect.Method;

/**
 * 事件
 *
 * @author tangsheng
 * @since 2019-06-09
 */
public class Event {
    /**
     * 事件源
     */
    private Object source;
    /**
     * 目标
     */
    private Object target;
    /**
     * 回调
     */
    private Method callback;
    /**
     * 触发
     */
    private String trigger;

    private Long time;

    public Event(Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    public Object getSource() {
        return source;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getCallback() {
        return callback;
    }

    public void setCallback(Method callback) {
        this.callback = callback;
    }

    public Object getTrigger() {
        return trigger;
    }

    public Long getTime() {
        return time;
    }

    Event setTime(Long time) {
        this.time = time;
        return this;
    }

    Event setSource(Object source) {
        this.source = source;
        return this;
    }

    Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }

    @Override
    public String toString() {
        return "Event{" +
                "source=" + source +
                ", target=" + target +
                ", callback=" + callback +
                ", trigger='" + trigger + '\'' +
                ", time=" + time +
                '}';
    }
}
