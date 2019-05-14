package com.andy.leetcode.easy;

/**
 * Created by andy on 2019/5/14.
 */
public class CountAndSay {
    /**
     * The count-and-say sequence is the sequence of integers with the first five terms as following:
     * <p>
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 1 is read off as "one 1" or 11.
     * 11 is read off as "two 1s" or 21.
     * 21 is read off as "one 2, then one 1" or 1211.
     * <p>
     * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
     * <p>
     * Note: Each term of the sequence of integers will be represented as a string.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: 1
     * Output: "1"
     * Example 2:
     * <p>
     * Input: 4
     * Output: "1211"
     *
     * @seehttps://leetcode.com/problems/count-and-say/
     */

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }
        String pre = "11";
        String str;
        for (int i = 2; i < n; i++) {
            str = "";
            int count = 1;
            for (int j = 1; j < pre.length(); j++) {
                if (pre.charAt(j) == pre.charAt(j - 1)) {
                    count++;
                } else {
                    str += count + String.valueOf(pre.charAt(j - 1));
                    count = 1;
                }
            }
            str += count + String.valueOf(pre.charAt(pre.length() - 1));
            pre = str;
        }
        return pre;
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(1));
        System.out.println(new CountAndSay().countAndSay(2));
        System.out.println(new CountAndSay().countAndSay(3));
        System.out.println(new CountAndSay().countAndSay(4));
        System.out.println(new CountAndSay().countAndSay(5));
        System.out.println(new CountAndSay().countAndSay(6));
    }
}
