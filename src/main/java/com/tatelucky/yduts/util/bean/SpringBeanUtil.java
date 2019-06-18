package com.tatelucky.yduts.util.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * springBean的获取工具类
 *
 * @author tangsheng
 * @since 2019-06-18
 */
@Component
public class SpringBeanUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @SuppressWarnings("static-access")
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringBeanUtil.applicationContext = applicationContext;
    }

    public static Object getBean(String beanName) throws BeansException {
        return applicationContext.getBean(beanName);
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
