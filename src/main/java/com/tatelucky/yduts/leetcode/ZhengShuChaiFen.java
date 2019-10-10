package com.tatelucky.yduts.leetcode;

/**
 * 整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * 思路主要是把数字对3进行取整求余
 * 余数 1 3+1拆成 2*2
 * 余数 2 直接乘
 * 余数0 直接次方
 * <p>
 * 时间复杂度O(1)
 * 空间复杂度O(1)
 *
 * @author tangsheng
 * @since 2019-10-09
 */
public class ZhengShuChaiFen {
    public static int integerBreak(int n) {
        if (n <= 3)
            return n - 1;
        int a = n / 3, b = n % 3;
        if (b == 0)
            return (int) Math.pow(3, a);
        if (b == 1)
            return (int) Math.pow(3, a - 1) * 4;
        return (int) Math.pow(3, a) * 2;
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(11));

        //System.out.println(Math.pow(3, 4.4));
    }
}
