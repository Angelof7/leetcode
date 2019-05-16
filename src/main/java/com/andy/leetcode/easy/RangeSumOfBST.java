package com.andy.leetcode.easy;

/**
 * Created by andy on 2019/5/16.
 */
public class RangeSumOfBST {
    /**
     * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
     * <p>
     * The binary search tree is guaranteed to have unique values.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
     * Output: 32
     * Example 2:
     * <p>
     * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
     * Output: 23
     * <p>
     * <p>
     * Note:
     * <p>
     * The number of nodes in the tree is at most 10000.
     * The final answer is guaranteed to be less than 2^31.
     *
     * @seehttps://leetcode.com/problems/range-sum-of-bst/
     */
    private int count;

    public int rangeSumBST(TreeNode root, int L, int R) {
        searchNext(root, L, R);
        return count;
    }

    private void searchNext(TreeNode root, int L, int R) {
        if (root == null) {
            return;
        }
//        if (root.val == L || root.val == R) {
//            count += root.val;
//        }
//        if (root.val > L && root.val < R) {
//            count += root.val;
//            searchNext(root.left, L, R);
//            searchNext(root.right, L, R);
//        } else if (root.val >= R) {
//            searchNext(root.left, L, R);
//        } else if (root.val <= L) {
//            searchNext(root.right, L, R);
//        }

        if (root.val >= L && root.val <= R) {
            count += root.val;
        }
        if (root.val > L) {
            searchNext(root.left, L, R);
        }
        if (root.val < R) {
            searchNext(root.right, L, R);
        }
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.left.left.left = new TreeNode(1);
        root.left.right.left = new TreeNode(6);

        root.right = new TreeNode(15);
        root.right.left = new TreeNode(13);
        root.right.left = new TreeNode(18);

        System.out.println(new RangeSumOfBST().rangeSumBST(root, 6, 10));
    }
}
