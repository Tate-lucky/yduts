package com.tatelucky.yduts.design.factory;

/**
 * @author tangsheng
 * @since 2019-11-28
 */
public class CarFactory {

    public static Car get(String name) {
        if ("BMW".equals(name)) {
            return new BmwCar();
        }

        if ("AUDI".equals(name)) {
            return new AudiCar();
        }

        return null;
    }


    public static void main(String[] args) {
        Car bmw = CarFactory.get("BMW");
        System.out.println(bmw.getClass().getName());
    }
}
