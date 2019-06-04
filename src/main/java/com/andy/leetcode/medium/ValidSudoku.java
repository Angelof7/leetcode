package com.andy.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by andy on 2019/6/4.
 */
public class ValidSudoku {
    /**
     * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
     * <p>
     * Each row must contain the digits 1-9 without repetition.
     * Each column must contain the digits 1-9 without repetition.
     * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     * <p>
     * A partially filled sudoku which is valid.
     * <p>
     * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
     * <p>
     * Example 1:
     * <p>
     * Input:
     * [
     * ["5","3",".",".","7",".",".",".","."],
     * ["6",".",".","1","9","5",".",".","."],
     * [".","9","8",".",".",".",".","6","."],
     * ["8",".",".",".","6",".",".",".","3"],
     * ["4",".",".","8",".","3",".",".","1"],
     * ["7",".",".",".","2",".",".",".","6"],
     * [".","6",".",".",".",".","2","8","."],
     * [".",".",".","4","1","9",".",".","5"],
     * [".",".",".",".","8",".",".","7","9"]
     * ]
     * Output: true
     * Example 2:
     * <p>
     * Input:
     * [
     * ["8","3",".",".","7",".",".",".","."],
     * ["6",".",".","1","9","5",".",".","."],
     * [".","9","8",".",".",".",".","6","."],
     * ["8",".",".",".","6",".",".",".","3"],
     * ["4",".",".","8",".","3",".",".","1"],
     * ["7",".",".",".","2",".",".",".","6"],
     * [".","6",".",".",".",".","2","8","."],
     * [".",".",".","4","1","9",".",".","5"],
     * [".",".",".",".","8",".",".","7","9"]
     * ]
     * Output: false
     * Explanation: Same as Example 1, except with the 5 in the top left corner being
     * modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
     * Note:
     * <p>
     * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
     * Only the filled cells need to be validated according to the mentioned rules.
     * The given board contain only digits 1-9 and the character '.'.
     * The given board size is always 9x9.
     */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> rowDigits = new HashSet<>();
            Set<Character> columnDigits = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && rowDigits.contains(board[i][j])) {
                    // 同一行
                    return false;
                }
                if (board[j][i] != '.' && columnDigits.contains(board[j][i])) {
                    // 同一列
                    return false;
                }
                rowDigits.add(board[i][j]);
                columnDigits.add(board[j][i]);
            }
        }

        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                Set<Character> boxDigits = new HashSet<>();
                for (int k = 0; k < 3; k++) {
                    for (int m = 0; m < 3; m++) {
                        // 九宫格
                        Character character = board[i + k][j + m];
                        if (!character.equals('.') && boxDigits.contains(character)) {
                            return false;
                        }
                        boxDigits.add(character);
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> rowDigits = new HashSet<>();
            Set<Character> columnDigits = new HashSet<>();
            Set<Character> subgridDigits = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && rowDigits.contains(board[i][j])) {
                    // 同一行
                    return false;
                }
                if (board[j][i] != '.' && columnDigits.contains(board[j][i])) {
                    // 同一列
                    return false;
                }
                Character character = board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3];
                if (!character.equals('.') && subgridDigits.contains(character)) {
                    // 九宫格
                    return false;
                }
                rowDigits.add(board[i][j]);
                columnDigits.add(board[j][i]);
                subgridDigits.add(character);
            }
        }

        return true;
    }

    public boolean isValidSudoku3(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Map<Character, Boolean> rowDigits = new HashMap<>();
            Map<Character, Boolean> columnDigits = new HashMap<>();
            Map<Character, Boolean> subgridDigits = new HashMap<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && Boolean.TRUE.equals(rowDigits.get(board[i][j]))) {
                    // 同一行
                    return false;
                }
                if (board[j][i] != '.' && Boolean.TRUE.equals(columnDigits.get(board[j][i]))) {
                    // 同一列
                    return false;
                }
                Character character = board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3];
                if (!character.equals('.') && Boolean.TRUE.equals(subgridDigits.get(character))) {
                    // 九宫格
                    return false;
                }
                rowDigits.put(board[i][j], true);
                columnDigits.put(board[j][i], true);
                subgridDigits.put(character, true);
            }
        }

        return true;
    }
}
