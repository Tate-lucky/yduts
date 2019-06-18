package com.tatelucky.yduts.service;

import com.tatelucky.yduts.BaseTest;
import com.tatelucky.yduts.YdutsApplicationTests;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author tangsheng
 * @since 2019-06-18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = YdutsApplicationTests.class)
class DemoServiceTest {

    @Autowired
    private DemoService demoService;

    @Test
    void getCar() {
        System.out.println(demoService.getCar());
    }

    @Test
    void getPerple() {
        System.out.println(demoService.getPerple());
    }
}
