package com.neetcode.hashtable.cache;

public class LRUCacheV2 {

  Node[] cache;
  Node head;
  Node tail;
  int capacity;
  int size;

  public LRUCacheV2(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    this.head = new Node(0, 0);
    this.tail = new Node(0, 0);
    this.head.next = tail;
    this.tail.prev = head;
    this.cache = new Node[10000]; // the size is based on the requirement
  }

  public int get(int key) {
    Node node = cache[key];
    if (node == null) return -1;
    removeFromRecentlyList(node);
    insertIntoRecentlyList(node);
    return node.value;
  }

  public void put(int key, int value) {
    Node oldNode = cache[key];
    // existed => remove from cache and recent list
    if (oldNode != null) {
      cache[key] = null;
      removeFromRecentlyList(oldNode);
      size--;
    }
    // after removing old node, check if capacity is full
    // => evict from cache and recent list
    if (size == capacity) {
      cache[tail.prev.key] = null;
      removeFromRecentlyList(tail.prev);
      size--;
    }

    // insert new
    Node newNode = new Node(key, value);
    cache[key] = newNode;
    size++;
    insertIntoRecentlyList(newNode);
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
}
