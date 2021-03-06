package com.andy.leetcode.medium;

import com.andy.leetcode.common.PrintArrayUtil;

/**
 * Author   : andy.gao
 * Date     : 2019-07-11
 * Project  : leetcode
 */
public class RemoveDuplicatesFromSortedArrayII {
    /**
     * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
     * <p>
     * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
     * <p>
     * Example 1:
     * <p>
     * Given nums = [1,1,1,2,2,3],
     * <p>
     * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
     * <p>
     * It doesn't matter what you leave beyond the returned length.
     * Example 2:
     * <p>
     * Given nums = [0,0,1,1,1,1,2,3,3],
     * <p>
     * Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
     * <p>
     * It doesn't matter what values are set beyond the returned length.
     * Clarification:
     * <p>
     * Confused why the returned value is an integer but your answer is an array?
     * <p>
     * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
     * <p>
     * Internally you can think of this:
     * <p>
     * // nums is passed in by reference. (i.e., without making a copy)
     * int len = removeDuplicates(nums);
     * <p>
     * // any modification to nums in your function would be known by the caller.
     * // using the length returned by your function, it prints the first len elements.
     * for (int i = 0; i < len; i++) {
     * print(nums[i]);
     * }
     *
     * @link https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }

        int temp = nums[0] - 1;

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i + 2] == nums[i + 1] && nums[i] == nums[i + 1])
                nums[i] = temp;
        }

        int pre = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != temp) {
                nums[pre++] = nums[i];
            }

        return pre;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                0, 0, 1, 1, 1, 1, 2, 3, 3
        };
        new RemoveDuplicatesFromSortedArrayII().removeDuplicates(nums);
        PrintArrayUtil.print(nums);
    }
}
