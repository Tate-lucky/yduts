package com.tatelucky.yduts.service;

import com.tatelucky.yduts.model.Car;
import com.tatelucky.yduts.model.People;

/**
 * @author tangsheng
 * @since 2019-06-18
 */
public interface DemoService {
    Car getCar();
    People getPeople();
    Car getCarByName(String name);

}
