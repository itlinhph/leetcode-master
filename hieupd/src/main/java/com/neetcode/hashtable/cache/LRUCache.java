package com.neetcode.hashtable.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

  int capacity;
  Node head;
  Node tail;
  Map<Integer, Node> cache;

  // combine hashmap for storage and searching, and doubly linked list for eviction
  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.head = new Node(0, 0); // head and tail will not be replaced but work as pointers
    this.tail = new Node(0, 0);
    this.head.next = tail;
    this.tail.prev = head;
    this.cache = new HashMap<>();
  }

  public int get(int key) {
    if (cache.containsKey(key)) {
      Node node = cache.get(key);
      removeFromRecentlyList(node);
      insertIntoRecentlyList(node);
      return node.value;
    }
    return -1;
  }

  private void removeFromRecentlyList(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  private void insertIntoRecentlyList(Node node) {
    node.next = head.next;
    head.next.prev = node;
    head.next = node;
    node.prev = head;
  }

  public void put(int key, int value) {
    // remove old node if the key exists before insert again
    if (cache.containsKey(key)) {
      Node oldNode = cache.get(key);
      cache.remove(key);
      removeFromRecentlyList(oldNode);
    }

    // evict before insert new node
    if (cache.size() == this.capacity) {
      cache.remove(tail.prev.key);
      removeFromRecentlyList(tail.prev);
    }

    // insert new
    Node newNode = new Node(key, value);
    cache.put(key, newNode);
    insertIntoRecentlyList(newNode);
  }
}
