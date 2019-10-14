package com.tatelucky.yduts.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * 大小写字母切换:s[i]^=(1<<5);
 *
 * @author tangsheng
 * @since 2019-10-14
 */
public class DaXiaoQuanPaiLie {
    public static void main(String[] args) {
        String a = "a1b2c3";
        System.out.println(letterCasePermutation(a));
    }

    public static List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<String>();
        dg(S.toCharArray(), 0, ans);
        return ans;
    }

    public static void dg(char[] s, int i, List<String> ans) {
        if (i == s.length) {
            ans.add(String.valueOf(s));
            return;
        }
        dg(s, i + 1, ans);
        if (s[i] < '0' || s[i] > '9') {
            s[i] ^= (1 << 5);
            dg(s, i + 1, ans);
        }

    }
}
