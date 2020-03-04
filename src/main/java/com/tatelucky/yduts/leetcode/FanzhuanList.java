package com.tatelucky.yduts.leetcode;

/**
 * @author tangsheng
 * @since 2020-03-04
 */
public class FanzhuanList {

    public MergeTwoLists.ListNode fanzhuan(MergeTwoLists.ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        MergeTwoLists.ListNode temp = head.next;
        MergeTwoLists.ListNode newHead = fanzhuan(head.next);

        temp.next = head.next;
        head.next = null;

        return newHead;
    }
}
