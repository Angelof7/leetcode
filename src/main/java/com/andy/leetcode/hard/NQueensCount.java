package com.andy.leetcode.hard;

/**
 * Created by andy on 2019/5/21.
 */
public class NQueensCount {
    /**
     * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
     * <p>
     * <p>
     * <p>
     * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
     * <p>
     * Example:
     * <p>
     * Input: 4
     * Output: 2
     * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
     * [
     * [".Q..",  // Solution 1
     * "...Q",
     * "Q...",
     * "..Q."],
     * <p>
     * ["..Q.",  // Solution 2
     * "Q...",
     * "...Q",
     * ".Q.."]
     * ]
     *
     * @seehttps://leetcode.com/problems/n-queens-ii/
     */

    private int count;

    public int totalNQueens(int n) {
        // 第i列是否有queen
        boolean[] a = new boolean[n];
        // 左下至右上是否有queen
        boolean[] b = new boolean[2 * n - 1];
        // 坐上至右下是否有queen
        boolean[] c = new boolean[2 * n - 1];
        backtrack(0, a, b, c, n);
        return count;
    }

    private void backtrack(int row, boolean[] a, boolean[] b, boolean[] c, int n) {
        if (row == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            int indexA = i;
            int indexB = row + i;
            int indexC = row - i + n - 1;
            if (a[indexA] || b[indexB] || c[indexC]) {
                // 同列或者斜线上已经有queen
                continue;
            }
            a[indexA] = b[indexB] = c[indexC] = true;
            backtrack(row + 1, a, b, c, n);
            a[indexA] = b[indexB] = c[indexC] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new NQueensCount().totalNQueens(4));
        System.out.println(new NQueensCount().totalNQueens(8));
    }
}
