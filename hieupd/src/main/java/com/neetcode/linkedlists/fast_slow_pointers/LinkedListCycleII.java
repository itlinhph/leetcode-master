package com.neetcode.linkedlists.fast_slow_pointers;

// https://leetcode.com/problems/linked-list-cycle-ii/

public class LinkedListCycleII {

  public static ListNode detectCycle(ListNode head) {
    ListNode slow = head, fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) break;
    }

    if (fast == null || fast.next == null) return null;

    // using a second slow pointer start from head to find the node where the cycle begins
    ListNode slow2 = head;
    while (slow2 != slow) {
      slow = slow.next;
      slow2 = slow2.next;
    }
    return slow2;
  }

  public static void main(String[] args){
    ListNode head = new ListNode(1);
    ListNode cycleNode = new ListNode(1);
    head.next = cycleNode;
    head.next.next = new ListNode(3);
    head.next.next.next = cycleNode;
    System.out.println(detectCycle(head).val);
  }
}
