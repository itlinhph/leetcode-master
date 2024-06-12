package com.neetcode.two_pointers.medium;

public class ContainWithMostWater {

  public int maxArea(int[] height) {
    // 2 pointers i and j
    // for each time, we recalculate the area and compare with max area
    int max = 0;
    int i = 0;
    int j = height.length - 1;
    while (i < j) {
      if (height[i] < height[j]) {
        max = Math.max(max, height[i] * (j - i));
        i++; // move i forwards 1 step to find a higher line
      } else {
        max = Math.max(max, height[j] * (j - i));
        j--;
      }
    }
    return max;
  }
}
