package com.tatelucky.yduts.service.impl;

import com.tatelucky.yduts.model.Car;
import com.tatelucky.yduts.model.Perple;
import com.tatelucky.yduts.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * @author tangsheng
 * @since 2019-06-18
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public Car getCar() {
        Car car = new Car();
        car.setColor("blue");
        car.setModelName("BMW");
        car.setName("宝马");
        return car;
    }

    @Override
    public Perple getPerple() {
        Perple perple = new Perple();
        perple.setName("TATE");
        return perple;
    }
}
