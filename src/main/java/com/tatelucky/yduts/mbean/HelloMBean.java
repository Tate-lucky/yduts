package com.tatelucky.yduts.mbean;

/**
 * @author tangsheng
 * @since 2019-07-15
 */
public interface HelloMBean {
    public String getName();

    public void setName(String name);

    public void printHello();

    public void printHello(String whoName);
}
