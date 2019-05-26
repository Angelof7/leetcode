package com.andy.leetcode.hard;

import com.andy.leetcode.common.ListNode;
import com.andy.leetcode.common.PrintListUtil;

/**
 * Created by andy on 2019/5/26.
 */
public class MergeKSortedLists {
    /**
     * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
     * <p>
     * Example:
     * <p>
     * Input:
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * Output: 1->1->2->3->4->4->5->6
     *
     * @link https://leetcode.com/problems/merge-k-sorted-lists/
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode cur = null;

        ListNode min = findMin(lists);
        while (min != null) {
            if (head == null) {
                // 合并后的第一个节点
                head = min;
                cur = min;
            } else {
                cur.next = min;
                cur = min;
            }
            min = findMin(lists);
        }

        return head;
    }

    private ListNode findMin(ListNode[] lists) {
        ListNode min = null;
        int index = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && (min == null || lists[i].val < min.val)) {
                min = lists[i];
                index = i;
            }
        }
        if (min != null) {
            // 待合并的节点往后移一节点
            lists[index] = min.next;
        }
        return min;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);

        PrintListUtil.print(new MergeKSortedLists().mergeKLists(new ListNode[]{head1, head2, head3}));
    }
}
