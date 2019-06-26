package com.andy.leetcode.medium;

import com.andy.leetcode.common.PrintArrayUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by andy on 2019/6/26.
 */
public class SetMatrixZeroes {
    /**
     * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
     * <p>
     * Example 1:
     * <p>
     * Input:
     * [
     * [1,1,1],
     * [1,0,1],
     * [1,1,1]
     * ]
     * Output:
     * [
     * [1,0,1],
     * [0,0,0],
     * [1,0,1]
     * ]
     * Example 2:
     * <p>
     * Input:
     * [
     * [0,1,2,0],
     * [3,4,5,2],
     * [1,3,1,5]
     * ]
     * Output:
     * [
     * [0,0,0,0],
     * [0,4,5,0],
     * [0,3,1,0]
     * ]
     * Follow up:
     * <p>
     * A straight forward solution using O(mn) space is probably a bad idea.
     * A simple improvement uses O(m + n) space, but still not the best solution.
     * Could you devise a constant space solution?
     *
     * @link https://leetcode.com/problems/set-matrix-zeroes/
     */
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (Integer row : rows) {
            for (int j = 0; j < m; j++) {
                matrix[row][j] = 0;
            }
        }
        for (Integer col : cols) {
            for (int i = 0; i < n; i++) {
                matrix[i][col] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        new SetMatrixZeroes().setZeroes(matrix);
        PrintArrayUtil.print(matrix);

    }
}
