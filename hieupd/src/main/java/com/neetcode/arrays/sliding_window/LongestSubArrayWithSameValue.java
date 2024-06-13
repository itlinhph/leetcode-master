package com.neetcode.arrays.sliding_window;

public class LongestSubArrayWithSameValue {

  public static int findSubArray(int[] arr) {
    if (arr.length <= 1) return arr.length;
    int l = 0, r = 1;
    int max = 0;
    // traverse the R pointer to expand the window until we encounter a diff value
    while (r < arr.length) {
      // if duplicates => recalculate the max length
      if (arr[l] == arr[r]) max = Math.max(max, r - l + 1);
      else l = r; // bring L pointer to the R pointer because all values between them are duplicates
      r++; // expand the window
    }
    return max;
  }

  public static void main(String[] args){
    int[] arr = {1, 2, 2, 3, 3, 3, 4};
    System.out.println(findSubArray(arr));
  }
}
