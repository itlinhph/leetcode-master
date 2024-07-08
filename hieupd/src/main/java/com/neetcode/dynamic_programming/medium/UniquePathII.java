package com.neetcode.dynamic_programming.medium;

public class UniquePathII {

  public int uniquePathsWithObstacles(int[][] grid) {
    int[][] cache = new int[grid.length][grid[0].length];
    return memoization(0, 0, grid, cache);
  }

  // Time O(n * m)
  private int memoization(int r, int c, int[][] grid, int[][] cache) {
    int R = grid.length, C = grid[0].length;
    if (r >= R || c >= C || grid[r][c] == 1) return 0;
    if (cache[r][c] > 0) return cache[r][c];
    if (r == R - 1 && c == C - 1) return 1;

    cache[r][c] = memoization(r + 1, c, grid, cache) + memoization(r, c + 1, grid, cache);
    return cache[r][c];
  }

  public int dp(int[][] grid) {
    int R = grid.length, C = grid[0].length;
    int[] dp = new int[C];
    // base case
    dp[C - 1] = 1;

    for (int r = R - 1; r >= 0; r--) {
      for (int c = C - 1; c >= 0; c--) {
        // obstacle => count = 0
        // in base case, if it's a obstacle => final count still = 0
        if (grid[r][c] == 1) dp[c] = 0;
        else if (c + 1 < C) {
          // accumulate the count
          dp[c] = dp[c] + dp[c + 1];
        }
      }
    }
    return dp[0];
  }
}
