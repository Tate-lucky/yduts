package com.tatelucky.yduts.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author tangsheng
 * @since 2019-06-18
 */
@Data
public class Buyer implements Serializable{
    private static final long serialVersionUID = 5083631982887667622L;
    private String carName;
    private String color;
    private String modelName;
    private String buyerName;
}
