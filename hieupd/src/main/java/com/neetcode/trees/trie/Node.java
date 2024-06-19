package com.neetcode.trees.trie;

public class Node {

  char ch;
  Node[] nodes;
  boolean isWord;

  public Node(char ch) {
    this.ch = ch;
    this.nodes = new Node[26];
    this.isWord = false;
  }

  public Node() {
    this.nodes = new Node[26];
    this.isWord = false;
  }

  public boolean isWord() {
    return isWord;
  }

  public void setWord(boolean word) {
    isWord = word;
  }
}
