package com.andy.leetcode.easy;

import com.andy.leetcode.common.ListNode;
import com.andy.leetcode.common.PrintListUtil;

/**
 * Created by andy on 2019/6/28.
 */
public class RmDuplicatesFromSortedList {
    /**
     * Given a sorted linked list, delete all duplicates such that each element appear only once.
     * <p>
     * Example 1:
     * <p>
     * Input: 1->1->2
     * Output: 1->2
     * Example 2:
     * <p>
     * Input: 1->1->2->3->3
     * Output: 1->2->3
     *
     * @link https://leetcode.com/problems/remove-duplicates-from-sorted-list/
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            if (cur != null && cur.val != p.val) {
                p.next = cur;
                p = p.next;
            }
        }
        if (p != null) {
            p.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        PrintListUtil.print(head);
        PrintListUtil.print(new RmDuplicatesFromSortedList().deleteDuplicates(head));
    }
}
