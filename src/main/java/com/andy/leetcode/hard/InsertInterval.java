package com.andy.leetcode.hard;

import com.andy.leetcode.common.PrintArrayUtil;

import java.util.Arrays;

/**
 * Created by andy on 2019/6/15.
 */
public class InsertInterval {
    /**
     * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
     * <p>
     * You may assume that the intervals were initially sorted according to their start times.
     * <p>
     * Example 1:
     * <p>
     * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
     * Output: [[1,5],[6,9]]
     * Example 2:
     * <p>
     * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     * Output: [[1,2],[3,10],[12,16]]
     * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
     * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
     *
     * @link https://leetcode.com/problems/insert-interval/
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int[][] result = new int[intervals.length + 1][];
        // merge
        int index = 0;
        boolean inserted = false;
        for (int i = 0; i < result.length; i++) {
            if (inserted) {
                result[i] = intervals[index++];
            } else if (index >= intervals.length || newInterval[0] < intervals[index][0]) {
                result[i] = newInterval;
                inserted = true;
            } else {
                result[i] = intervals[index++];
            }
        }

        int k = 0;
        for (int i = 1; i < result.length; i++) {
            if (result[i][0] <= result[k][1]) {
                // overlap
                result[k][1] = Math.max(result[i][1], result[k][1]);
            } else {
                result[++k] = result[i];
            }
        }
        return Arrays.copyOf(result, k + 1);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 3},
                {6, 9}
        };
        int[] newIntervals = {2, 5};
        PrintArrayUtil.print(new InsertInterval().insert(intervals, newIntervals));

        intervals = new int[][]{
                {1, 2},
                {3, 5},
                {6, 7},
                {8, 10},
                {12, 16}
        };
        newIntervals = new int[]{4, 8};
        PrintArrayUtil.print(new InsertInterval().insert(intervals, newIntervals));

        intervals = new int[][]{

        };
        newIntervals = new int[]{6, 8};
        PrintArrayUtil.print(new InsertInterval().insert(intervals, newIntervals));
    }

}
