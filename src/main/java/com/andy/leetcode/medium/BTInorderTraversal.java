package com.andy.leetcode.medium;

import com.andy.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author   : andy.gao
 * Mail     : gaochao07@meituan.com
 * Date     : 2019-07-23
 * Project  : leetcode
 */
public class BTInorderTraversal {
    /**
     * Given a binary tree, return the inorder traversal of its nodes' values.
     * <p>
     * Example:
     * <p>
     * Input: [1,null,2,3]
     * 1
     * \
     * 2
     * /
     * 3
     * <p>
     * Output: [1,3,2]
     * Follow up: Recursive solution is trivial, could you do it iteratively?
     *
     * @link https://leetcode.com/problems/binary-tree-inorder-traversal/
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !nodes.isEmpty()) {
            while (cur != null) {
                nodes.push(cur);
                cur = cur.left;
            }
            if (!nodes.isEmpty()) {
                cur = nodes.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(new BTInorderTraversal().inorderTraversal(root));
    }
}
