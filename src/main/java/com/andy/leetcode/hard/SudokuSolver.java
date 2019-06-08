package com.andy.leetcode.hard;

import com.andy.leetcode.common.PrintArrayUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by andy on 2019/6/8.
 */
public class SudokuSolver {
    /**
     * Write a program to solve a Sudoku puzzle by filling the empty cells.
     * <p>
     * A sudoku solution must satisfy all of the following rules:
     * <p>
     * Each of the digits 1-9 must occur exactly once in each row.
     * Each of the digits 1-9 must occur exactly once in each column.
     * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
     * Empty cells are indicated by the character '.'.
     * <p>
     * <p>
     * A sudoku puzzle...
     * <p>
     * <p>
     * ...and its solution numbers marked in red.
     * <p>
     * Note:
     * <p>
     * The given board contain only digits 1-9 and the character '.'.
     * You may assume that the given Sudoku puzzle will have a single unique solution.
     * The given board size is always 9x9.
     *
     * @link https://leetcode.com/problems/sudoku-solver/
     */
    public void solveSudoku(char[][] board) {
        backTrack(board, 0, 0);
    }

    private boolean backTrack(char[][] board, int row, int col) {
        if (row == 9) {
            return true;
        }
        if (board[row][col] != '.') {
            return backTrack(board, row + (col + 1) / 9, (col + 1) % 9);
        } else {
            for (char num = '1'; num <= '9'; num++) {
                board[row][col] = num;
                if (isValid(board, row, col) && backTrack(board, row + (col + 1) / 9, (col + 1) % 9)) {
                    return true;
                }
                board[row][col] = '.';
            }
            return false;
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        for (int j = 0; j < 9; j++) {
            if (j != col && board[row][j] == board[row][col]) {
                // 同一行
                return false;
            }
            if (j != row && board[j][col] == board[row][col]) {
                // 同一列
                return false;
            }
            int boxRow = row / 3 * 3 + j / 3;
            int boxCol = col / 3 * 3 + j % 3;
            if (boxRow != row && boxCol != col && board[boxRow][boxCol] == board[row][col]) {
                // 所在九宫格
                return false;
            }
        }
        return true;
    }

    private boolean isValid0(char[][] board, int row, int col) {
        Map<Character, Boolean> rowDigits = new HashMap<>();
        Map<Character, Boolean> colDigits = new HashMap<>();
        Map<Character, Boolean> boxDigits = new HashMap<>();
        for (int j = 0; j < 9; j++) {
            if (board[row][j] != '.' && Boolean.TRUE.equals(rowDigits.get(board[row][j]))) {
                // 同一行
                return false;
            }
            if (board[j][col] != '.' && Boolean.TRUE.equals(colDigits.get(board[j][col]))) {
                // 同一列
                return false;
            }
            int boxRow = row / 3 * 3 + j / 3;
            int boxCol = col / 3 * 3 + j % 3;
            if (board[boxRow][boxCol] != '.' && Boolean.TRUE.equals(boxDigits.get(board[boxRow][boxCol]))) {
                // 所在九宫格
                return false;
            }
            rowDigits.put(board[row][j], Boolean.TRUE);
            colDigits.put(board[j][col], Boolean.TRUE);
            boxDigits.put(board[boxRow][boxCol], Boolean.TRUE);
        }
        return true;
    }

    private boolean isValid2(char[][] board, int x, int y) {
        int i, j;
        for (i = 0; i < 9; i++)
            if (i != x && board[i][y] == board[x][y])
                return false;
        for (j = 0; j < 9; j++)
            if (j != y && board[x][j] == board[x][y])
                return false;
        for (i = 3 * (x / 3); i < 3 * (x / 3 + 1); i++)
            for (j = 3 * (y / 3); j < 3 * (y / 3 + 1); j++)
                if (i != x && j != y && board[i][j] == board[x][y])
                    return false;
        return true;
    }


    public boolean solveSudoku2(char[][] board) {
        for (int i = 0; i < 9; ++i)
            for (int j = 0; j < 9; ++j) {
                if ('.' == board[i][j]) {
                    for (char k = '1'; k <= '9'; ++k) {
                        board[i][j] = k;
                        if (isValid2(board, i, j) && solveSudoku2(board))
                            return true;
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        return true;
    }

    public static void main(String[] args) {
        String[][] boards = new String[][]{
                {"5", "3", ".", ".", "7", ".", ".", ".", "."},
                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
                {".", "9", "8", ".", ".", ".", ".", "6", "."},
                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                {".", "6", ".", ".", ".", ".", "2", "8", "."},
                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                {".", ".", ".", ".", "8", ".", ".", "7", "9"}
        };
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = boards[i][j].charAt(0);
            }
        }
        PrintArrayUtil.print(board);
        new SudokuSolver().solveSudoku(board);
        System.out.println();
        PrintArrayUtil.print(board);
    }

}
