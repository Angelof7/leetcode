package com.andy.leetcode.medium;

import com.andy.leetcode.common.ListNode;
import com.andy.leetcode.common.PrintListUtil;

/**
 * Created by andy on 2019/6/2.
 */
public class SwapNodesInPairs {
    /**
     * Given a linked list, swap every two adjacent nodes and return its head.
     * <p>
     * You may not modify the values in the list's nodes, only nodes itself may be changed.
     * <p>
     * <p>
     * <p>
     * Example:
     * <p>
     * Given 1->2->3->4, you should return the list as 2->1->4->3.
     *
     * @link https://leetcode.com/problems/swap-nodes-in-pairs/
     */
    public ListNode swapPairs(ListNode head) {

        ListNode newHead = head;
        ListNode pre = null, cur = head;
        while (cur != null && cur.next != null) {
            if (pre == null) {
                newHead = cur.next;
            } else {
                pre.next = cur.next;
            }

            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = cur;

            pre = cur;
            cur = cur.next;

        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        PrintListUtil.print(new SwapNodesInPairs().swapPairs(head));

    }
}
