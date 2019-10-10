package com.tatelucky.yduts.leetcode;

/**
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * <p>
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)你可以假设两个字符串均只含有小写字母。
 * 可以利用桶（一个数组）来解决，把magazine字符全统计好，【字母，次数】，然后遍历ransom,如果找不到或者次数为0就说明不够了
 * <p>
 * 想过用hashmap 来解决 【字母，次数】来解决，但是看到很巧的是看到别人用数组位置表示字母 a[magazine.charAt(i) - 'a'] 来做为数组下标，这个想法还是很有创造性的
 * <p>
 * 时间复杂度O（n）
 * 空间复杂度O(1)
 *
 * @author tangsheng
 * @since 2019-10-10
 */
public class Ransom {

    public static boolean canConstruct(String ransomNote, String magazine) {
        //目前只有小写字母
        int[] bag = new int[26];

        //遍历magazine
        for (int i = 0; i < magazine.length(); i++) {
            bag[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (--bag[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("cbad", "aabbcc"));
    }
}
