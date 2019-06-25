package com.andy.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy on 2019/6/25.
 */
public class Combinations {
    /**
     * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
     * <p>
     * Example:
     * <p>
     * Input: n = 4, k = 2
     * Output:
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     *
     * @link https://leetcode.com/problems/combinations/
     */
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTrack(n, k, new ArrayList<>());
        return result;
    }

    private void backTrack(int n, int k, List<Integer> combination) {
        if (k > n) {
            return;
        }
        if (k == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        combination.add(n);
        backTrack(n - 1, k - 1, combination);
        combination.remove(combination.size() - 1);
        backTrack(n - 1, k, combination);
    }

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4, 2));
    }
}
