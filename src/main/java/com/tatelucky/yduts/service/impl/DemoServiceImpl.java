package com.tatelucky.yduts.service.impl;

import com.tatelucky.yduts.model.Car;
import com.tatelucky.yduts.model.People;
import com.tatelucky.yduts.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * @author tangsheng
 * @since 2019-06-18
 */
@Service("demoService")
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
    public People getPeople() {
        People people = new People();
        people.setName("TATE");
        return people;
    }

    @Override
    public Car getCarByName(String name) {
        if("宝马".equals(name)){
            return getCar();
        }else {
            Car car = new Car();
            car.setColor("yello");
            car.setModelName("BC");
            car.setName("奔驰");
            return car;
        }
    }
}
