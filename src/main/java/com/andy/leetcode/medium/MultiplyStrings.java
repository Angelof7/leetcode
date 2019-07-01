package com.andy.leetcode.medium;

/**
 * Created by andy on 2019/7/1.
 */
public class MultiplyStrings {
    /**
     * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
     * <p>
     * Example 1:
     * <p>
     * Input: num1 = "2", num2 = "3"
     * Output: "6"
     * Example 2:
     * <p>
     * Input: num1 = "123", num2 = "456"
     * Output: "56088"
     * Note:
     * <p>
     * The length of both num1 and num2 is < 110.
     * Both num1 and num2 contain only digits 0-9.
     * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
     * You must not use any built-in BigInteger library or convert the inputs to integer directly.
     *
     * @link https://leetcode.com/problems/multiply-strings/
     */
    public String multiply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int m = num1.length();
        int n = num2.length();

        int[] result = new int[m + n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        int extra = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + n; i++) {
            int sum = (result[i] + extra) % 10;
            extra = (result[i] + extra) / 10;
            sb.append((char) ('0' + sum));
        }

        sb = sb.reverse();

        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("21", "61"));
    }
}
