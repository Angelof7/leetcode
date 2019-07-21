package com.andy.leetcode.medium;

import com.andy.leetcode.common.ListNode;

/**
 * Created by andy on 2019/7/21.
 */
public class ReverseLinkedListII {

    /**
     * Reverse a linked list from position m to n. Do it in one-pass.
     * <p>
     * Note: 1 ≤ m ≤ n ≤ length of list.
     * <p>
     * Example:
     * <p>
     * Input: 1->2->3->4->5->NULL, m = 2, n = 4
     * Output: 1->4->3->2->5->NULL
     *
     * @link https://leetcode.com/problems/reverse-linked-list-ii/
     */

    private ListNode left;

    private boolean stop;

    public ListNode reverseBetween(ListNode head, int m, int n) {
        this.left = head;
        this.stop = false;
        recurseAndReverse(head, m, n);
        return head;
    }

    private void recurseAndReverse(ListNode right, int m, int n) {
        if (n == 1) {
            return;
        }
        right = right.next;
        if (m > 1) {
            this.left = this.left.next;
        }
        this.recurseAndReverse(right, m - 1, n - 1);

        if (this.left == right || right.next == this.left) {
            this.stop = true;
        }

        if (!this.stop) {
            int tmp = this.left.val;
            this.left.val = right.val;
            right.val = tmp;
            this.left = this.left.next;
        }
    }
}
