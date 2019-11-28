package com.tatelucky.yduts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.tatelucky.yduts.*"})
public class YdutsApplication {

    public static void main(String[] args) {
        SpringApplication.run(YdutsApplication.class, args);
    }

}
