package com.andy.leetcode.medium;

/**
 * Created by andy on 2019/6/17.
 */
public class PermutationSequence {
    /**
     * The set [1,2,3,...,n] contains a total of n! unique permutations.
     * <p>
     * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
     * <p>
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * Given n and k, return the kth permutation sequence.
     * <p>
     * Note:
     * <p>
     * Given n will be between 1 and 9 inclusive.
     * Given k will be between 1 and n! inclusive.
     * Example 1:
     * <p>
     * Input: n = 3, k = 3
     * Output: "213"
     * Example 2:
     * <p>
     * Input: n = 4, k = 9
     * Output: "2314"
     * <p>
     * <p>
     * 1234
     * 1243
     * 1324
     * 1342
     * 1423
     * 1432
     * 2134
     * 2143
     * 2314
     * 2341
     * 2413
     * 2431
     * 3124
     * 3142
     * 3214
     * 3241
     * 3412	<--- k = 17
     * 3421
     * 4123
     * 4132
     * 4213
     * 4231
     * 4312
     * 4321
     * <p>
     * <p>
     * 3124
     * 3142
     * 3214
     * 3241
     * 3412	<--- k' = 4
     * 3421
     */

    private int[] func = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    public String getPermutation(int n, int k) {
        String s = "123456789";
        k--;
        StringBuilder result = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int idx = k / func[i];
            result.append(s.charAt(idx));
            s = removeCharAt(s, idx);
            k = k % func[i];
        }
        return result.toString();
    }

    private String removeCharAt(String s, int index) {
        return s.substring(0, index) + s.substring(index + 1);
    }

    public static void main(String[] args) {
        System.out.println(new PermutationSequence().getPermutation(3, 3));
        System.out.println(new PermutationSequence().getPermutation(4, 17));

    }
}
