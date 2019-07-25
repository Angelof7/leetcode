package com.andy.leetcode.medium;

import java.util.Arrays;

/**
 * Created by andy on 2019/7/25.
 */
public class UniqueBinarySearchTree {
    /**
     * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
     * <p>
     * Example:
     * <p>
     * Input: 3
     * Output: 5
     * Explanation:
     * Given n = 3, there are a total of 5 unique BST's:
     * <p>
     * 1         3     3      2      1
     * \       /     /      / \      \
     * 3     2     1      1   3      2
     * /     /       \                 \
     * 2     1         2                 3
     *
     * @link https://leetcode.com/problems/unique-binary-search-trees/
     */
    public int numTrees0(int n) {
        int[] dp = new int[n + 1];
        if (n == 0 || n == 1) return n;
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[0] = 1;
        cache[1] = 1;
        return numTreesHelper(1, n, cache);
    }

    private int numTreesHelper(int lower, int upper, int[] cache) {
        if (lower < 0 || lower > upper) {
            return 1;

        } else if (cache[upper - lower + 1] != -1) {
            return cache[upper - lower + 1];

        }

        int sum = 0; // 2
        for (int rootValue = lower; rootValue <= upper; rootValue++) {
            int leftBSTs = numTreesHelper(lower, rootValue - 1, cache); // # of possible left BST subtrees with given root value
            int rightBSTs = numTreesHelper(rootValue + 1, upper, cache); // # of possible right BST subtrees with given root value

            sum += (leftBSTs * rightBSTs);

        }
        // cache the value so that the number of trees can be returned for already calculated sizes.
        // for example, number of BSTs created from 1 to 5 will be same as number of BSTs created from 4 to 8
        cache[upper - lower + 1] = sum;
        return sum;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new UniqueBinarySearchTree().numTrees0(i));
        }
    }
}
