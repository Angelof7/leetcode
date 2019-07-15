package com.andy.leetcode.medium;

import com.andy.leetcode.common.ListNode;
import com.andy.leetcode.common.PrintListUtil;

/**
 * Created by andy on 2019/7/15.
 */
public class PartitionList {
    /**
     * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
     * <p>
     * You should preserve the original relative order of the nodes in each of the two partitions.
     * <p>
     * Example:
     * <p>
     * Input: head = 1->4->3->2->5->2, x = 3
     * Output: 1->2->2->4->3->5
     *
     * @link https://leetcode.com/problems/partition-list/
     */
    public ListNode partition(ListNode head, int x) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode pre = fakeHead;
        ListNode cur = head;

        ListNode insertPos = null;
        while (cur != null) {
            if (cur.val >= x && insertPos == null) {
                // find a insertPos
                insertPos = pre;
            }
            if (cur.val < x && insertPos != null) {
                // insert cur to insertPos's next
                pre.next = cur.next;
                cur.next = insertPos.next;
                insertPos.next = cur;

                // update insertPos
                insertPos = insertPos.next;

                // update cur
                cur = pre.next;
                continue;
            }

            pre = pre.next;
            cur = cur.next;
        }

        return fakeHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        new PartitionList().partition(head, 3);
        PrintListUtil.print(head);
    }
}
