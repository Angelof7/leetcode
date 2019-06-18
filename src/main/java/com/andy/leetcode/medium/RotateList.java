package com.andy.leetcode.medium;

import com.andy.leetcode.common.ListNode;
import com.andy.leetcode.common.PrintListUtil;

/**
 * Author   : andy.gao
 * Date     : 2019-06-18
 * Project  : leetcode
 */
public class RotateList {
    /**
     * Given a linked list, rotate the list to the right by k places, where k is non-negative.
     * <p>
     * Example 1:
     * <p>
     * Input: 1->2->3->4->5->NULL, k = 2
     * Output: 4->5->1->2->3->NULL
     * Explanation:
     * rotate 1 steps to the right: 5->1->2->3->4->NULL
     * rotate 2 steps to the right: 4->5->1->2->3->NULL
     * Example 2:
     * <p>
     * Input: 0->1->2->NULL, k = 4
     * Output: 2->0->1->NULL
     * Explanation:
     * rotate 1 steps to the right: 2->0->1->NULL
     * rotate 2 steps to the right: 1->2->0->NULL
     * rotate 3 steps to the right: 0->1->2->NULL
     * rotate 4 steps to the right: 2->0->1->NULL
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode p = head;
        int size = 0;
        while (p != null) {
            p = p.next;
            size++;
        }
        // 需要翻转的size
        k %= size;
        if (k == 0) {
            // 原样
            return head;
        }

        p = head;
        int step = size - k;
        while (--step > 0) {
            p = p.next;
        }
        // new tail
        ListNode newTail = p;
        // new head
        ListNode newHead = p.next;

        p = p.next;
        newTail.next = null;

        while (p.next != null) {
            p = p.next;
        }
        p.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        PrintListUtil.print(head);
        PrintListUtil.print(new RotateList().rotateRight(head, 4));
    }

}
