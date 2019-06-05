package com.andy.leetcode.hard;

/**
 * Created by andy on 2019/6/5.
 */
public class LongestValidParentheses {
    /**
     * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
     * <p>
     * Example 1:
     * <p>
     * Input: "(()"
     * Output: 2
     * Explanation: The longest valid parentheses substring is "()"
     * Example 2:
     * <p>
     * Input: ")()())"
     * Output: 4
     * Explanation: The longest valid parentheses substring is "()()"
     *
     * @link https://leetcode.com/problems/longest-valid-parentheses/
     */
//    public int longestValidParentheses(String s) {
//        if (s == null || s.length() <= 1) {
//            return 0;
//        }
//        int open = 0;
//        int close = 0;
//        int start = 0;
//        int max = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == '(') {
//                open++;
//            } else {
//                close++;
//            }
//            if (close > open) {
//                start = i + 1;
//                open = close = 0;
//            } else if (close == open) {
//                max = Math.max(i - start + 1, max);
//            }
//
//            if (i + 1 == s.length()) {
//                i = start;
//                start = start + 1;
//                open = close = 0;
//            }
//        }
//        return max;
//    }
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int max = 0;
        int open = 0;
        int close = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
            } else {
                close++;
            }
            if (close > open) {
                open = close = 0;
            } else if (close == open) {
                max = Math.max(open * 2, max);
            }
        }
        open = close = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
            } else {
                close++;
            }
            if (open > close) {
                open = close = 0;
            } else if (close == open) {
                max = Math.max(open * 2, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses("(()"));
        System.out.println(new LongestValidParentheses().longestValidParentheses(")()())"));
        System.out.println(new LongestValidParentheses().longestValidParentheses("()(()"));
    }
}
