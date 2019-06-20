package com.andy.leetcode.medium;

/**
 * Author   : andy.gao
 * Date     : 2019-06-20
 * Project  : leetcode
 */
public class UniquePathsII {
    /**
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     * <p>
     * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     * <p>
     * Now consider if some obstacles are added to the grids. How many unique paths would there be?
     * <p>
     * <p>
     * <p>
     * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
     * <p>
     * Note: m and n will be at most 100.
     * <p>
     * Example 1:
     * <p>
     * Input:
     * [
     * [0,0,0],
     * [0,1,0],
     * [0,0,0]
     * ]
     * Output: 2
     * Explanation:
     * There is one obstacle in the middle of the 3x3 grid above.
     * There are two ways to reach the bottom-right corner:
     * 1. Right -> Right -> Down -> Down
     * 2. Down -> Down -> Right -> Right
     *
     * @link https://leetcode.com/problems/unique-paths-ii/
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (obstacleGrid[i][j] == 1) {
                    // it is an obstacle
                    obstacleGrid[i][j] = 0;
                } else if (i == 0 || j == 0) {
                    // side way
                    if (i == 0 && j == 0) {
                        obstacleGrid[i][j] = 1;
                    } else if (i == 0) {
                        obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                    } else {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                    }
                } else {
                    // equals its top & left
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        return obstacleGrid[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] grids = new int[][]{
                {0, 0, 0}, {0, 1, 0}, {0, 0, 0}
        };
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(grids));
    }

}
