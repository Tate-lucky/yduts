package com.tatelucky.yduts.design.factory;

import lombok.Data;

/**
 * @author tangsheng
 * @since 2019-11-28
 */
@Data
public class AudiCar extends Car {
    private String name;

    @Override
    public String getName() {
        return this.name;
    }
}
