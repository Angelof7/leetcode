package com.andy.leetcode.easy;

/**
 * Created by andy on 2019/5/9.
 */
public class ImplementStrStr {
    /**
     * Implement strStr().
     * <p>
     * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     * <p>
     * Example 1:
     * <p>
     * Input: haystack = "hello", needle = "ll"
     * Output: 2
     * Example 2:
     * <p>
     * Input: haystack = "aaaaa", needle = "bba"
     * Output: -1
     */

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                // 找到第一个字符相同的了
                int index = 1;
                for (; index < needle.length(); index++) {
                    // 匹配剩余的字符
                    if (i + index > haystack.length()) {
                        break;
                    }
                    if (haystack.charAt(i + index) != needle.charAt(index)) {
                        break;
                    }
                }
                if (index == needle.length()) {
                    // 找到了
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "ll", needle = "ll";

        System.out.println(new ImplementStrStr().strStr(haystack, needle));
        haystack = "aaaaa";
        needle = "bba";
        System.out.println(new ImplementStrStr().strStr(haystack, needle));
    }
}
