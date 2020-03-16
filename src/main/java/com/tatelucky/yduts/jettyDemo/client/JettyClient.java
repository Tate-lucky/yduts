package com.tatelucky.yduts.jettyDemo.client;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 启动
 *
 * @author tangsheng
 * @since 2020-03-06
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(JettyClientConfig.class)
public @interface JettyClient {
}
