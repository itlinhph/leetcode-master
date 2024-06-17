package com.neetcode.linkedlists.fast_slow_pointers;

// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/

public class MaximumTwinSumOfLinkedList {

  public static int pairSum(ListNode head) {
    int maxSum = 0;
    ListNode prev = null, slow = head, fast = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;

      // move slow forwards 1 step, then assign prev to slow.next
      // => to reverse the linked list
      ListNode tmp = slow.next;
      slow.next = prev;
      prev = slow;
      slow = tmp;
    }

    // after the loop, the slow and prev pointers are at the middle of the list
    // slow is pointing forward, prev is pointing backward
    while (slow != null) {
      maxSum = Math.max(maxSum, slow.val + prev.val);
      slow = slow.next; // move to the end of the list
      prev = prev.next; // move to the beginning of the list
    }

    return maxSum;
  }

  public static void main(String[] args){
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(6);
    System.out.println(pairSum(head));
  }
}
