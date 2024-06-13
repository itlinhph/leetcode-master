package com.neetcode.arrays.sliding_window;

public class MinimumSubArray {

  // Best time complexity is O(n), worse = O(nm) with m is the avg length of inner loop
  public int minSubArrayLen(int target, int[] nums) {
    int sum = 0;
    int minLen = Integer.MAX_VALUE;
    int l = 0;
    // traverse through the array, calculate the accumulate sum
    // in each step, we will check with target and remove the oldest num from the sum
    // to find the min length
    for (int r = 0; r < nums.length; r++) {
      sum += nums[r];
      while (sum >= target) {
        minLen = Math.min(minLen, r - l + 1);
        sum -= nums[l];
        l++;
      }
    }
    return minLen == Integer.MAX_VALUE ? 0 : minLen;
  }
}
