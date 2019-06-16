package com.andy.leetcode.medium;

import com.andy.leetcode.common.PrintArrayUtil;

/**
 * Created by andy on 2019/6/16.
 */
public class SpiralMatrixII {
    /**
     * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
     * <p>
     * Example:
     * <p>
     * Input: 3
     * Output:
     * [
     * [ 1, 2, 3 ],
     * [ 8, 9, 4 ],
     * [ 7, 6, 5 ]
     * ]
     *
     * @link https://leetcode.com/problems/spiral-matrix-ii/
     */
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[][]{};
        }

        int[][] result = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        // spiral访问时的行变化
        int[] dr = new int[]{0, 1, 0, -1};
        // spiral访问时的列变化
        int[] dc = new int[]{1, 0, -1, 0};

        int row = 0, col = 0;
        int di = 0;
        int val = 1;
        for (int i = 0; i < n * n; i++) {
            result[row][col] = val++;
            visited[row][col] = true;

            int nextRow = row + dr[di];
            int nextCol = col + dc[di];
            if (nextRow >= n || nextCol >= n || nextRow < 0 || nextCol < 0 || visited[nextRow][nextCol]) {
                di = (di + 1) % 4;
                row = row + dr[di];
                col = col + dc[di];
            } else {
                row = nextRow;
                col = nextCol;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PrintArrayUtil.print(new SpiralMatrixII().generateMatrix(1));
        PrintArrayUtil.print(new SpiralMatrixII().generateMatrix(2));
        PrintArrayUtil.print(new SpiralMatrixII().generateMatrix(3));
        PrintArrayUtil.print(new SpiralMatrixII().generateMatrix(4));
    }
}
