package com.andy.leetcode.common;

/**
 * Created by andy on 2019/5/25.
 */
public class PrintListUtil {

    public static void print(ListNode head) {
        boolean first = true;
        while (head != null) {
            if (!first) {
                System.out.print("->");
            }
            first = false;
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
    }
}
