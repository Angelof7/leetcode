package com.andy.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy on 2019/7/2.
 */
public class Permutations {
    /**
     * Given a collection of distinct integers, return all possible permutations.
     * <p>
     * Example:
     * <p>
     * Input: [1,2,3]
     * Output:
     * [
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]
     * ]
     *
     * @link https://leetcode.com/problems/permutations/
     */
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int[] selected = new int[nums.length];
        backTrack(nums, selected, new ArrayList<>());
        return result;
    }

    private void backTrack(int[] nums, int[] selected, List<Integer> permutations) {
        if (permutations.size() == nums.length) {
            result.add(new ArrayList<>(permutations));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (selected[i] == 0) {
                // select
                permutations.add(nums[i]);
                selected[i] = 1;
                backTrack(nums, selected, permutations);
                // not select
                permutations.remove(permutations.size() - 1);
                selected[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 2, 3
        };
        System.out.println(new Permutations().permute(nums));

    }
}
