package com.andy.leetcode.medium;

import com.andy.leetcode.common.PrintArrayUtil;

/**
 * Created by andy on 2019/6/30.
 */
public class NextPermutation {
    /**
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
     * <p>
     * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
     * <p>
     * The replacement must be in-place and use only constant extra memory.
     * <p>
     * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
     * <p>
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     *
     * @link https://leetcode.com/problems/next-permutation/
     */
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return;
        }
        int i;
        for (i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        if (i >= 0) {
            // find next greater permutation of numbers
            int j = len - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, len - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 5, 1
        };
        new NextPermutation().nextPermutation(nums);
        PrintArrayUtil.print(nums);
    }
}
