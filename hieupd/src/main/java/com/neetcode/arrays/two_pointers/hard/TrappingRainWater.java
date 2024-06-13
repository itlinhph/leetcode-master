package com.neetcode.arrays.two_pointers.hard;

public class TrappingRainWater {

  // time O(n), space O(1)
  public int trap(int[] height) {
    if (height.length == 0) return 0;
    int l = 0, r = height.length - 1;
    int leftMax = height[l], rightMax = height[r];
    int res = 0;
    while (l < r) {
        if (leftMax < rightMax) {
            // shift to the right to find any area between left and right pointers
            l++;
            // update the left max value
            leftMax = Math.max(leftMax, height[l]);
            // calculate the water can be trapped: Min(leftMax, rightMax) - current height
            res += leftMax - height[l];
        } else {
            r--;
            // update the right max value
            rightMax = Math.max(rightMax, height[r]);
            //
            res += rightMax - height[r];
        }
    }
    return res;
  }
}
