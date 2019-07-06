package com.andy.leetcode.medium;

/**
 * Created by andy on 2019/7/6.
 */
public class PowerXN {
    /**
     * Implement pow(x, n), which calculates x raised to the power n (xn).
     * <p>
     * Example 1:
     * <p>
     * Input: 2.00000, 10
     * Output: 1024.00000
     * Example 2:
     * <p>
     * Input: 2.10000, 3
     * Output: 9.26100
     * Example 3:
     * <p>
     * Input: 2.00000, -2
     * Output: 0.25000
     * Explanation: 2-2 = 1/22 = 1/4 = 0.25
     * Note:
     * <p>
     * -100.0 < x < 100.0
     * n is a 32-bit signed integer, within the range [−231, 231 − 1]
     *
     * @link https://leetcode.com/problems/powx-n/
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }

        if (n % 2 == 0) {
            // n is even
            double powXmid = myPow(x, n / 2);
            return powXmid * powXmid;
        } else {
            // n is odd
            double powXmid = myPow(x, n / 2);
            return powXmid * powXmid * myPow(x, n % 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(new PowerXN().myPow(2.1d, 3));
    }
}