package com.andy.leetcode.medium;

import com.andy.leetcode.common.PrintArrayUtil;

/**
 * Created by andy on 2019/7/9.
 */
public class SortColors {
    /**
     * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
     * <p>
     * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
     * <p>
     * Note: You are not suppose to use the library's sort function for this problem.
     * <p>
     * Example:
     * <p>
     * Input: [2,0,2,1,1,0]
     * Output: [0,0,1,1,2,2]
     * Follow up:
     * <p>
     * A rather straight forward solution is a two-pass algorithm using counting sort.
     * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
     * Could you come up with a one-pass algorithm using only constant space?
     *
     * @link https://leetcode.com/problems/sort-colors/
     */
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i <= right; i++) {
            if (nums[i] == 0) {
                // swap 0 to front
                swap(nums, left++, i);
            } else if (nums[i] == 2) {
                // swap 2 to back
                swap(nums, right--, i--);
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                2, 1, 0
        };
        new SortColors().sortColors(nums);
        PrintArrayUtil.print(nums);
    }
}
