package com.neetcode.dynamic_programming.medium;

import java.util.Arrays;

public class HouseRobber {

  public int rob(int[] nums) {
    return rob(nums, nums.length - 1);
  }

  // brute force
  private int rob(int[] nums, int i) {
    if (i < 0) return 0;
    // compare 2 options:
    // 1. curr num +num of i - 2
    // 2. num of i - 1
    return Math.max(nums[i] + rob(nums, i - 2), rob(nums, i - 1));
  }

  // Memoization, top down, O(n) time, O(n) space
  public static int rob_memoization(int[] nums) {
    int[] cache = new int[nums.length + 1];
    // why -1: because 0 <= nums[i] <= 400 => so we can have sum = 0 for some branches
    // => should mark default value = -1 to avoid conflict
    Arrays.fill(cache, -1);
    return rob_mem(nums, cache, nums.length - 1);
  }

  private static int rob_mem(int[] nums, int[] cache, int i) {
    if (i < 0) return 0;
    if (cache[i] >= 0) return cache[i];
    cache[i] = Math.max(nums[i] + rob_mem(nums, cache, i - 2), rob_mem(nums, cache, i - 1));
    return cache[i];
  }
}
