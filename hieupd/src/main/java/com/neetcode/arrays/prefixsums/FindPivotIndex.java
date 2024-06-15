package com.neetcode.arrays.prefixsums;

import java.util.Arrays;

public class FindPivotIndex {

  public static int pivotIndex(int[] nums) {
    if (nums.length == 1) return 0;
    int[] prefixSum = new int[nums.length];
    int sum = 0;
    // calculate prefix sum
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      prefixSum[i] = sum;
    }

    // check pivot at first position
    if (prefixSum[nums.length - 1] - nums[0] == 0) return 0;

    // check the rest
    for (int i = 1; i < nums.length; i++) {
      // pivot is at i position
      if (prefixSum[nums.length - 1] - prefixSum[i] == prefixSum[i - 1]) return i;
    }
    return -1;
  }

  // no need an extra array
  public static int pivotIndex2(int[] nums) {
    int total = Arrays.stream(nums).sum();
    int leftSum = 0;
    for (int i = 0; i < nums.length; i++) {
      int rightSum = total - nums[i] - leftSum;
      if (rightSum == leftSum) return i;
      leftSum += nums[i];
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] nums = {1, 7, 3, 6, 5, 6};
    System.out.println(pivotIndex(nums));

    int[] nums2 = {1, 2, 3};
    System.out.println(pivotIndex(nums2));

    int[] nums3 = {2,1,-1};
    System.out.println(pivotIndex(nums3));
  }
}
