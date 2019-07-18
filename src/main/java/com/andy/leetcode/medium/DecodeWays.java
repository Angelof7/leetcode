package com.andy.leetcode.medium;

/**
 * Created by andy on 2019/7/18.
 */
public class DecodeWays {
    /**
     * A message containing letters from A-Z is being encoded to numbers using the following mapping:
     * <p>
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * Given a non-empty string containing only digits, determine the total number of ways to decode it.
     * <p>
     * Example 1:
     * <p>
     * Input: "12"
     * Output: 2
     * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
     * Example 2:
     * <p>
     * Input: "226"
     * Output: 3
     * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
     *
     * @link https://leetcode.com/problems/decode-ways/
     */


    public int numDecodings(String s) {
        char[] c = s.toCharArray();
        return dfs(c, 0);
    }

    private int dfs(char[] c, int index) {
        if (index == c.length) {
            return 1;
        }
        if (c[index] == '0') {
            return 0;
        }
        if (c.length > (index + 1)) {
            int num = (c[index] - '0') * 10 + (c[index + 1] - '0');
            if (num < 27) {
                return dfs(c, index + 1) + dfs(c, index + 2);
            }
        }
        return dfs(c, index + 1);

    }

    public int numDecodings0(String s) {
        char[] c = s.toCharArray();
        if (c.length == 0 || c[0] == '0') {
            return 0;
        }
        int first = 1, second = 1;
        for (int i = 2; i <= c.length; i++) {
            int val = (c[i - 2] - '0') * 10 + (c[i - 1] - '0');
            int tmp = second;
            if (val % 10 == 0) {
                second = 0;
            }
            if (val >= 10 && val <= 26) {
                second += first;
            }
            first = tmp;
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("10"));
        System.out.println(new DecodeWays().numDecodings("00"));
        System.out.println(new DecodeWays().numDecodings("12"));
        System.out.println(new DecodeWays().numDecodings("226"));
    }
}
