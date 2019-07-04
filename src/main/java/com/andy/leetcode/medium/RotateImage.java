package com.andy.leetcode.medium;

import com.andy.leetcode.common.PrintArrayUtil;

/**
 * Created by andy on 2019/7/4.
 */
public class RotateImage {
    /**
     * You are given an n x n 2D matrix representing an image.
     * <p>
     * Rotate the image by 90 degrees (clockwise).
     * <p>
     * Note:
     * <p>
     * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
     * <p>
     * Example 1:
     * <p>
     * Given input matrix =
     * [
     * [1,2,3],
     * [4,5,6],
     * [7,8,9]
     * ],
     * <p>
     * rotate the input matrix in-place such that it becomes:
     * [
     * [7,4,1],
     * [8,5,2],
     * [9,6,3]
     * ]
     * Example 2:
     * <p>
     * Given input matrix =
     * [
     * [ 5, 1, 9,11],
     * [ 2, 4, 8,10],
     * [13, 3, 6, 7],
     * [15,14,12,16]
     * ],
     * <p>
     * rotate the input matrix in-place such that it becomes:
     * [
     * [15,13, 2, 5],
     * [14, 3, 4, 1],
     * [12, 6, 8, 9],
     * [16, 7,10,11]
     * ]
     *
     * @link https://leetcode.com/problems/rotate-image/
     */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len / 2; i++) {
            int max;
            if (len % 2 == 0) {
                //if the number of rows is even.
                max = len / 2 - 1;
            } else {
                //if the number of rows is odd.
                max = len / 2;
            }
            for (int j = 0; j <= max; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][i];
                matrix[len - 1 - j][i] = matrix[len - 1 - i][len - 1 - j];
                matrix[len - 1 - i][len - 1 - j] = matrix[j][len - 1 - i];
                matrix[j][len - 1 - i] = t;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}

        };
        PrintArrayUtil.print(matrix);
        new RotateImage().rotate(matrix);
        PrintArrayUtil.print(matrix);
    }
}
