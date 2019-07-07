package com.andy.leetcode.easy;

import com.andy.leetcode.common.PrintArrayUtil;

/**
 * Created by andy on 2019/7/7.
 */
public class MergeSortedArray {
    /**
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     * <p>
     * Note:
     * <p>
     * The number of elements initialized in nums1 and nums2 are m and n respectively.
     * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
     * Example:
     * <p>
     * Input:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * <p>
     * Output: [1,2,2,3,5,6]
     *
     * @link https://leetcode.com/problems/merge-sorted-array/
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int lastIndex = m + n - 1;
        while (m > 0 && n > 0) {
            if (nums1[m - 1] >= nums2[n - 1]) {
                nums1[lastIndex--] = nums1[--m];
            } else {
                nums1[lastIndex--] = nums2[--n];
            }
        }
        if (n > 0) {
            while (lastIndex >= 0) {
                nums1[lastIndex--] = nums2[--n];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{
                1, 2, 3, 0, 0, 0
        };
        int[] nums2 = new int[]{
                2, 5, 6
        };
        new MergeSortedArray().merge(nums1, 3, nums2, 1);
        PrintArrayUtil.print(nums1);
    }
}
