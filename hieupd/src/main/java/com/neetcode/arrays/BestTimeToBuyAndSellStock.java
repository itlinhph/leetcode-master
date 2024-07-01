package com.neetcode.arrays;

public class BestTimeToBuyAndSellStock {

  public static int maxProfit(int[] prices) {
    if (prices.length <= 1) return 0;
    int minPrice = prices[0];
    int maxProfit = 0;
    for (int price : prices) {
      minPrice = Math.min(minPrice, price);
      maxProfit = Math.max(maxProfit, price - minPrice);
    }
    return maxProfit;
  }

  public static void main(String[] args){
      int[] prices = {10, 14, 2, 100, 200, 10};
    System.out.println(maxProfit(prices));
  }
}
