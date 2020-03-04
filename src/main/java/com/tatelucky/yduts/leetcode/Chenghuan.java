package com.tatelucky.yduts.leetcode;

/**
 * @author tangsheng
 * @since 2020-03-04
 */
public class Chenghuan {

    public static boolean isHuan(MergeTwoLists.ListNode head) {
        if (null == head || head.next == null) {
            return false;
        }
        MergeTwoLists.ListNode first = head;
        MergeTwoLists.ListNode second = head;
        while (first.next != null && second.next != null) {
            first = first.next;
            second = second.next.next;
            if (first == second) {
                return true;
            }
        }
        return false;
    }
}
