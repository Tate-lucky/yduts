package com.tatelucky.yduts.design.builder;

import lombok.Data;

/**
 * @author tangsheng
 * @since 2019-11-28
 */
@Data
class Product {
    private String part1;
    private String part2;
}

interface Builder {
    public void buildPart1();

    public void buildPart2();

    public Product retriverResult();
}

class ConcreteBuilder implements Builder {
    private Product product = new Product();

    @Override
    public void buildPart1() {
        product.setPart1("part1");
    }

    @Override
    public void buildPart2() {
        product.setPart2("part2");
    }

    @Override
    public Product retriverResult() {
        return product;
    }
}

class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    void construct() {
        builder.buildPart1();
        builder.buildPart2();
    }
}

public class BuilderDemo {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.construct();

        Product product = builder.retriverResult();
        System.out.println(product.toString());
    }
}
