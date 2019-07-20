package com.andy.leetcode.easy;

import com.andy.leetcode.common.ListNode;
import com.andy.leetcode.common.PrintListUtil;

/**
 * Created by andy on 2019/7/20.
 */
public class ReverseLinkedList {
    /**
     * Reverse a singly linked list.
     * <p>
     * Example:
     * <p>
     * Input: 1->2->3->4->5->NULL
     * Output: 5->4->3->2->1->NULL
     * Follow up:
     * <p>
     * A linked list can be reversed either iteratively or recursively. Could you implement both?
     *
     * @link https://leetcode.com/problems/reverse-linked-list/
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        ListNode newHead = head;
        while (newHead != tail) {
            ListNode tmp = newHead;
            newHead = newHead.next;
            tmp.next = tail.next;
            tail.next = tmp;
        }
        return newHead;
    }

    private ListNode reverseList(ListNode head, ListNode next) {
        if (next == null) {
            return head;
        }
        ListNode newHead = reverseList(next, next.next);
        next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        PrintListUtil.print(head);
        head = new ReverseLinkedList().reverseList(head);
        PrintListUtil.print(head);
    }
}
