package com.andy.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy on 2019/5/20.
 */
public class NQueens {
    /**
     * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
     * <p>
     * <p>
     * <p>
     * Given an integer n, return all distinct solutions to the n-queens puzzle.
     * <p>
     * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
     * <p>
     * Example:
     * <p>
     * Input: 4
     * Output: [
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
     * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
     *
     * @seehttps://leetcode.com/problems/n-queens/
     */
    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<String> puzzle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            puzzle.add(".");
        }
        placeNextQueen(puzzle, 0, n);
        return result;
    }

    private void placeNextQueen(List<String> puzzle, int row, int n) {
        if (row == n) {
            result.add((List<String>) ((ArrayList<String>) puzzle).clone());
            return;
        }
        for (int i = 0; i < n; i++) {
            puzzle.set(row, getQStr(n, i));
            if (isValid(puzzle, row, i, n)) {
                placeNextQueen(puzzle, row + 1, n);
            }
        }
    }

    private String getQStr(int n, int index) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i != index) {
                sb.append(".");
            } else {
                sb.append("Q");
            }
        }
        return sb.toString();
    }

//    private boolean isValid(List<String> puzzle, int row, int column, int n) {
//        for (int i = 0; i < row; i++) {
//            if (puzzle.get(i).substring(column, column + 1).equals("Q")) {
//                // 同一列不得有Q
//                return false;
//            }
//        }
//        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
//            if (puzzle.get(i).substring(j, j + 1).equals("Q")) {
//                // 左斜方不得有Q
//                return false;
//            }
//        }
//        for (int i = row - 1, j = column + 1; i >= 0 && j < n; i--, j++) {
//            if (puzzle.get(i).substring(j, j + 1).equals("Q")) {
//                // 右斜方不得有Q
//                return false;
//            }
//        }
//        return true;
//    }

    private boolean isValid(List<String> puzzle, int row, int column, int n) {
        for (int i = 0; i < row; i++) {
            int columnIndex = puzzle.get(i).indexOf("Q");
            if (columnIndex == column ||
                    Math.abs(row - i) == Math.abs(column - columnIndex)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(4));
    }
}
