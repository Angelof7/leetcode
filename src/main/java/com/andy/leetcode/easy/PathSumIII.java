package com.andy.leetcode.easy;

import com.andy.leetcode.common.TreeNode;

/**
 * Created by andy on 2019/5/30.
 */
public class PathSumIII {
    /**
     * You are given a binary tree in which each node contains an integer value.
     * <p>
     * Find the number of paths that sum to a given value.
     * <p>
     * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
     * <p>
     * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
     * <p>
     * Example:
     * <p>
     * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
     * <p>
     * 10
     * /  \
     * 5   -3
     * / \    \
     * 3   2   11
     * / \   \
     * 3  -2   1
     * <p>
     * Return 3. The paths that sum to 8 are:
     * <p>
     * 1.  5 -> 3
     * 2.  5 -> 2 -> 1
     * 3. -3 -> 11
     *
     * @link https://leetcode.com/problems/path-sum-iii/
     */
    private int count = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        backTrack(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return count;
    }

    private void backTrack(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (sum == root.val) {
            count++;
        }
        // 一条路径可能存在多个和为sum的
        backTrack(root.left, sum - root.val);
        backTrack(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);

        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        System.out.println(new PathSumIII().pathSum(root, 8));
    }
}
