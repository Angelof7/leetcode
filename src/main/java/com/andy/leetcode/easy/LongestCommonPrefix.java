package com.andy.leetcode.easy;

/**
 * Created by andy on 2019/5/6.
 */
public class LongestCommonPrefix {
    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     * <p>
     * If there is no common prefix, return an empty string "".
     * <p>
     * Example 1:
     * <p>
     * Input: ["flower","flow","flight"]
     * Output: "fl"
     * Example 2:
     * <p>
     * Input: ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     * Note:
     * <p>
     * All given inputs are in lowercase letters a-z.
     *
     * @https://leetcode.com/problems/longest-common-prefix/
     */

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        int commonSize = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            int size = getCommonSize(strs[i], strs[i - 1]);
            if (size < commonSize) {
                commonSize = size;
            }
            if (commonSize == 0) {
                break;
            }
        }
        return strs[0].substring(0, commonSize);
    }

    private int getCommonSize(String a, String b) {
        if (a == null || b == null) {
            return 0;
        }
        int sizeA = a.length();
        int sizeB = b.length();
        int length = Math.min(sizeA, sizeB);
        int commonSize = 0;
        for (int i = 0; i < length; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                commonSize++;
            } else {
                break;
            }
        }
        return commonSize;
    }

    public static void main(String[] args) {
        String[] s = new String[]{"flower", "flow", "flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(s));
        s = new String[]{"dog", "racecar", "car"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(s));
    }
}
