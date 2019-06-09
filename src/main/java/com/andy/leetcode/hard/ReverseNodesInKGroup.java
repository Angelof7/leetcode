package com.andy.leetcode.hard;

import com.andy.leetcode.common.ListNode;
import com.andy.leetcode.common.ListNodeUtil;
import com.andy.leetcode.common.PrintListUtil;

/**
 * Created by andy on 2019/6/9.
 */
public class ReverseNodesInKGroup {
    /**
     * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
     * <p>
     * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
     * <p>
     * Example:
     * <p>
     * Given this linked list: 1->2->3->4->5
     * <p>
     * For k = 2, you should return: 2->1->4->3->5
     * <p>
     * For k = 3, you should return: 3->2->1->4->5
     * <p>
     * Note:
     * <p>
     * Only constant extra memory is allowed.
     * You may not alter the values in the list's nodes, only nodes itself may be changed.
     *
     * @link https://leetcode.com/problems/reverse-nodes-in-k-group/
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            if (cur == null) {
                return head;
            }
            cur = cur.next;
        }
        ListNode newList = reverse(head, cur);
        head.next = reverseKGroup(cur, k);
        return newList;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = tail;
        while (head != tail) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode nullHead = new ListNode(-1);
        nullHead.next = head;
        ListNode pre = nullHead;
        ListNode cur = head;
        int num = 0;
        while (cur != null) {
            cur = cur.next;
            num++;
        }
        while (num >= k) {
            cur = pre.next;
            for (int i = 1; i < k; i++) {
                ListNode t = cur.next;
                cur.next = t.next;
                t.next = pre.next;
                pre.next = t;
            }
            pre = cur;
            num -= k;
        }
        return nullHead.next;

    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.fromArray(new int[]{1, 2, 3, 4, 5});
        System.out.print("Input: ");
        PrintListUtil.print(head);
        System.out.print("Output(1): ");
        PrintListUtil.print(new ReverseNodesInKGroup().reverseKGroup2(head, 1));
        head = ListNodeUtil.fromArray(new int[]{1, 2, 3, 4, 5});
        System.out.print("Output(2): ");
        PrintListUtil.print(new ReverseNodesInKGroup().reverseKGroup2(head, 2));
        head = ListNodeUtil.fromArray(new int[]{1, 2, 3, 4, 5});
        System.out.print("Output(3): ");
        PrintListUtil.print(new ReverseNodesInKGroup().reverseKGroup2(head, 3));
        head = ListNodeUtil.fromArray(new int[]{1, 2, 3, 4, 5});
        System.out.print("Output(4): ");
        PrintListUtil.print(new ReverseNodesInKGroup().reverseKGroup2(head, 4));
        head = ListNodeUtil.fromArray(new int[]{1, 2, 3, 4, 5});
        System.out.print("Output(5): ");
        PrintListUtil.print(new ReverseNodesInKGroup().reverseKGroup2(head, 5));
        head = ListNodeUtil.fromArray(new int[]{1, 2, 3, 4, 5});
        System.out.print("Output(6): ");
        PrintListUtil.print(new ReverseNodesInKGroup().reverseKGroup2(head, 6));
    }
}
