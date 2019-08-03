package com.tatelucky.yduts;

import lombok.Data;
import org.junit.Test;

import java.util.Optional;

/**
 * @author tangsheng
 * @since 2019-06-26
 */
public class TestDemo {

    @Test
    public void test() {
        String a = null;
        String b = "b";
        System.out.println(Optional.ofNullable(a).orElse(b));

        System.out.println(Optional.ofNullable(a).map(name -> a.toString()).orElse("test"));


        User user = new User();
//        user

    }

    @Data
    public static class User {
        private String name;
        private String tel;
    }
}
