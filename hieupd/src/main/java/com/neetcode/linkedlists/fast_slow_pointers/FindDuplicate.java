package com.neetcode.linkedlists.fast_slow_pointers;

// https://leetcode.com/problems/find-the-duplicate-number/

public class FindDuplicate {

  public static int findDuplicate(int[] nums) {
    int slow = 0, fast = 0;
    // same as a linked list with a cycle
    // apply Floyd's Tortoise and Hare algorithm to detect the cycle
    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    } while (slow != fast);

    int slow2 = 0;
    do {
      slow = nums[slow];
      slow2 = nums[slow2];
    } while (slow != slow2);

    return slow;
  }

  public static void main(String[] args) {
    int[] nums = {1, 3, 4, 2, 2};
    System.out.println(findDuplicate(nums));
  }
}
