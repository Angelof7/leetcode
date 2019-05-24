package com.andy.leetcode.medium;

import com.andy.leetcode.common.PrintTreeUtil;
import com.andy.leetcode.common.TreeNode;

import java.util.Arrays;

/**
 * Created by andy on 2019/5/24.
 */
public class ConstructBTFromInorderAndPreOrderTraversal {
    /**
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     * <p>
     * Note:
     * You may assume that duplicates do not exist in the tree.
     * <p>
     * For example, given
     * <p>
     * preorder = [3,9,20,15,7]
     * inorder = [9,3,15,20,7]
     * Return the following binary tree:
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) {
            return root;
        }
        int rootIndex = findRootIndex(inorder, preorder[0]);
        if (rootIndex > 0) {
            root.left = buildTree(
                    Arrays.copyOfRange(preorder, 1, rootIndex + 1),
                    Arrays.copyOfRange(inorder, 0, rootIndex));
        }
        if (rootIndex < preorder.length) {
            root.right = buildTree(
                    Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length),
                    Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length));
        }
        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return build(preorder, inorder, 0, 0, preorder.length);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preIndex,
                           int startInIndex, int endInIndex) {
        if (endInIndex < startInIndex) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preIndex]);

        // the index of current node in inorder
        int index = findRootIndex(inorder, preorder[preIndex]);
        int lenL = index - startInIndex;
        int lenR = endInIndex - startInIndex - lenL;

        if (lenL > 0) {
            node.left = build(preorder, inorder, preIndex + 1, startInIndex,
                    index - 1);
        }
        if (lenR > 0) {
            node.right = build(preorder, inorder, preIndex + lenL + 1,
                    index + 1, endInIndex);
        }

        return node;
    }

    private int findRootIndex(int[] array, int val) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] preorder = new int[]{
//                3, 9, 20, 15, 7
//        };
//        int[] inorder = new int[]{
//                9, 3, 15, 20, 7
//        };
        int[] preorder = new int[]{
                1, 2, 3
        };
        int[] inorder = new int[]{
                2, 3, 1
        };
        TreeNode root = new ConstructBTFromInorderAndPreOrderTraversal().buildTree(preorder, inorder);
        PrintTreeUtil.print(root);
        root = new ConstructBTFromInorderAndPreOrderTraversal().build(preorder, inorder, 0, 0, 2);
        PrintTreeUtil.print(root);

    }

}
