package com.andy.leetcode.medium;

/**
 * Created by andy on 2019/6/3.
 */
public class Divide2Integers {
    /**
     * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
     * <p>
     * Return the quotient after dividing dividend by divisor.
     * <p>
     * The integer division should truncate toward zero.
     * <p>
     * Example 1:
     * <p>
     * Input: dividend = 10, divisor = 3
     * Output: 3
     * Example 2:
     * <p>
     * Input: dividend = 7, divisor = -3
     * Output: -2
     * Note:
     * <p>
     * Both dividend and divisor will be 32-bit signed integers.
     * The divisor will never be 0.
     * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
     */
    public int divide(int dividend, int divisor) {
//        boolean differ = false;
//        if (dividend < 0 && divisor > 0
//                || dividend > 0 && divisor < 0) {
//            differ = true;
//        }
//        long longDividend = Math.abs((long) dividend);
//        long longDivisor = Math.abs((long) divisor);
//        long count = 0;
//        if (longDivisor == 1) {
//            count = longDividend;
//        }else {
//            while (longDividend > 0) {
//                count++;
//                longDividend -= longDivisor;
//            }
//            if (longDividend < 0) {
//                count--;
//            }
//        }
//        count = differ ? 0 - count : count;
//        return count > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) count;

        if (divisor == 1) {
            return dividend;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1 || divisor == 0) {
            return Integer.MAX_VALUE;
        }
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        int result = 0;
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        while (dvd >= dvs) {
            long sub = dvs;
            int subR = 1;
            while (dvd >= (sub << 1)) {
                sub <<= 1;
                subR <<= 1;
            }
            dvd -= sub;
            result += subR;
        }
        return sign * result;
    }

    public static void main(String[] args) {
        System.out.println(new Divide2Integers().divide(10, 3));
        System.out.println(new Divide2Integers().divide(7, -3));
        System.out.println(new Divide2Integers().divide(-2147483648, -1));
    }
}
