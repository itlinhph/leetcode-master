package com.neetcode.arrays;

public class BestTimeToBuyAndSellStockII {

  // traverse and find the vertex
  // update minPrice any time we find a vertex
  public static int maxProfit(int[] prices) {
    if (prices.length <= 1) return 0;
    int maxProfit = 0;

    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) maxProfit += prices[i] - prices[i - 1];
    }

    return maxProfit;
  }

  public static void main(String[] args) {
    int[] prices = {7, 1, 5, 3, 6, 4};
    System.out.println(maxProfit(prices));
    int[] prices2 = {1, 2, 3, 4, 5};
    System.out.println(maxProfit(prices2));
  }
}
