package com.tatelucky.yduts.util.aggregation.model;

/**
 * @author tangsheng
 * @since 2019-06-18
 */
public abstract class Meta<T> {
    /**
     * 属性名,以此属性的值关联其他service去获取相应的信息
     */
    private String prop;

    /**
     * 关联的service名称
     */
    private String serviceName;

    /**
     * 关联的service对象
     */
    private Object serviceObj;

    /**
     * 关联的service的方法名
     */
    private String method;

    /**
     * 对应prop，关联的service返回的bean里面必须包含属性名称
     */
    private String unionProp;

    /**
     * 以service的name构造
     *
     * @param prop
     * @param serviceName
     * @param method
     * @param unionProp
     */
    public Meta(String prop, String serviceName, String method, String unionProp) {
        super();
        this.prop = prop;
        this.serviceName = serviceName;
        this.method = method;
        this.unionProp = unionProp;
    }

    /**
     * 以service的bean构造
     *
     * @param prop
     * @param serviceObj
     * @param method
     * @param unionProp
     */
    public Meta(String prop, Object serviceObj, String method, String unionProp) {
        super();
        this.prop = prop;
        this.serviceObj = serviceObj;
        this.method = method;
        this.unionProp = unionProp;
    }

    /**
     * 把获取的serviceBean中的bean信息填充到mainBean中，该方法调用方自己实现
     *
     * @param mainBean
     * @param serviceBean
     */
    public abstract void fillMainBean(T mainBean, Object serviceBean);

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Object getServiceObj() {
        return serviceObj;
    }

    public void setServiceObj(Object serviceObj) {
        this.serviceObj = serviceObj;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUnionProp() {
        return unionProp;
    }

    public void setUnionProp(String unionProp) {
        this.unionProp = unionProp;
    }
}

