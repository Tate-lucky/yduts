package com.tatelucky.yduts.leetcode;

/**
 * 因为是有序数组，只需要两个两个的比不一样就可以判断了，都一样就是最后一个了
 *
 * @author tangsheng
 * @since 2020-03-01
 */
public class SingleNonDuplicate {

    public static int singleNonDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
    }
}
