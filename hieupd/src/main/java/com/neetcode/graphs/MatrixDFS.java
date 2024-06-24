package com.neetcode.graphs;

public class MatrixDFS {

  /** Count unique paths from top left to bottom right. A single path may only move along 0's */
  public static int dfs(int[][] grid) {
    int[][] visit = new int[grid.length][grid[0].length];
    return dfs(grid, 0, 0, visit);
  }

  private static int dfs(int[][] grid, int r, int c, int[][] visit) {

    // out of bound or visited
    if (r < 0
        || c < 0
        || r == grid.length
        || c == grid[0].length
        || visit[r][c] == 1
        || grid[r][c] == 1) return 0;

    // reach bottom right => return the count as 1
    if (r == grid.length - 1 && c == grid[0].length - 1) return 1;

    visit[r][c] = 1;
    int count = 0;
    count += dfs(grid, r + 1, c, visit);
    count += dfs(grid, r - 1, c, visit);
    count += dfs(grid, r, c - 1, visit);
    count += dfs(grid, r, c + 1, visit);
    visit[r][c] = 0;
    return count;
  }

  public static void main(String[] args) {
    int[][] grid = {{0, 0, 0, 0}, {0, 1, 0, 0}, {0, 1, 1, 0}, {0, 1, 0, 0}};
    System.out.println(dfs(grid));
  }
}
