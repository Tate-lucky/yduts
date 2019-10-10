package com.tatelucky.yduts.leetcode;

/**
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题
 * 主要是要运用双指针来解决这个问题,同时两数交换通过异或操作减少内存使用
 * <p>
 * 时间复杂度 O（n）
 * 额外空间 O（1）
 *
 * @author tangsheng
 * @since 2019-10-10
 */
public class FanZhuanString {


    public static void reverseString(char[] s) {
        if (null == s || s.length < 2) {
            return;
        }
        int left = -1;
        int right = s.length;
        while (++left < --right) {
            swap(s, left, right);
        }
        System.out.println(new String(s));
    }

    private static void swap(char[] s, int left, int right) {
        s[left] ^= s[right];
        s[right] ^= s[left];
        s[left] ^= s[right];
    }

    public static void main(String[] args) {

        char[] a = new char[]{'a', 'b', 'c', 'a', 'b', 'c'};
        reverseString(a);
        //异或操作，两数相同为0，否则相加，可以用来做数据判断
        //System.out.println( 2 ^ 0);


    }
}
