package com.tatelucky.yduts.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author tangsheng
 * @since 2019-06-18
 */
@Data
public class Car implements Serializable{
    private static final long serialVersionUID = 5032672766076887070L;
    private String name;
    private String color;
    private String modelName;
}
