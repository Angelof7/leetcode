package com.andy.leetcode.easy;

import com.andy.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author   : andy.gao
 * Mail     : gaochao07@meituan.com
 * Date     : 2019-07-31
 * Project  : leetcode
 */
public class BinaryTreeLevelOrderTraversalII {
    /**
     * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
     * <p>
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * return its bottom-up level order traversal as:
     * [
     * [15,7],
     * [9,20],
     * [3]
     * ]
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        ans = helper(level);
        return ans;
    }

    private List<List<Integer>> helper(List<TreeNode> level) {
        List<TreeNode> next = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (TreeNode node : level) {
            if (node.left != null)
                next.add(node.left);
            if (node.right != null)
                next.add(node.right);
        }
        if (next.size() != 0) {
            ans = helper(next);
        }
        List<Integer> temp = new ArrayList<>();
        for (TreeNode node : level) {
            temp.add(node.val);
        }
        ans.add(temp);
        return ans;
    }
}
