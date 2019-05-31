package com.andy.leetcode.easy;

import com.andy.leetcode.common.TreeNode;

/**
 * Created by andy on 2019/5/31.
 */
public class SameTree {
    /**
     * Given two binary trees, write a function to check if they are the same or not.
     * <p>
     * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
     * <p>
     * Example 1:
     * <p>
     * Input:     1         1
     * / \       / \
     * 2   3     2   3
     * <p>
     * [1,2,3],   [1,2,3]
     * <p>
     * Output: true
     * Example 2:
     * <p>
     * Input:     1         1
     * /           \
     * 2             2
     * <p>
     * [1,2],     [1,null,2]
     * <p>
     * Output: false
     * Example 3:
     * <p>
     * Input:     1         1
     * / \       / \
     * 2   1     1   2
     * <p>
     * [1,2,1],   [1,1,2]
     * <p>
     * Output: false
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
