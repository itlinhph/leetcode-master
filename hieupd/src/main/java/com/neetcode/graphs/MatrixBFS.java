package com.neetcode.graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MatrixBFS {

  /** Find the length of shortest path from top left to bottom right */
  public static int bfs(int[][] grid) {
    int ROW = grid.length, COL = grid[0].length;
    Queue<int[]> queue = new LinkedList<>();
    int[][] visit = new int[ROW][COL];
    // add top left point as starting point
    queue.add(new int[]{0, 0});
    visit[0][0] = 1;

    int length = 0;
    while(!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] idx = queue.poll();
        int r = idx[0], c = idx[1];
        // reach the bottom right
        if (r == ROW - 1 && c == COL - 1) return length + 1;

        // check and add values of next layer to the queue
        int[][] neighbors = {{r + 1, c}, {r - 1, c}, {r, c + 1}, {r, c - 1}};
        for (int j = 0; j < 4; j++) {
          int newR = neighbors[j][0], newC = neighbors[j][1];
          // check out of bound or visited
          if (newR < 0
              || newR == ROW
              || newC < 0
              || newC == COL
              || visit[newR][newC] == 1
              || grid[newR][newC] == 1) continue;
          queue.offer(new int[]{newR, newC});
          visit[newR][newC] = 1;
        }
      }
      // increment for each layer
      length++;
    }
    return -1;

  }

  public static void main(String[] args) {
    int[][] grid = {{0, 0, 0, 0, 0}, {0, 1, 1, 1, 1}, {0, 1, 0, 0, 0}, {0, 0, 0, 1, 0}};
    System.out.println(bfs(grid));
  }
}
