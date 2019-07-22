package com.andy.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy on 2019/7/22.
 */
public class RestoreIPAddresses {
    /**
     * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
     * <p>
     * Example:
     * <p>
     * Input: "25525511135"
     * Output: ["255.255.11.135", "255.255.111.35"]
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        helper(s, "", 0, 4, result);
        return result;
    }

    private void helper(String s, String ip, int index, int need, List<String> result) {
        if (need == 0 && index == s.length()) {
            result.add(ip);
        }
        for (int i = index + 1; i <= index + 3 && i <= s.length(); i++) {
            if (Integer.parseInt(s.substring(index, i)) <= 255 && s.length() - i <= 3 * (need - 1)) {
                if (s.charAt(index) == '0' && i - index > 1) {
                    // start with '0'
                    continue;
                }
                String newIp;
                if ("".equals(ip)) {
                    newIp = s.substring(index, i);
                } else {
                    newIp = ip + "." + s.substring(index, i);
                }
                helper(s, newIp, i, need - 1, result);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new RestoreIPAddresses().restoreIpAddresses("25525511135"));
    }
}
