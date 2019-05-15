package com.andy.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andy on 2019/5/15.
 */
public class LetterCombinationsOfAPhoneNumber {
    /**
     * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
     * <p>
     * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
     * <p>
     * <p>
     * <p>
     * Example:
     * <p>
     * Input: "23"
     * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * Note:
     * <p>
     * Although the above answer is in lexicographical order, your answer could be in any order you want.
     *
     * @seehttps://leetcode.com/problems/letter-combinations-of-a-phone-number/
     */

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> result = new ArrayList<>();


    public List<String> letterCombinations(String digits) {
        if (digits != null && digits.length() > 0) {
            // 递归
            backtrack("", digits);
        }
        return result;
    }

    private void backtrack(String combinations, String leftDigits) {
        if (leftDigits == null || leftDigits.length() == 0) {
            result.add(combinations);
            return;
        }
        String letters = phone.get(leftDigits.substring(0, 1));
        for (int i = 0; i < letters.length(); i++) {
            backtrack(combinations + letters.substring(i, i + 1), leftDigits.substring(1));
        }
    }

//    private char[] getLetters(int a) {
//        if (a < 2 || a > 9) {
//            return null;
//        }
//        char first = (char) ((a - 2) * 3 + 'a');
//        return new char[]{
//                first, (char) (first + 1), (char) (first + 2)
//        };
//    }

    public static void main(String[] args) {
        String str = "23";
        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations(str));
    }
}
