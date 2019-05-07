package com.andy.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andy on 2019/5/7.
 */
public class ValidParentheses {
    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * <p>
     * An input string is valid if:
     * <p>
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Note that an empty string is also considered valid.
     * <p>
     * Example 1:
     * <p>
     * Input: "()"
     * Output: true
     * Example 2:
     * <p>
     * Input: "()[]{}"
     * Output: true
     * Example 3:
     * <p>
     * Input: "(]"
     * Output: false
     * Example 4:
     * <p>
     * Input: "([)]"
     * Output: false
     * Example 5:
     * <p>
     * Input: "{[]}"
     * Output: true
     *
     * @seehttps://leetcode.com/problems/valid-parentheses/
     */

    public static Map<Character, Character> parentheses = new HashMap<>();

    static {
        parentheses.put(')', '(');
        parentheses.put(']', '[');
        parentheses.put('}', '{');
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Character pC = parentheses.get(c);
            if (pC == null) {
                chars.add(c);
            } else if (chars.size() > 0 && chars.get(chars.size() - 1).equals(pC)) {
                chars.remove(chars.size() - 1);
            } else {
                return false;
            }
        }
        return chars.size() == 0;
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(new ValidParentheses().isValid(s));
        s = "([)]";
        System.out.println(new ValidParentheses().isValid(s));
        s = "{[]}";
        System.out.println(new ValidParentheses().isValid(s));
    }

}
