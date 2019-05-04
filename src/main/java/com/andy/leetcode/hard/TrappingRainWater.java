package com.andy.leetcode.hard;

/**
 * Created by andy on 2019/5/4.
 */
public class TrappingRainWater {
    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
     * <p>
     * <p>
     * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
     * <p>
     * Example:
     * <p>
     * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     *
     * @https://leetcode.com/problems/trapping-rain-water/
     */
    public int trap(int[] height) {

        if (height == null || height.length < 3) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int water = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    water += left_max - height[left];
                }
                ++left;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    water += right_max - height[right];
                }
                --right;
            }
        }
        return water;

    }

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new TrappingRainWater().trap(height));
        height = new int[]{2, 0, 2};
        System.out.println(new TrappingRainWater().trap(height));
    }


}
