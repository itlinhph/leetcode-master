package com.neetcode.dynamic_programming;

public class Fibonacci {

  public static int bruteForce(int n) {
    if (n < 2) return n;
    return bruteForce(n - 1) + bruteForce(n - 2);
  }

  // memoization, top down
  public static int memoization(int n, int[] cache) {
    if (cache[n] > 0) return cache[n];
    if (n < 2) return n;
    cache[n] = memoization(n - 1, cache) + memoization(n - 2, cache);
    return cache[n];
  }

  // bottom up, no recursion
  public static int tabulation(int n) {
      if (n < 2) return n;

      // base case
      int[] dp = {0, 1};
      int i = 2;
      while (i <= n) {
          // recalculate
          int tmp = dp[1];
          dp[1] = dp[0] + dp[1];
          dp[0] = tmp;
          i++;
      }
      return dp[1];
  }

  public static void main(String[] args) {
    System.out.println(bruteForce(6));
    System.out.println(memoization(6, new int[7]));
    System.out.println(tabulation(6));
  }
}
