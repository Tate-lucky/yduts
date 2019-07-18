package com.tatelucky.yduts.flow.model;

/**
 * 流程模型
 *
 * @author tangsheng
 * @since 2019-07-17
 */
public class FlowModel {

    /**
     * 目前步子，默认0
     */
    private Integer nowStep = 0;

    public Integer getNowStep() {
        return nowStep;
    }

    public void setNowStep(Integer nowStep) {
        this.nowStep = nowStep;
    }

    @Override
    public String toString() {
        return "FlowModel{" +
                "nowStep=" + nowStep +
                '}';
    }
}
