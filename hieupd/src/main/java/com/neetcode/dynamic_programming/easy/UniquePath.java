package com.neetcode.dynamic_programming.easy;

// https://leetcode.com/problems/unique-paths/description/

public class UniquePath {

  public int uniquePaths(int m, int n) {
    int[][] cache = new int[m][n];
    return memoization(0, 0, m, n, cache);
    // return bruteForce(0, 0, m, n);
  }

  // Time O(2^nm)
  private int bruteForce(int r, int c, int R, int C) {
    if (r == R || c == C) return 0;
    // reach the bottom right
    if (r == R - 1 && c == C - 1) return 1;

    return bruteForce(r + 1, c, R, C) + bruteForce(r, c + 1, R, C);
  }

  // Time O(n * m)
  private int memoization(int r, int c, int R, int C, int[][] cache) {
    if (r >= R || c >= C) return 0;
    if (cache[r][c] > 0) return cache[r][c];
    if (r == R - 1 && c == C - 1) return 1;

    cache[r][c] = memoization(r + 1, c, R, C, cache) + memoization(r, c + 1, R, C, cache);
    return cache[r][c];
  }

  // Time O(n * m), Space O(m)
  private int dp(int R, int C) {
    int[] preRow = new int[C];

    for (int r = R - 1; r >= 0; r--) {
      int[] curRow = new int[C];
      // base case: the last value of a row always be 1
      curRow[C - 1] = 1;
      for (int c = C - 2; c >= 0; c--) {
        // calculate based on 2 branch of a node
        curRow[c] = curRow[c + 1] + preRow[c];
      }
      preRow = curRow;
    }
    return preRow[0]; // return the accumulated count
  }
}
