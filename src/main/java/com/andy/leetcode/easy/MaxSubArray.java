package com.andy.leetcode.easy;

/**
 * Created by andy on 2019/5/27.
 */
public class MaxSubArray {
    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
     * <p>
     * Example:
     * <p>
     * Input: [-2,1,-3,4,-1,2,1,-5,4],
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     * Follow up:
     * <p>
     * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
     */
    public int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int curSum = 0;
        for (int num : nums) {
            curSum = Math.max(curSum + num, num);
            res = Math.max(curSum, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                -2, 1, -3, 4, -1, 2, 1, -5, 4
        };
        System.out.println(new MaxSubArray().maxSubArray(nums));
    }
}
