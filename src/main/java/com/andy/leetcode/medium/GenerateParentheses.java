package com.andy.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy on 2019/6/1.
 */
public class GenerateParentheses {
    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     * <p>
     * For example, given n = 3, a solution set is:
     * <p>
     * [
     * "((()))",
     * "(()())",
     * "(())()",
     * "()(())",
     * "()()()"
     * ]
     *
     * @link https://leetcode.com/problems/generate-parentheses/
     */
    private List<String> parentheses = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return parentheses;
        }
        backTrace(n * 2, 0, new char[n * 2]);
        return parentheses;
    }

    private void backTrace(int n, int index, char[] chars) {
        if (index == n) {
            parentheses.add(new String(chars));
            return;
        }
        chars[index] = '(';
        if (isValidParentheses(chars, n, index)) {
            backTrace(n, index + 1, chars);
        }
        chars[index] = ')';
        if (isValidParentheses(chars, n, index)) {
            backTrace(n, index + 1, chars);
        }
    }

    private boolean isValidParentheses(char[] chars, int n, int index) {
        int countA = 0;
        int countB = 0;
        int balance = 0;
        for (int i = 0; i <= index; i++) {
            if (chars[i] == '(') {
                countA++;
                balance++;
            } else {
                countB++;
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return !(countA > n / 2 || countB > n / 2);
    }

    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
        System.out.println(new GenerateParentheses().generateParenthesis2(3));
    }
}
