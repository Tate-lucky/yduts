package com.tatelucky.yduts.flow;

/**
 * @author tangsheng
 * @since 2019-07-17
 */
public class FlowUtil {

    private FlowWorker flowWorker = null;

    /**
     * 设置工作的worker
     *
     * @param flowWorker
     */
    public void setFlowWorker(FlowWorker flowWorker) {
        this.flowWorker = flowWorker;
    }

    /**
     * 执行业务操作
     */
    public void run() {
        if (null != flowWorker) {
            flowWorker.doing();
        }
    }

}
