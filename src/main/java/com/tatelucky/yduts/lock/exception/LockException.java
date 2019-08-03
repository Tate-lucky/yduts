package com.tatelucky.yduts.lock.exception;

/**
 * 实现加锁和解锁的异常
 *
 * @author tangsheng
 * @since 2019-07-18
 */
public class LockException extends RuntimeException {

    private static final long serialVersionUID = 6544254518015521881L;
    /**
     * 错误消息msg
     */
    private String msg;

    public LockException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
