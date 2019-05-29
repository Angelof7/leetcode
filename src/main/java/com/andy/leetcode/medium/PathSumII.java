package com.andy.leetcode.medium;

import com.andy.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy on 2019/5/29.
 */
public class PathSumII {
    /**
     * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
     * <p>
     * Note: A leaf is a node with no children.
     * <p>
     * Example:
     * <p>
     * Given the below binary tree and sum = 22,
     * <p>
     * 5
     * / \
     * 4   8
     * /   / \
     * 11  13  4
     * /  \    / \
     * 7    2  5   1
     * Return:
     * <p>
     * [
     * [5,4,11,2],
     * [5,8,4,5]
     * ]
     *
     * @link https://leetcode.com/problems/path-sum-ii/
     */
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        backTrack(root, new ArrayList<>(), sum);
        return result;
    }

    private void backTrack(TreeNode root, List<Integer> vals, int sum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            //leaf node
            if (sum == root.val) {
                vals.add(sum);
                result.add(new ArrayList<>(vals));
                vals.remove(vals.size() - 1);
            }
            return;
        }
        vals.add(root.val);
        backTrack(root.left, vals, sum - root.val);
        backTrack(root.right, vals, sum - root.val);
        vals.remove(vals.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        System.out.println(new PathSumII().pathSum(root, 22));
    }
}
