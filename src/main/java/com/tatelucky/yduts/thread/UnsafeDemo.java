package com.tatelucky.yduts.thread;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * unsafe Demo
 * unsafe 被final修饰了，没法去直接创建
 * Unsafe.getUnsafe() 方法只能被类加载器Bootstrap ClassLoader(rt.jar) 使用，使用起来还是比较的麻烦
 * 所以直接反射
 *
 * @author tangsheng
 * @since 2019-11-20
 */
public class UnsafeDemo {
    private static sun.misc.Unsafe UNSAFE;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            UNSAFE = (Unsafe) field.get(null);
            System.out.println(UNSAFE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            UnsafePerson person = new UnsafePerson();
            person.setName("name");
            person.setAge(18);

            System.out.println("修改前person: " + person.toString());

            Field ageField = UnsafePerson.class.getDeclaredField("age");
            // 替换age的值,修改非基本数据类型的值，使用：putObject(object , offset , value),
            // 基本类型使用使用对应类型的put方法，如：int 使用 putInt(object , offset , value)
            // 非静态字段使用objectFieldOffset，静态字段使用 staticFieldOffset
            UNSAFE.putObject(person, UNSAFE.objectFieldOffset(ageField), 19);

            System.out.println("修改后person: " + person.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
