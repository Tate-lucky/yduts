package com.tatelucky.yduts;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author tangsheng
 * @since 2019-09-19
 */
public class Test {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

//        set.add("111");
//        set.add("111");
//        set.add("222");
//
//       String str = StringUtils.join(set, ",");
//        System.out.println(str);


//
//        String a = "111\n222\n333";
//
//        String[] shuzu = a.split("\n");
//        List<String> list = Arrays.asList(shuzu);
//
//        System.out.println(list.size());


//        LinkedList<People> linkedList = new LinkedList<>();
//        People people = new People();
//        people.setName("1");
//
//        People people2 = new People();
//        people2.setName("1");
//
//
//        People people3 = new People();
//        people3.setName("1");
//
//        linkedList.add(people);
//        linkedList.add(people2);
//        linkedList.add(people3);
//
//
//        People people4 = new People();
//        people4.setName("4");
//
//        linkedList.add(0, people4);
//
//        System.out.println(linkedList);


        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println(StringUtils.join(list, "\n"));

//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
//
//
//        String hehe = dateFormat.format( new Date() );
//
//        System.out.println(hehe);
//
//
//        long bb = 123456L;
//
//        System.out.println( bb/100);

    }

    @Data
    static class People {
        private String name;
        private String addr;
    }
}
