package com.tatelucky.yduts.math;

import java.math.BigInteger;

/**
 * 二进制的数据表达具有抗干扰能力强、可靠性高的优点
 * 二进制也非常适合逻辑运算。
 * 逻辑运算中的“真”和“假”，正好与二进制 的“0”和“1”两个数字相对应。
 * 逻辑运算中的加法(“或”运算)、乘法(“与”运算)以 及否定(“非”运算)
 * 都可以通过“0”和“1”的加法、乘法和减法来实现
 *
 * @author tangsheng
 * @since 2019-12-10
 */
public class TenDemo {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger(String.valueOf(5));
        //转成2进制
        System.out.println(bigInteger.toString(2));

        //2进制转成10进制
        BigInteger bigInteger2 = new BigInteger("101", 2);
        System.out.println(bigInteger2.toString());

        //左移 乘以2^n的意思（无溢出的情况） 结果2
        System.out.println(1 << 1);

        //右移 除以2^n取整 结果136 1 -1 1073741815
        System.out.println(34 << 2);

        System.out.println(2 >> 1);
        System.out.println(-1 >> 1);
        System.out.println(-34 >>> 2);


        //为什么右移有两个 >> >>> Java中二进制是有符号位的，最高位 0 正数 1  负数
        // 逻辑右移>>>  左边直接补0   无符号右移
        // 算术右移>>    符号位不变   带符号右移   除符号位置右移一位并补0

        //与  0 1 0
        System.out.println(1 & 0);
        System.out.println(1 & 1);
        System.out.println(0 & 0);

        //或 1 1 0
        System.out.println(1 | 0);
        System.out.println(1 | 1);
        System.out.println(0 | 0);

        //异或 1 0 0  一般用来判断是不是不一样，一样为0，不一样为1
        System.out.println(1 ^ 0);
        System.out.println(1 ^ 1);
        System.out.println(0 ^ 0);
    }
}
