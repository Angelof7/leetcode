package com.andy.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by andy on 2019/6/7.
 */
public class CombinationSum {
    /**
     * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
     * <p>
     * The same repeated number may be chosen from candidates unlimited number of times.
     * <p>
     * Note:
     * <p>
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     * Example 1:
     * <p>
     * Input: candidates = [2,3,6,7], target = 7,
     * A solution set is:
     * [
     * [7],
     * [2,2,3]
     * ]
     * Example 2:
     * <p>
     * Input: candidates = [2,3,5], target = 8,
     * A solution set is:
     * [
     * [2,2,2,2],
     * [2,3,3],
     * [3,5]
     * ]
     */
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        // 升序排序，提高递归效率
        Arrays.sort(candidates);
        backTrace(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void backTrace(int[] candidates, int target, int start, List<Integer> nums) {
        if (target == 0) {
            result.add(new ArrayList<>(nums));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                // 若此数大于target，后续的不必查了
                return;
            }
            nums.add(candidates[i]);
            backTrace(candidates, target - candidates[i], i, nums);
            nums.remove(nums.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 5}, 8));
    }

}
