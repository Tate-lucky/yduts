package com.tatelucky.yduts.thread;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author tangsheng
 * @since 2019-10-25
 */
@Data
@AllArgsConstructor
class User extends AtomicReference {
    private String name;
    private Integer age;
}


public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User user = new User("zhangsan", 12);
        User user2 = new User("lisi", 23);
        AtomicReference<User> userAtomicReference = new AtomicReference<>();

        userAtomicReference.set(user);

//        true	User(name=lisi, age=23)
//        false	User(name=lisi, age=23)
        System.out.println(userAtomicReference.compareAndSet(user, user2) + "\t" + userAtomicReference.get().toString());
        System.out.println(userAtomicReference.compareAndSet(user, user2) + "\t" + userAtomicReference.get().toString());


    }
}


