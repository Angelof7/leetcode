package com.andy.leetcode.medium;

/**
 * Created by andy on 2019/7/19.
 */
public class SearchInRotatedSortedArrayII {
    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     * <p>
     * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
     * <p>
     * You are given a target value to search. If found in the array return true, otherwise return false.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [2,5,6,0,0,1,2], target = 0
     * Output: true
     * Example 2:
     * <p>
     * Input: nums = [2,5,6,0,0,1,2], target = 3
     * Output: false
     * Follow up:
     * <p>
     * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
     * Would this affect the run-time complexity? How and why?
     *
     * @link https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
     */
    public boolean search(int[] nums, int target) {
        if (nums == null) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < nums[right]) {
                // mid is in the right sorted array part
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > nums[right]) {
                // mid is in the left sorted array part
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                2, 5, 6, 0, 0, 1, 2
        };
        int target = 0;
        System.out.println(new SearchInRotatedSortedArrayII().search(nums, target));

        target = 3;
        System.out.println(new SearchInRotatedSortedArrayII().search(nums, target));
    }

}
