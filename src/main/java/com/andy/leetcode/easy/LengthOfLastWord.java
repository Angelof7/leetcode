package com.andy.leetcode.easy;

/**
 * Created by andy on 2019/6/11.
 */
public class LengthOfLastWord {
    /**
     * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
     * <p>
     * If the last word does not exist, return 0.
     * <p>
     * Note: A word is defined as a character sequence consists of non-space characters only.
     * <p>
     * Example:
     * <p>
     * Input: "Hello World"
     * Output: 5
     */
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int lastWordLength = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (count != 0) {
                    lastWordLength = count;
                    count = 0;
                }
            } else {
                count++;
            }
        }
        if (count != 0) {
            lastWordLength = count;
        }
        return lastWordLength;
    }

    public int lengthOfLastWord2(String s) {
        if (s == null) {
            return 0;
        }
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord2("Hello World"));
        System.out.println(new LengthOfLastWord().lengthOfLastWord2("Hello World  "));
        System.out.println(new LengthOfLastWord().lengthOfLastWord2("  Hello World  "));
        System.out.println(new LengthOfLastWord().lengthOfLastWord2("  Hello"));
        System.out.println(new LengthOfLastWord().lengthOfLastWord2("  Hello  "));
    }
}
