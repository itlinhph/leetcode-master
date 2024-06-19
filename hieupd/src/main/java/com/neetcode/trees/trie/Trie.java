package com.neetcode.trees.trie;

// https://leetcode.com/problems/implement-trie-prefix-tree/

public class Trie {

  Node root;

  public Trie() {
    this.root = new Node();
  }

  public void insert(String word) {
    Node curr = this.root;
    for (Character c : word.toCharArray()) {
      int idx = c - 'a';
      if (curr.nodes[idx] == null) {
        curr.nodes[idx] = new Node(c);
      }
      curr = curr.nodes[idx];
    }
    // mark as a word instead of a prefix
    curr.isWord = true;
  }

  public boolean search(String word) {
    Node curr = this.root;
    for (Character c : word.toCharArray()) {
      if (curr.nodes[c - 'a'] == null) return false;
      curr = curr.nodes[c - 'a'];
    }
    // differentiate a word and a prefix
    return curr.isWord();
  }

  public boolean startsWith(String prefix) {
    Node curr = this.root;
    for (char c : prefix.toCharArray()) {
      if (curr.nodes[c - 'a'] == null) return false;
      curr = curr.nodes[c - 'a'];
    }
    return true;
  }
}
