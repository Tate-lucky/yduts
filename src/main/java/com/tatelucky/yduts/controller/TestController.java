package com.tatelucky.yduts.controller;

import com.tatelucky.yduts.model.Buyer;
import com.tatelucky.yduts.model.Car;
import com.tatelucky.yduts.service.DemoService;
import com.tatelucky.yduts.util.aggregation.AggregationUtil;
import com.tatelucky.yduts.util.aggregation.model.Meta;
import com.tatelucky.yduts.util.bean.InvokeUtil;
import com.tatelucky.yduts.util.bean.SpringBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试controller
 *
 * @author tangsheng
 * @since 2019-06-18
 */
@RestController
public class TestController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public Car sayHello() {
        return demoService.getCar();
    }

    @RequestMapping(value = "/spring", method = RequestMethod.GET)
    public String spring() {
        return SpringBeanUtil.getBean("demoService").toString();
    }

    @RequestMapping(value = "/invoke", method = RequestMethod.GET)
    public Object invoke() {
        return InvokeUtil.invokeMethod(SpringBeanUtil.getBean("demoService"), "getCar", null);
    }

    @RequestMapping(value = "/union", method = RequestMethod.GET)
    public Object union() {
        List<Buyer> buyers = new ArrayList<>();
        Buyer buyer = new Buyer();
        buyer.setBuyerName("老王");
        buyer.setCarName("宝马");
        buyers.add(buyer);

        Buyer buyer2 = new Buyer();
        buyer2.setBuyerName("老李");
        buyer2.setCarName("奔驰");
        buyers.add(buyer2);



        AggregationUtil<Buyer> aggregationUtil = new AggregationUtil<>();
        aggregationUtil.addMeta(new Meta<Buyer>("buyerName", "demoService", "getCarByName", "name") {
            @Override
            public void fillMainBean(Buyer mainBean, Object serviceBean) {
                Car car = (Car) serviceBean;
                mainBean.setModelName(car.getModelName());
                mainBean.setColor(car.getColor());
            }
        });
        aggregationUtil.union(buyers);
        return buyers;
    }
}
