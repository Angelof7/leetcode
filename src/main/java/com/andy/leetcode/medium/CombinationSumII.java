package com.andy.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by andy on 2019/6/10.
 */
public class CombinationSumII {
    /**
     * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
     * <p>
     * Each number in candidates may only be used once in the combination.
     * <p>
     * Note:
     * <p>
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     * Example 1:
     * <p>
     * Input: candidates = [10,1,2,7,6,1,5], target = 8,
     * A solution set is:
     * [
     * [1, 7],
     * [1, 2, 5],
     * [2, 6],
     * [1, 1, 6]
     * ]
     * Example 2:
     * <p>
     * Input: candidates = [2,5,2,1,2], target = 5,
     * A solution set is:
     * [
     * [1,2,2],
     * [5]
     * ]
     *
     * @link https://leetcode.com/problems/combination-sum-ii/
     */
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void backTrack(int[] candidates, int target, int start, List<Integer> nums) {
        if (target == 0) {
            result.add(new ArrayList<>(nums));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return;
            }
            if (i > start && candidates[i] == candidates[i - 1]) {
                // 避免重复集合
                continue;
            }
            nums.add(candidates[i]);
            backTrack(candidates, target - candidates[i], i + 1, nums);
            nums.remove(nums.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumII().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(new CombinationSumII().combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }
}
