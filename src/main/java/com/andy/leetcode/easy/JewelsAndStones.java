package com.andy.leetcode.easy;

/**
 * Created by andy on 2019/5/16.
 */
public class JewelsAndStones {
    /**
     * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
     * <p>
     * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
     * <p>
     * Example 1:
     * <p>
     * Input: J = "aA", S = "aAAbbbb"
     * Output: 3
     * Example 2:
     * <p>
     * Input: J = "z", S = "ZZ"
     * Output: 0
     * Note:
     * <p>
     * S and J will consist of letters and have length at most 50.
     * The characters in J are distinct.
     */

    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (J.contains(S.substring(i, i + 1))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new JewelsAndStones().numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(new JewelsAndStones().numJewelsInStones("z", "ZZ"));
    }
}
