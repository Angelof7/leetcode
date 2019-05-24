package com.andy.leetcode.common;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by andy on 2019/5/24.
 */
public class PrintTreeUtil {

    public static void print(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node == null ? "null" : node.val);
            System.out.print(", ");
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        System.out.println();
    }
}
