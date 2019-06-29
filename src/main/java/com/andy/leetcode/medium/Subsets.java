package com.andy.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy on 2019/6/29.
 */
public class Subsets {
    /**
     * Given a set of distinct integers, nums, return all possible subsets (the power set).
     * <p>
     * Note: The solution set must not contain duplicate subsets.
     * <p>
     * Example:
     * <p>
     * Input: nums = [1,2,3]
     * Output:
     * [
     * [3],
     * [1],
     * [2],
     * [1,2,3],
     * [1,3],
     * [2,3],
     * [1,2],
     * []
     * ]
     *
     * @link https://leetcode.com/problems/subsets/
     */

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backTrack(nums, 0, new ArrayList<>());
        return result;
    }

    private void backTrack(int[] nums, int idx, List<Integer> set) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(set));
            return;
        }
        set.add(nums[idx]);
        backTrack(nums, idx + 1, set);
        set.remove(set.size() - 1);
        backTrack(nums, idx + 1, set);
    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1, 2, 3}));
    }
}
