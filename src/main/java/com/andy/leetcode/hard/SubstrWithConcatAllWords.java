package com.andy.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andy on 2019/6/6.
 */
public class SubstrWithConcatAllWords {
    /**
     * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
     * <p>
     * Example 1:
     * <p>
     * Input:
     * s = "barfoothefoobarman",
     * words = ["foo","bar"]
     * Output: [0,9]
     * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
     * The output order does not matter, returning [9,0] is fine too.
     * Example 2:
     * <p>
     * Input:
     * s = "wordgoodgoodgoodbestword",
     * words = ["word","good","best","word"]
     * Output: []
     *
     * @link https://leetcode.com/problems/substring-with-concatenation-of-all-words/
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }
        int length = words[0].length();
        int totalLength = length * words.length;
        Map<String, Integer> wordMap = buildWordMap(words);
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i).length() < totalLength) {
                break;
            }
            if (isValidConcatStr(s.substring(i, i + totalLength), words.length, length, wordMap)) {
                result.add(i);
            }
        }
        return result;
    }

    private Map<String, Integer> buildWordMap(String[] words) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }
        return wordMap;
    }


    private boolean isValidConcatStr(String s, int size, int len, Map<String, Integer> wordMap) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (int i = 0; i < size; i++) {
            int start = i * len;
            String word = s.substring(start, start + len);
            if (!wordMap.containsKey(word)) {
                return false;
            }
            if (wordCount.containsKey(word)) {
                int count = wordCount.get(word);
                if (count + 1 > wordMap.get(word)) {
                    return false;
                }
                wordCount.put(word, count + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new SubstrWithConcatAllWords().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(new SubstrWithConcatAllWords().findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
    }
}
