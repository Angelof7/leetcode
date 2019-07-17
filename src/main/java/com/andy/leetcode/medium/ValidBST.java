package com.andy.leetcode.medium;

import com.andy.leetcode.common.TreeNode;

/**
 * Created by andy on 2019/7/17.
 */
public class ValidBST {
    /**
     * Given a binary tree, determine if it is a valid binary search tree (BST).
     * <p>
     * Assume a BST is defined as follows:
     * <p>
     * The left subtree of a node contains only nodes with keys less than the node's key.
     * The right subtree of a node contains only nodes with keys greater than the node's key.
     * Both the left and right subtrees must also be binary search trees.
     * <p>
     * <p>
     * Example 1:
     * <p>
     * 2
     * / \
     * 1   3
     * <p>
     * Input: [2,1,3]
     * Output: true
     * Example 2:
     * <p>
     * 5
     * / \
     * 1   4
     * / \
     * 3   6
     * <p>
     * Input: [5,1,4,null,null,3,6]
     * Output: false
     * Explanation: The root node's value is 5 but its right child's value is 4.
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        if (lower != null && root.val <= lower) {
            return false;
        }
        if (upper != null && root.val >= upper) {
            return false;
        }
        return helper(root.left, lower, root.val) && helper(root.right, root.val, upper);
    }
}
