package com.andy.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy on 2019/5/21.
 */
public class NQueensII {
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
        List<String> puzzle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            puzzle.add(".");
        }
        backtrack(puzzle, 0, n);
        return count;
    }

    private void backtrack(List<String> puzzle, int row, int n) {
        if (row == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            puzzle.set(row, getQStr(i, n));
            if (isValid(puzzle, row, i)) {
                backtrack(puzzle, row + 1, n);
            }
        }
    }

    private String getQStr(int column, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == column) {
                sb.append("Q");
            } else {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    private boolean isValid(List<String> puzzle, int row, int column) {
        for (int i = 0; i < row; i++) {
            int index = puzzle.get(i).indexOf("Q");
            if (index == column ||
                    Math.abs(i - row) == Math.abs(index - column)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new NQueensII().totalNQueens(4));
        System.out.println(new NQueensII().totalNQueens(8));
    }


}
