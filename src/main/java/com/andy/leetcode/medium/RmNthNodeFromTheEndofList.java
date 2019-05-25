package com.andy.leetcode.medium;

import com.andy.leetcode.common.ListNode;
import com.andy.leetcode.common.PrintListUtil;

/**
 * Created by andy on 2019/5/25.
 */
public class RmNthNodeFromTheEndofList {
    /**
     * Given a linked list, remove the n-th node from the end of list and return its head.
     * <p>
     * Example:
     * <p>
     * Given linked list: 1->2->3->4->5, and n = 2.
     * <p>
     * After removing the second node from the end, the linked list becomes 1->2->3->5.
     * Note:
     * <p>
     * Given n will always be valid.
     * <p>
     * Follow up:
     * <p>
     * Could you do this in one pass?
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }
        // 指向待删节点前一个（头节点特殊）
        ListNode pre = head;
        ListNode cur = head;
        int count = 0;

        while (cur != null) {
            cur = cur.next;
            if (cur == null) {
                // 到最后了
                if (pre == head && count + 1 == n) {
                    // 删除第一个
                    head = head.next;
                } else if (count == n) {
                    // 删除节点
                    pre.next = pre.next.next;
                }
            } else {
                if (count != n) {
                    count++;
                } else {
                    pre = pre.next;
                }
            }

        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        PrintListUtil.print(head);
        PrintListUtil.print(new RmNthNodeFromTheEndofList().removeNthFromEnd(head, 0));
    }
}
