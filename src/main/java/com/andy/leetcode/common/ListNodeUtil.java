package com.andy.leetcode.common;

/**
 * Created by andy on 2019/6/9.
 */
public class ListNodeUtil {

    public static ListNode fromArray(int[] vals) {
        ListNode head = null;
        ListNode cur = null;
        for (int val : vals) {
            if (head == null) {
                head = new ListNode(val);
                cur = head;
            } else {
                cur.next = new ListNode(val);
                cur = cur.next;
            }
        }
        return head;
    }
}
