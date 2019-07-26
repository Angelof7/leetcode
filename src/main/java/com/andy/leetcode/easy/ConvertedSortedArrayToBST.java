package com.andy.leetcode.easy;

import com.andy.leetcode.common.PrintTreeUtil;
import com.andy.leetcode.common.TreeNode;

/**
 * Author   : andy.gao
 * Date     : 2019-07-26
 * Project  : leetcode
 */
public class ConvertedSortedArrayToBST {
    /**
     * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
     * <p>
     * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
     * <p>
     * Example:
     * <p>
     * Given the sorted array: [-10,-3,0,5,9],
     * <p>
     * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
     * <p>
     * 0
     * / \
     * -3   9
     * /   /
     * -10  5
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return bst(nums, 0, nums.length - 1);
    }

    private TreeNode bst(int[] a, int left, int right) {
        if (left > right) {
            return null;
        }
        int n = left + right;
        if (n % 2 != 0) {
            n++;
        }
        TreeNode root = new TreeNode(a[n / 2]);
        root.left = bst(a, left, n / 2 - 1);
        root.right = bst(a, n / 2 + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                -10, -3, 0, 5, 9
        };
        TreeNode root = new ConvertedSortedArrayToBST().sortedArrayToBST(nums);
        PrintTreeUtil.print(root);
    }

}
