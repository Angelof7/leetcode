package com.andy.leetcode.easy;

/**
 * Created by andy on 2019/5/8.
 */
public class MergeTwoSortedLists {
    /**
     * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
     * <p>
     * Example:
     * <p>
     * Input: 1->2->4, 1->3->4
     * Output: 1->1->2->3->4->4
     *
     * @seehttps://leetcode.com/problems/merge-two-sorted-lists/submissions/
     */


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 合并后的头节点
        ListNode mergedList = null;
        // 合并后的尾节点
        ListNode p = null;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (mergedList == null) {
                    // first merge
                    mergedList = l1;
                    p = mergedList;
                } else {
                    p.next = l1;
                    p = p.next;
                }
                l1 = l1.next;
            } else {
                if (mergedList == null) {
                    // first merge
                    mergedList = l2;
                    p = mergedList;
                } else {
                    p.next = l2;
                    p = p.next;
                }
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            // l1还有剩余的节点
            if (p == null) {
                mergedList = l1;
            } else {
                p.next = l1;
            }
        }
        if (l2 != null) {
            // l2还有剩余的节点
            if (p == null) {
                mergedList = l2;
            } else {
                p.next = l2;
            }
        }
        return mergedList;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(4);
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node = new MergeTwoSortedLists().mergeTwoLists(node1, node2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
