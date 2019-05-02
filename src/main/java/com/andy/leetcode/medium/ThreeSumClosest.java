package com.andy.leetcode.medium;

import java.util.Arrays;

/**
 * Created by andy on 2019/5/2.
 */
public class ThreeSumClosest {
    /**
     * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
     * <p>
     * Example:
     * <p>
     * Given array nums = [-1, 2, 1, -4], and target = 1.
     * <p>
     * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     */

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("no target found");
        }

        // 1. 升序排序
        Arrays.sort(nums);
        int length = nums.length;

        int smallestDifference = Integer.MAX_VALUE;
        int result = nums[0] + nums[1] + nums[2];

        // 2. 固定一位数A，寻找另外两个和最接近差值（0-A）的数B、C
        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                // 重复数
                continue;
            }

            int targetSum = target - nums[i];
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                int difference = Math.abs(sum - targetSum);
                if (difference < smallestDifference) {
                    // 差值更小
                    smallestDifference = difference;
                    result = nums[i] + sum;
                }

                if (sum == targetSum) {
                    return target;
                } else if (sum < targetSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
//        int[] nums = new int[]{-1, 2, 1, -4};
        int[] nums = new int[]{1, 2, 4, 8, 16, 32, 64, 128};
        System.out.println(new ThreeSumClosest().threeSumClosest(nums, 82));
    }
}
