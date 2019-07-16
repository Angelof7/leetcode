package com.andy.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by andy on 2019/7/16.
 */
public class SubsetsII {
    /**
     * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
     * <p>
     * Note: The solution set must not contain duplicate subsets.
     * <p>
     * Example:
     * <p>
     * Input: [1,2,2]
     * Output:
     * [
     * [2],
     * [1],
     * [1,2,2],
     * [2,2],
     * [1,2],
     * []
     * ]
     *
     * @link https://leetcode.com/problems/subsets-ii/
     */
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
//        backTrack0(nums, 0, new ArrayList<>());
        backTrack(nums, 0, false, new ArrayList<>());
        return result;
    }

    private void backTrack0(int[] nums, int start, List<Integer> set) {
        result.add(new ArrayList<>(set));
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }
            set.add(nums[i]);
            backTrack0(nums, i + 1, set);
            set.remove(set.size() - 1);
        }
    }

    private void backTrack(int[] nums, int idx, boolean lastChoosen, List<Integer> set) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(set));
            return;
        }
        if (idx > 0 && !lastChoosen && nums[idx - 1] == nums[idx]) {
            backTrack(nums, idx + 1, false, set);
        } else {
            set.add(nums[idx]);
            backTrack(nums, idx + 1, true, set);
            set.remove(set.size() - 1);
            backTrack(nums, idx + 1, false, set);
        }
    }

    public static void main(String[] args) {
//        System.out.println(new SubsetsII().subsetsWithDup(new int[]{1, 2, 3}));
//        System.out.println(new SubsetsII().subsetsWithDup(new int[]{1, 2, 2}));
//        System.out.println(new SubsetsII().subsetsWithDup(new int[]{1, 1, 2, 2}));
        System.out.println(new SubsetsII().subsetsWithDup(new int[]{5, 5, 5, 5, 5}));
    }

}
