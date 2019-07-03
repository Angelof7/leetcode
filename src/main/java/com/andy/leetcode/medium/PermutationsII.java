package com.andy.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by andy on 2019/7/3.
 */
public class PermutationsII {
    /**
     * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
     * <p>
     * Example:
     * <p>
     * Input: [1,1,2]
     * Output:
     * [
     * [1,1,2],
     * [1,2,1],
     * [2,1,1]
     * ]
     *
     * @link https://leetcode.com/problems/permutations-ii/
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int[] selected = new int[nums.length];
        backTrack(result, nums, selected, new ArrayList<>());
        return result;
    }

    private void backTrack(List<List<Integer>> result, int[] nums, int[] selected, List<Integer> permutation) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (selected[i] == 1 || (i > 0 && nums[i] == nums[i - 1] && selected[i - 1] == 0)) {
                // 前后相同的数字，为保证唯一性，前面一个还没入选，当前一个就不能入选
                continue;
            }
            permutation.add(nums[i]);
            selected[i] = 1;
            backTrack(result, nums, selected, permutation);
            selected[i] = 0;
            permutation.remove(permutation.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new PermutationsII().permuteUnique(new int[]{1, 2, 1}));
    }
}
