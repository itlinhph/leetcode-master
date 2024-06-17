package com.neetcode.linkedlists.fast_slow_pointers;

// https://leetcode.com/problems/middle-of-the-linked-list/

public class MiddleOfLinkedList {

  public static ListNode middleNode(ListNode head) {
    ListNode fast = head, slow = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    System.out.println(middleNode(head).val);
  }
}
