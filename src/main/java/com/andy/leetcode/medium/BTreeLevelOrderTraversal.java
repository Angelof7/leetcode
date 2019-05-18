package com.andy.leetcode.medium;

import com.andy.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy on 2019/5/18.
 */
public class BTreeLevelOrderTraversal {
    /**
     * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
     * <p>
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * return its level order traversal as:
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     *
     * @seehttps://leetcode.com/problems/binary-tree-level-order-traversal/
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        List<TreeNode> levelNodes = new ArrayList<>();
        levelNodes.add(root);
        while (levelNodes.size() > 0) {
            List<Integer> levelVals = new ArrayList<>();
            List<TreeNode> nextLevelNodes = new ArrayList<>();
            for (TreeNode treeNode : levelNodes) {
                if (treeNode == null) {
                    continue;
                }
                levelVals.add(treeNode.val);
                nextLevelNodes.add(treeNode.left);
                nextLevelNodes.add(treeNode.right);
            }
            levelNodes = nextLevelNodes;
            if (levelVals.size() > 0) {
                result.add(levelVals);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new BTreeLevelOrderTraversal().levelOrder(root));
    }
}
