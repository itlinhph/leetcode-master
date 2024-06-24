package com.neetcode.graphs;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/shortest-path-in-binary-matrix

public class ShortestPathBinaryMatrix {

  public int shortestPathBinaryMatrix(int[][] grid) {
    int ROW = grid.length, COL = grid[0].length;
    Queue<int[]> queue = new LinkedList<>();
    int[][] visit = new int[ROW][COL];
    if (grid[0][0] == 1 || grid[ROW - 1][COL - 1] == 1) return -1;

    // add top left point as starting point
    queue.add(new int[] {0, 0});
    visit[0][0] = 1;

    int length = 0;
      int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] idx = queue.poll();
        int r = idx[0], c = idx[1];
        // reach the bottom right
        if (r == ROW - 1 && c == COL - 1) return length + 1;

        // check and add values of next layer to the queue
        for (int[] dir : directions) {
          int newR = r + dir[0], newC = c + dir[1];
          // check out of bound or visited
          if (newR < 0
              || newR == ROW
              || newC < 0
              || newC == COL
              || visit[newR][newC] == 1
              || grid[newR][newC] == 1) continue;
          queue.offer(new int[] {newR, newC});
          visit[newR][newC] = 1;
        }
      }
      // increment for each layer
      length++;
    }
    return -1;
  }
}
