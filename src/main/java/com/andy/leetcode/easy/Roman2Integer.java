package com.andy.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by andy on 2019/5/5.
 */
public class Roman2Integer {
    /**
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     * <p>
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
     * <p>
     * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
     * <p>
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
     * <p>
     * Example 1:
     * <p>
     * Input: "III"
     * Output: 3
     * Example 2:
     * <p>
     * Input: "IV"
     * Output: 4
     * Example 3:
     * <p>
     * Input: "IX"
     * Output: 9
     * Example 4:
     * <p>
     * Input: "LVIII"
     * Output: 58
     * Explanation: L = 50, V= 5, III = 3.
     * Example 5:
     * <p>
     * Input: "MCMXCIV"
     * Output: 1994
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     *
     * @https://leetcode.com/problems/roman-to-integer/
     */
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        int length = s.length();
        int last = 0;
        int result = 0;
        for (int i = length - 1; i >= 0; i--) {
            int value = map.get(String.valueOf(s.charAt(i)));
            if (value >= last) {
                result += value;
            } else {
                result -= value;
            }
            last = value;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(new Roman2Integer().romanToInt(s));
    }
}
