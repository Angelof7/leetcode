package com.andy.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy on 2019/6/12.
 */
public class SpiralMatrix {
    /**
     * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
     * <p>
     * Example 1:
     * <p>
     * Input:
     * [
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * ]
     * Output: [1,2,3,6,9,8,7,4,5]
     * Example 2:
     * <p>
     * Input:
     * [
     * [1, 2, 3, 4],
     * [5, 6, 7, 8],
     * [9,10,11,12]
     * ]
     * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        // spiral访问时的行变化
        int[] dr = new int[]{0, 1, 0, -1};
        // spiral访问时的列变化
        int[] dc = new int[]{1, 0, -1, 0};
        int r = 0, c = 0;
        int di = 0;
        for (int i = 0; i < rows * cols; i++) {
            result.add(matrix[r][c]);
            visited[r][c] = true;

            int nextR = r + dr[di];
            int nextC = c + dc[di];
            if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols && !visited[nextR][nextC]) {
                r = nextR;
                c = nextC;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return result;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int c1 = 0, c2 = cols - 1;
        int r1 = 0, r2 = rows - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) {
                result.add(matrix[r1][c]);
            }
            for (int r = r1 + 1; r <= r2; r++) {
                result.add(matrix[r][c2]);
            }
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) {
                    result.add(matrix[r2][c]);
                }
                for (int r = r2; r > r1; r--) {
                    result.add(matrix[r][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {
                        6, 9, 7
                }
        };
        System.out.println(new SpiralMatrix().spiralOrder2(matrix));
    }
}
