package com.neetcode.two_pointers.easy;

public class RemoveDuplicateFromSortedArray {

  public int removeDuplicates(int[] nums) {
    if (nums.length <= 1) return nums.length;
    int i = 0, j = 1; // slow and fast pointers
    while (j < nums.length) {
      if (nums[i] != nums[j]) { // we ignore if equal => i is a marker of unique numbers in arr
        i++; // increment by 1 to replace the duplicates
        nums[i] = nums[j];
      }
      j++;
    }
    return i + 1;
  }
}
