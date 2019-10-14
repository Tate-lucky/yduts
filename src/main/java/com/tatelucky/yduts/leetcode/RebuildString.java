package com.tatelucky.yduts.leetcode;

/**
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * <p>
 * S 只包含小写字母并且长度在[1, 500]区间内。
 *
 * @author tangsheng
 * @since 2019-10-11
 */
public class RebuildString {

    public static String reorganizeString(String s) {
        if (null == s) {
            return "";
        }

        if (s.length() == 1) {
            return s;
        }

        char[] str = s.toCharArray();
        //TODO

        return null;

    }


    public static void main(String[] args) {
        System.out.println(reorganizeString("123456"));
    }
}
