package com.neetcode.trees.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

  private Map<Character, TrieNode> children;
  private boolean isWord;

  public TrieNode() {
    this.children = new HashMap<>();
    this.isWord = false;
  }

  public Map<Character, TrieNode> getChildren() {
    return children;
  }

  public void setChildren(Map<Character, TrieNode> children) {
    this.children = children;
  }

  public boolean isWord() {
    return isWord;
  }

  public void setWord(boolean word) {
    isWord = word;
  }
}
