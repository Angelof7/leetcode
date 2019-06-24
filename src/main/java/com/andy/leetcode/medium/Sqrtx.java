package com.andy.leetcode.medium;

/**
 * Author   : andy.gao
 * Date     : 2019-06-24
 * Project  : leetcode
 */
public class Sqrtx {
    /**
     * Implement int sqrt(int x).
     * <p>
     * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
     * <p>
     * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
     * <p>
     * Example 1:
     * <p>
     * Input: 4
     * Output: 2
     * Example 2:
     * <p>
     * Input: 8
     * Output: 2
     * Explanation: The square root of 8 is 2.82842..., and since
     * the decimal part is truncated, 2 is returned.
     *
     * @link https://leetcode.com/problems/sqrtx/
     */
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 0;
        int right = x;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x / mid >= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Sqrtx().mySqrt(4));
        System.out.println(new Sqrtx().mySqrt(8));
        System.out.println(new Sqrtx().mySqrt(9));
        System.out.println(new Sqrtx().mySqrt(16));
    }
}
