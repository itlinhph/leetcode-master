package com.neetcode.linkedlists.fast_slow_pointers;

// https://leetcode.com/problems/linked-list-cycle

public class LinkedListCycle {

  public static boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;
    // move forward slow pointer 1 step, fast pointer 2 steps
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      // fast pointer meets the slow pointer => cycle detected
      if (slow == fast) return true;
    }
    return false;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode cycleNode = new ListNode(1);
    head.next = cycleNode;
    head.next.next = new ListNode(3);
    head.next.next.next = cycleNode;
    System.out.println(hasCycle(head));
  }
}
