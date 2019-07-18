package com.tatelucky.yduts.flow;

import com.tatelucky.yduts.flow.exception.FlowException;
import org.junit.Test;

/**
 * @author tangsheng
 * @since 2019-07-18
 */
public class FlowTest {

    @Test
    public void test() {
        final int step = 5;

        //具体业务逻辑
        FlowWorker flowWorker = new FlowWorker() {
            @Override
            public void doing() {
                //业务逻辑
                try {
                    add(step);
                    System.out.println("step 1");
                    add(step);
                    System.out.println("step 2");
                    add(step);
                    System.out.println("step 3");
                    add(step);
                    System.out.println("step 4");
                    add(step);
                    System.out.println("step 5");
                    add(step);
                    System.out.println("step 6");
                    add(step);
                    System.out.println("step 7");
                } catch (FlowException e) {
                    System.out.println("程序执行完毕");
                }
            }
        };

        FlowUtil flowUtil = new FlowUtil();

        //装载执行方法并运行
        flowUtil.setFlowWorker(flowWorker);
        flowUtil.run();
    }
}
