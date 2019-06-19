package com.andy.leetcode.medium;

/**
 * Created by andy on 2019/6/19.
 */
public class UniquePaths {
    /**
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     * <p>
     * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     * <p>
     * How many possible unique paths are there?
     * <p>
     * <p>
     * Above is a 7 x 3 grid. How many possible unique paths are there?
     * <p>
     * Note: m and n will be at most 100.
     * <p>
     * Example 1:
     * <p>
     * Input: m = 3, n = 2
     * Output: 3
     * Explanation:
     * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
     * 1. Right -> Right -> Down
     * 2. Right -> Down -> Right
     * 3. Down -> Right -> Right
     * Example 2:
     * <p>
     * Input: m = 7, n = 3
     * Output: 28
     *
     * @link https://leetcode.com/problems/unique-paths/
     */
    private int count = 0;

    /**
     * 1.About Complexity
     *     1.1 Time Complexity is O(n^2)
     *     1.2 Space Complexity is O(n^2)
     * 2.how I solve
     *     2.1 this solution is base on dynamic planning
     *     2.2 by analyzing,this topic has two condition
     *          2.1.1 when i=0 or j=0,temp=1,because it only haa one route to reach
     *          2.1.2 cause the topic limit robot's walk way,so temp=temp[i-1][j](from the top)+temp[i][j-1](from the left)
     *     2.3 use double circulate with i and j, calculate temp
     *     2.4 return temp[m-1][n-1](the last element in m and n)
     * 3.About submit record
     *     3.1 1ms and 32.4MB memory in LeetCode China
     *     3.2 0ms and 31.8MB memory in LeetCode
     */
    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 1;
                } else {
                    // top + left
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                }
            }
        }
        return arr[m - 1][n - 1];
    }


    public int uniquePaths0(int m, int n) {
        backTrack(0, 0, n - 1, m - 1);
        return count;
    }

    // Time Limit Exceeded
    private void backTrack(int row, int col, int rowIndex, int colIndex) {
        if (row == rowIndex && col == colIndex) {
            count++;
            return;
        }
        if (col < colIndex) {
            backTrack(row, col + 1, rowIndex, colIndex);
        }
        if (row < rowIndex) {
            backTrack(row + 1, col, rowIndex, colIndex);
        }
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(3, 2));
        System.out.println(new UniquePaths().uniquePaths(7, 3));
    }
}
