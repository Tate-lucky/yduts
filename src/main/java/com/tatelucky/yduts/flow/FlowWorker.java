package com.tatelucky.yduts.flow;

import com.tatelucky.yduts.flow.exception.FlowException;
import com.tatelucky.yduts.flow.model.FlowModel;

/**
 * @author tangsheng
 * @since 2019-07-17
 */
public abstract class FlowWorker {

    private FlowModel flowModel = new FlowModel();

    /**
     * 具体的实现逻辑
     */
    public abstract void doing();

    public FlowModel getFlowModel() {
        return flowModel;
    }

    /**
     * 增加步骤
     *
     * @param flowModel
     * @param step
     * @param <T>
     */
    protected <T extends FlowModel> void add(int step) {
        if (step < 1) {
            throw new FlowException("step 必须大于0");
        }
        if (flowModel.getNowStep() == step) {
            throw new FlowException("已达到期望值，程序可以终断");
        }
        flowModel.setNowStep(flowModel.getNowStep() + 1);
    }
}
