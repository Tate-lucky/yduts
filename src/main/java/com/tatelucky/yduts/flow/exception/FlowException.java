package com.tatelucky.yduts.flow.exception;

import com.tatelucky.yduts.constant.Constants;

import java.util.Map;

/**
 * @author tangsheng
 * @since 2019-07-17
 */
public class FlowException extends RuntimeException {
    private static final long serialVersionUID = -6897610750230637588L;

    private static final int CODE_DEFAULT = Constants.FLOW_ERROR_INT;

    /**
     * 异常代码
     */
    private int code;

    /**
     * 错误消息msg
     */
    private String msg;

    /**
     * 异常数据
     */
    private Map<String, Object> data;

    public FlowException(String msg) {
        this(CODE_DEFAULT, msg);
    }

    public FlowException(int code, String msg) {
        this(code, msg, (Map<String, Object>) null);
    }

    public FlowException(int code, String msg, Map<String, Object> data) {
        super(msg);
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
