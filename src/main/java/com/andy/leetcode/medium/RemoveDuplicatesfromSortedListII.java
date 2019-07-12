package com.andy.leetcode.medium;

import com.andy.leetcode.common.ListNode;
import com.andy.leetcode.common.PrintListUtil;

/**
 * Created by andy on 2019/7/12.
 */
public class RemoveDuplicatesfromSortedListII {
    /**
     * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
     * <p>
     * Example 1:
     * <p>
     * Input: 1->2->3->3->4->4->5
     * Output: 1->2->5
     * Example 2:
     * <p>
     * Input: 1->1->1->2->3
     * Output: 2->3
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fakeHead = new ListNode(-1);
        ListNode pre = fakeHead;
        pre.next = head;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }
            if (cur != pre.next) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return fakeHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        PrintListUtil.print(head);
        head = new RemoveDuplicatesfromSortedListII().deleteDuplicates(head);
        PrintListUtil.print(head);
    }
}
