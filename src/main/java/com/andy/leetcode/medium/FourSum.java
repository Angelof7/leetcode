package com.andy.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by andy on 2019/5/11.
 */
public class FourSum {
    /**
     * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
     * <p>
     * Note:
     * <p>
     * The solution set must not contain duplicate quadruplets.
     * <p>
     * Example:
     * <p>
     * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
     * <p>
     * A solution set is:
     * [
     * [-1,  0, 0, 1],
     * [-2, -1, 1, 2],
     * [-2,  0, 0, 2]
     * ]
     *
     * @seehttps://leetcode.com/problems/4sum/
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        // 升序排序
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 4; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 第一个数重复，那找到的4元组肯定与之前的有重复
                continue;
            }
            int threeSum = target - nums[i];

            for (int j = i + 1; j <= nums.length - 3; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    // 三元组的第一个数重复，那找到的3元组肯定是重复的
                    continue;
                }
                int twoSum = threeSum - nums[j];

                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == twoSum) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left + 1 < right && nums[left] == nums[left + 1]) {
                            // 过掉重复的left
                            left++;
                        }
                        while (right - 1 > left && nums[right] == nums[right - 1]) {
                            // 过掉重复的right
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < twoSum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int nums[] = new int[]{
                1, 0, -1, 0, -2, 2
        };
        System.out.println(new FourSum().fourSum(nums, 0));
    }
}
