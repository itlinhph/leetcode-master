package com.neetcode.arrays.prefixsums;

public class NumArray {

  private int[] prefixSum;

  public NumArray(int[] nums) {
    int total = 0;
    prefixSum = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      total += nums[i];
      prefixSum[i] = total;
    }
  }

  public int sumRange(int left, int right) {
    int preRight = prefixSum[right];
    int preLeft = left > 0 ? prefixSum[left - 1] : 0; // left - 1: to include the value at left position
    return preRight - preLeft;
  }
}
