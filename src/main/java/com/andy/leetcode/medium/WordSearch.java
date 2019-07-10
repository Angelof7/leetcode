package com.andy.leetcode.medium;

/**
 * Created by andy on 2019/7/10.
 */
public class WordSearch {
    /**
     * Given a 2D board and a word, find if the word exists in the grid.
     * <p>
     * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
     * <p>
     * Example:
     * <p>
     * board =
     * [
     * ['A','B','C','E'],
     * ['S','F','C','S'],
     * ['A','D','E','E']
     * ]
     * <p>
     * Given word = "ABCCED", return true.
     * Given word = "SEE", return true.
     * Given word = "ABCB", return false.
     *
     * @link https://leetcode.com/problems/word-search/
     */
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(i, j, 0, board, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean helper(int i, int j, int index, char[][] board, String word) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        char tmp = board[i][j];
        board[i][j] = '#';
        boolean res = helper(i, j + 1, index + 1, board, word)
                || helper(i + 1, j, index + 1, board, word)
                || helper(i, j - 1, index + 1, board, word)
                || helper(i - 1, j, index + 1, board, word);
        board[i][j] = tmp;
        return res;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {
                        'A', 'B', 'C', 'E'
                },
                {
                        'S', 'F', 'C', 'S'
                },
                {
                        'A', 'D', 'E', 'E'
                }
        };
        System.out.println(new WordSearch().exist(board, "ABCCED"));
        System.out.println(new WordSearch().exist(board, "SEE"));
        System.out.println(new WordSearch().exist(board, "ABCB"));
    }
}
