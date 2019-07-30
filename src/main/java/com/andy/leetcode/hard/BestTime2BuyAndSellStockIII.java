package com.andy.leetcode.hard;

/**
 * Author   : andy.gao
 * Mail     : gaochao07@meituan.com
 * Date     : 2019-07-30
 * Project  : leetcode
 */
public class BestTime2BuyAndSellStockIII {
    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * <p>
     * Design an algorithm to find the maximum profit. You may complete at most two transactions.
     * <p>
     * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
     * <p>
     * Example 1:
     * <p>
     * Input: [3,3,5,0,0,3,1,4]
     * Output: 6
     * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
     * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
     * Example 2:
     * <p>
     * Input: [1,2,3,4,5]
     * Output: 4
     * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
     * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
     * engaging multiple transactions at the same time. You must sell before buying again.
     * Example 3:
     * <p>
     * Input: [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transaction is done, i.e. max profit = 0.
     *
     * @link https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;

        int[] cache = new int[prices.length];
        int minPrice = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            profit = Math.max(profit, prices[i] - minPrice);
            cache[i] = profit;
        }

        int maxSofar = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            maxSofar = Math.max(maxSofar, cache[i - 1] - prices[i]);
            profit = Math.max(profit, maxSofar + prices[i]);
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(new BestTime2BuyAndSellStockIII().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new BestTime2BuyAndSellStockIII().maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
