package com.andy.leetcode.easy;

/**
 * Created by andy on 2019/6/23.
 */
public class AddBinary {
    /**
     * Given two binary strings, return their sum (also a binary string).
     * <p>
     * The input strings are both non-empty and contains only characters 1 or 0.
     * <p>
     * Example 1:
     * <p>
     * Input: a = "11", b = "1"
     * Output: "100"
     * Example 2:
     * <p>
     * Input: a = "1010", b = "1011"
     * Output: "10101"
     *
     * @link https://leetcode.com/problems/add-binary/
     */
    public String addBinary0(String a, String b) {
        StringBuilder result = new StringBuilder();
        int aLen = a.length();
        int bLen = b.length();
        int extra = 0;
        while (aLen > 0 && bLen > 0) {
            int num1 = a.charAt(aLen - 1) - '0';
            int num2 = b.charAt(bLen - 1) - '0';
            int sum = (num1 + num2 + extra) % 2;
            extra = (num1 + num2 + extra) / 2;
            result.append(sum);
            aLen--;
            bLen--;
        }

        int lastLen = 0;
        String lastStr = null;
        if (aLen > 0) {
            lastLen = aLen;
            lastStr = a;
        }
        if (bLen > 0) {
            lastLen = bLen;
            lastStr = b;
        }
        if (lastStr != null) {
            while (lastLen > 0) {
                int num1 = lastStr.charAt(lastLen - 1) - '0';
                int sum = (num1 + extra) % 2;
                extra = (num1 + extra) / 2;
                result.append(sum);
                lastLen--;
            }
        }
        if (extra > 0) {
            result.append("1");
        }

        return result.reverse().toString();
    }

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int sum = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            result.append(sum % 2);
            sum /= 2;
        }
        if (sum != 0) {
            result.append(sum);
        }
        return result.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("11", "1"));
        System.out.println(new AddBinary().addBinary("1010", "1011"));
    }
}
