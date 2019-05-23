package com.andy.leetcode.easy;

import com.andy.leetcode.common.TreeNode;

/**
 * Created by andy on 2019/5/23.
 */
public class MaxDepthOfBT {
    /**
     * Given a binary tree, find its maximum depth.
     * <p>
     * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     * <p>
     * Note: A leaf is a node with no children.
     * <p>
     * Example:
     * <p>
     * Given binary tree [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * return its depth = 3.
     *
     * @link https://leetcode.com/problems/maximum-depth-of-binary-tree/
     */
    public int maxDepth(TreeNode root) {
        return countDepth(root, 0);
    }

    private int countDepth(TreeNode root, int count) {
        if (root == null) {
            return count;
        }
        count++;
        return Math.max(countDepth(root.left, count), countDepth(root.right, count));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);


        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.left = new TreeNode(7);
        System.out.println(new MaxDepthOfBT().maxDepth(root));
    }
}
