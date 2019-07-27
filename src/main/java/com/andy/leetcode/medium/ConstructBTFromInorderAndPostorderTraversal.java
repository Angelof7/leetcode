package com.andy.leetcode.medium;

import com.andy.leetcode.common.PrintTreeUtil;
import com.andy.leetcode.common.TreeNode;

/**
 * Created by andy on 2019/7/27.
 */
public class ConstructBTFromInorderAndPostorderTraversal {
    /**
     * Given inorder and postorder traversal of a tree, construct the binary tree.
     * <p>
     * Note:
     * You may assume that duplicates do not exist in the tree.
     * <p>
     * For example, given
     * <p>
     * inorder = [9,3,15,20,7]
     * postorder = [9,15,7,20,3]
     * Return the following binary tree:
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return build(inorder, postorder, 0, postorder.length - 1, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int startIndex, int endIndex, int postIndex) {
        if (postIndex < 0 || endIndex < startIndex) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex]);

        int rootIndex = findRootIndex(inorder, postorder[postIndex]);
        int leftLen = rootIndex - startIndex;
        int rightLen = endIndex - rootIndex;

        if (leftLen > 0) {
            root.left = build(inorder, postorder, startIndex, rootIndex - 1, postIndex - 1 - rightLen);
        }

        if (rightLen > 0) {
            root.right = build(inorder, postorder, rootIndex + 1, endIndex, postIndex - 1);
        }

        return root;
    }

    private int findRootIndex(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{
                9, 3, 15, 20, 7
        };
        int[] postorder = new int[]{
                9, 15, 7, 20, 3
        };
        PrintTreeUtil.print(new ConstructBTFromInorderAndPostorderTraversal().buildTree(inorder, postorder));
    }
}

