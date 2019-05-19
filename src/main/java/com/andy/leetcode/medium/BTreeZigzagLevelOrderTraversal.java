package com.andy.leetcode.medium;

import com.andy.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy on 2019/5/19.
 */
public class BTreeZigzagLevelOrderTraversal {
    /**
     * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
     * <p>
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * return its zigzag level order traversal as:
     * [
     * [3],
     * [20,9],
     * [15,7]
     * ]
     *
     * @seehttps://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> levelNodes = new ArrayList<>();
        levelNodes.add(root);
        boolean flag = true;
        while (levelNodes.size() > 0) {
            List<Integer> levelVals = new ArrayList<>();
            List<TreeNode> nextLevelNodes = new ArrayList<>();
            // left -> right
            for (TreeNode levelNode : levelNodes) {
                if (levelNode == null) {
                    continue;
                }
                levelVals.add(levelNode.val);
                nextLevelNodes.add(levelNode.left);
                nextLevelNodes.add(levelNode.right);
            }

            if (levelVals.size() > 0) {
                if (flag) {
                    flag = false;
                } else {
                    // reverse
                    reverseList(levelVals);
                    flag = true;
                }
                result.add(levelVals);

            }
            levelNodes = nextLevelNodes;
        }
        return result;
    }

    private void reverseList(List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new BTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root));
    }
}
