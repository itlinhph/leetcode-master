package com.neetcode.graphs;

import java.util.ArrayDeque;
import java.util.Deque;

public class RottingOrange {

  // BFS with multiple sources
  public int orangesRotting(int[][] grid) {
    Deque<int[]> queue = new ArrayDeque<>();
    int times = 0, fresh = 0;
    int ROWS = grid.length, COLS = grid[0].length;

    // count fresh oranges and add rotten oranges to queue
    for (int r = 0; r < ROWS; r++) {
      for (int c = 0; c < COLS; c++) {
        if (grid[r][c] == 1) fresh++;
        else if (grid[r][c] == 2) queue.add(new int[] {r, c});
      }
    }

    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    while (!queue.isEmpty() && fresh > 0) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] idx = queue.pop();
        int r = idx[0], c = idx[1];
        for (int[] dir : directions) {
          int newR = r + dir[0], newC = c + dir[1];
          // out of bound or invalid values
          if (newR < 0 || newC < 0 || newR == ROWS || newC == COLS || grid[newR][newC] != 1)
            continue;
          // rotting
          grid[newR][newC] = 2;
          queue.add(new int[] {newR, newC});
          fresh--;
        }
      }
      times++;
    }
    return fresh > 0 ? -1 : times;
  }
}
