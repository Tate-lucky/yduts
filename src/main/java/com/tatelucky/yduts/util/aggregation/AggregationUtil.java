package com.tatelucky.yduts.util.aggregation;

import com.tatelucky.yduts.util.aggregation.model.Meta;
import com.tatelucky.yduts.util.bean.InvokeUtil;
import com.tatelucky.yduts.util.bean.SpringBeanUtil;
import org.apache.commons.beanutils.PropertyUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 基于反射和spri
 *
 *
 * @author tangsheng
 * @since 2019-06-18
 */
@SuppressWarnings("rawtypes")
public class AggregationUtil<T> {
    //service的map集合
    private Map<String, Object> serviceMap = new HashMap<>();
    //Meta集合
    private List<Meta> metas = new ArrayList<>();

    /**
     * 增加meta
     *
     * @param meta
     */
    public void addMeta(Meta<T> meta) {
        metas.add(meta);
    }

    public void union(List<T> mainBeanList) {
        if (null == metas || metas.isEmpty()) {
            throw new RuntimeException("Please use addMeta method to init!");
        }

        //循环填充数据集
        for (Meta<T> meta : metas) {
            //获取传入的属性名称
            String propName = meta.getProp();
            //属性值，参数可能是多个
            Set<Object> propValues = new HashSet<>();

            PropHelper propHelper = new PropHelper();

            try {
                for (int i = 0; i < mainBeanList.size(); i++) {
                    T bean = mainBeanList.get(i);
                    Object canshu = PropertyUtils.getProperty(bean, propName);
                    if (null != canshu) {
                        propValues.add(canshu);
                        //参数记录位置
                        propHelper.addCodeRowPos(canshu, i);
                    }
                }

                //获取service实体名称
                String serviceName = meta.getServiceName();
                Object service = null;

                //获取sercice类
                if (null == serviceName) {
                    //说明传入的是实体类
                    service = meta.getServiceObj();
                    serviceName = service.getClass().getSimpleName();
                } else {
                    //serviceName不为空，根据serviceName 走spring获取
                    service = getServiceByName(serviceName);
                }

                //获取返回值
                List<Object> otherBeans = new ArrayList<>();
                for (Object value:propValues) {
                    Object bean = InvokeUtil.invokeMethod(service, meta.getMethod(), value);
                    otherBeans.add(bean);
                }

                if (null == otherBeans || otherBeans.size() == 0) {
                    continue;
                }

                //获取必须得到的返回值key，查看返回的bean里面是不是真的
                String unionProp = meta.getUnionProp();


                for (Object otherBean : otherBeans) {
                    //查看返回结果里面是否有必须有的key值
                    Object key = PropertyUtils.getProperty(otherBean, unionProp);
                    if (null == key) {
                        throw new RuntimeException(serviceName + "返回的列表数据里未包含" + unionProp + "属性名");
                    }
                    List<Integer> rowPoss = propHelper.getCodeRowPoss(key);
                    if (null == rowPoss || rowPoss.isEmpty()) {
                        continue;
                    }

                    for (Integer rowPos : rowPoss) {
                        T main = mainBeanList.get(rowPos);
                        if (null == main) {
                            continue;
                        }
                        meta.fillMainBean(main, otherBean);
                    }
                }

            } catch (Exception e) {
                throw new RuntimeException(e);

            }
        }
    }

    /**
     * 通过serviceName获取service
     *
     * @param serviceName
     * @return
     */
    private Object getServiceByName(String serviceName) {
        Object service = serviceMap.get(serviceName);
        if (null == service) {
            service = SpringBeanUtil.getBean(serviceName);
            if (null == service) {
                throw new RuntimeException("服务不存在：" + serviceName);
            }
            serviceMap.put(serviceName, service);
        }
        return service;
    }
}
