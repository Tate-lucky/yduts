package com.tatelucky.yduts.thread;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author tangsheng
 * @since 2019-11-20
 */
public class UnsafeTest1 {
    public static void main(String[] args) throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);

        //字段值的获取
        //1.1 静态字段获取 ；说明：静态字段的偏移量相对于该类的内存地址，即相对于 className.class 返回的对象；
        long staticFieldOffset = unsafe.staticFieldOffset(B.class.getDeclaredField("staticField"));
        //1.2 非静态字段 ；说明：该偏移量相对于该类的实例化对象的内存地址。
        long unstaticFieldOffset = unsafe.objectFieldOffset(B.class.getDeclaredField("objectField"));
        System.out.println("静态变量相对于类内存地址的偏移量 = " + staticFieldOffset);
        System.out.println("非静态变量相对于实例化对象的偏移量 = " + unstaticFieldOffset);

        //字段值的设置
        //1.3 修改非基本数据类型的值，使用：putObject(object , offset , value); 这里修改实例化对象b对应偏移地址字段的值；
        B b = new B();
        unsafe.putObject(b, unstaticFieldOffset, "hello world!");
        //1.3 修改基本数据类型的值，使用对应类型的put方法，如：int 使用 putInt(object , offset , value);
        unsafe.putInt(B.class, staticFieldOffset, 20);

        System.out.println("静态变量被修改后的值 = " + B.getStaticField());
        System.out.println("非静态变量被修改后的值 = " + b.getObjectField());
    }
}

class B {
    private static int staticField = 1;
    private String objectField = "hello";

    public static int getStaticField() {
        return staticField;
    }

    public String getObjectField() {
        return objectField;
    }
}
