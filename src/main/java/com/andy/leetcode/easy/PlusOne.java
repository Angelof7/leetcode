package com.andy.leetcode.easy;

import com.andy.leetcode.common.PrintArrayUtil;

/**
 * Created by andy on 2019/6/22.
 */
public class PlusOne {
    /**
     * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
     * <p>
     * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
     * <p>
     * You may assume the integer does not contain any leading zero, except the number 0 itself.
     * <p>
     * Example 1:
     * <p>
     * Input: [1,2,3]
     * Output: [1,2,4]
     * Explanation: The array represents the integer 123.
     * Example 2:
     * <p>
     * Input: [4,3,2,1]
     * Output: [4,3,2,2]
     * Explanation: The array represents the integer 4321.
     *
     * @link https://leetcode.com/problems/plus-one/
     */
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int extra = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (extra == 0) {
                break;
            }
            int temp = digits[i];
            digits[i] = (temp + extra) % 10;
            extra = (temp + extra) / 10;
        }
        if (extra > 0) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {4, 3, 2, 1};
        PrintArrayUtil.print(new PlusOne().plusOne(digits));
        digits = new int[]{9, 9, 9, 9};
        PrintArrayUtil.print(new PlusOne().plusOne(digits));
    }


}
