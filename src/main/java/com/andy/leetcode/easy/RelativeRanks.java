package com.andy.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by andy on 2019/5/17.
 */
public class RelativeRanks {
    /**
     * Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
     * <p>
     * Example 1:
     * Input: [5, 4, 3, 2, 1]
     * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
     * Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
     * For the left two athletes, you just need to output their relative ranks according to their scores.
     * Note:
     * N is a positive integer and won't exceed 10,000.
     * All the scores of athletes are guaranteed to be unique.
     *
     * @seehttps://leetcode.com/problems/relative-ranks/
     */
    public String[] findRelativeRanks(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new String[]{};
        }
        // copy一个做排序
        int[] copyNums = nums.clone();
        Arrays.sort(copyNums);
        // 用map记录每个元素的降序下标
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < copyNums.length; i++) {
            indexMap.put(copyNums[i], copyNums.length - i);
        }
        // 按原数组顺序召回元素的降序顺序
        String[] result = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int index = indexMap.get(nums[i]);
            switch (index) {
                case 1:
                    result[i] = "Gold Medal";
                    break;
                case 2:
                    result[i] = "Silver Medal";
                    break;
                case 3:
                    result[i] = "Bronze Medal";
                    break;
                default:
                    result[i] = String.valueOf(index);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                5, 4, 3, 2, 1
        };
        String[] values = new RelativeRanks().findRelativeRanks(nums);
        for (String value : values) {

            System.out.println(value);
        }
    }
}
