package com.tatelucky.yduts.leetcode;

/**
 * 有多少不重复的
 *
 * @author tangsheng
 * @since 2020-03-13
 */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;
        int len = nums.length;

        for (; fast < len; fast++) {
            if (nums[slow] != nums[fast]) {
                if (++slow == fast) {
                    continue;
                }
                nums[slow] = nums[fast];
            }

        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 2, 3, 4, 5, 5};
    }
}
