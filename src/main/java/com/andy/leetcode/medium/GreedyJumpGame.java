package com.andy.leetcode.medium;

/**
 * Created by andy on 2019/6/13.
 */
public class GreedyJumpGame {
    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.
     * <p>
     * Each element in the array represents your maximum jump length at that position.
     * <p>
     * Determine if you are able to reach the last index.
     * <p>
     * Example 1:
     * <p>
     * Input: [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * Example 2:
     * <p>
     * Input: [3,2,1,0,4]
     * Output: false
     * Explanation: You will always arrive at index 3 no matter what. Its maximum
     * jump length is 0, which makes it impossible to reach the last index.
     */
    public boolean canJump0(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int index = 0;
        while (index < nums.length - 1) {
            if (nums[index] == 0) {
                // 待超越的index
                int lastReached = index;
                while (index + nums[index] <= lastReached) {
                    index--;
                    if (index < 0) {
                        return false;
                    }
                }
            }
            index += nums[index];
        }
        return true;
    }

    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    public static void main(String[] args) {
        System.out.println(new GreedyJumpGame().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new GreedyJumpGame().canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(new GreedyJumpGame().canJump(new int[]{3, 0, 8, 2, 0, 0, 1}));
    }
}
