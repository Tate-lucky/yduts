package com.tatelucky.yduts.util.bean;

import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 反射获取方法结果
 *
 * @author tangsheng
 * @since 2019-06-18
 */
@Component
public class InvokeUtil {

    /**
     * 反射获取结果
     *
     * @param bean
     * @param methodName
     * @param args 参数
     * @return
     */
    public static Object invokeMethod(Object bean, String methodName, Object args) {
        Object result;
        List<Object> list = new ArrayList<>();
        Method method = null;
        try {
            Class<?> cls = bean.getClass();

            Method[] methods = cls.getMethods();
            for (Method m : methods) {
                if (m.getName().equals(methodName)) {
                    method = m;
                    break;
                }
            }
            //生成方法的参数值
            Object[] params = new Object[1];

            if (null != args) {
                params[0] = args;
                result = method.invoke(bean, params);
                return result;
            } else {
                //参数为空默认就当作不需要参数处理
                result = method.invoke(bean);
                return result;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
