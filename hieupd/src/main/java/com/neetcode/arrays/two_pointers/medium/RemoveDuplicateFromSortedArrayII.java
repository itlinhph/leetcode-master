package com.neetcode.arrays.two_pointers.medium;

public class RemoveDuplicateFromSortedArrayII {

  public int removeDuplicates(int[] nums) {
    if (nums.length < 3) return nums.length;
    int i = 2, j = 2;
    while (j < nums.length) {
      // if nums[i - 2] == nums[j], we have more than 2 duplicated values
      // => slow position should be replaced by another unique number from slow - 2 to slow
      // therefore we will move slow pointer until we meet a number that diff from slow number
      if (nums[i - 2] != nums[j]) {
        nums[i] = nums[j];
        i++;
      }
      j++;
    }
    return i;
  }
}
