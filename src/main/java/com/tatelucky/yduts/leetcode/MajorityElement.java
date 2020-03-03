package com.tatelucky.yduts.leetcode;

import java.util.Arrays;

/**
 * @author tangsheng
 * @since 2020-03-03
 */
public class MajorityElement {

    public static int majorityElement(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2 && nums[0] != nums[1]) {
            return -1;
        }

        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5}));
        System.out.println(majorityElement(new int[]{1, 2}));
        System.out.println(majorityElement(new int[]{1}));
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));


    }
}
