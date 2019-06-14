package com.andy.leetcode.medium;

import com.andy.leetcode.common.PrintArrayUtil;

import java.util.Arrays;

/**
 * Created by andy on 2019/6/14.
 */
public class MergeIntervals {
    /**
     * Given a collection of intervals, merge all overlapping intervals.
     * <p>
     * Example 1:
     * <p>
     * Input: [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
     * Example 2:
     * <p>
     * Input: [[1,4],[4,5]]
     * Output: [[1,5]]
     * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
     *
     * @link https://leetcode.com/problems/merge-intervals/
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        sort(intervals, 0, intervals.length - 1);
        // 没有使用归并排序 效率低
//        Arrays.parallelSort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int k = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[k][0] && intervals[i][0] <= intervals[k][1]) {
                //overlap
                intervals[k][1] = Math.max(intervals[k][1], intervals[i][1]);
            } else {
                k++;
                intervals[k] = intervals[i];
            }
        }
        return Arrays.copyOf(intervals, k + 1);
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    private void sort(int[][] arr) {
        boolean flag = true;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j][0] > arr[j + 1][0]) {
                    int[] tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    /**
     * 归并排序
     *
     * @param nums
     * @param low
     * @param high
     */
    private void sort(int[][] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            sort(nums, low, mid);
            // 右边
            sort(nums, mid + 1, high);
            // 左右归并
            merge(nums, low, mid, high);
        }
    }

    private void merge(int[][] nums, int low, int mid, int high) {
        int[][] temp = new int[high - low + 1][];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;

        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (nums[i][0] < nums[j][0]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = nums[j++];
        }

        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[k2 + low] = temp[k2];
        }
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        PrintArrayUtil.print(new MergeIntervals().merge(intervals));
        intervals = new int[][]{
                {1, 4},
                {4, 5}
        };
        PrintArrayUtil.print(new MergeIntervals().merge(intervals));
        intervals = new int[][]{
                {1, 4},
                {0, 3}
        };
        PrintArrayUtil.print(new MergeIntervals().merge(intervals));
    }

}
