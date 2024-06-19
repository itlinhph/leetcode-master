package com.neetcode.trees.trie;

public class PrefixTree {

  private TrieNode root;

  public PrefixTree() {
    this.root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode curr = this.root;
    for (Character c : word.toCharArray()) {
      if (!curr.getChildren().containsKey(c)) curr.getChildren().put(c, new TrieNode());
      curr = curr.getChildren().get(c);
    }
    // mark as a word instead of prefix
    curr.setWord(true);
  }

  public boolean search(String word) {
    TrieNode curr = this.root;
    for (Character c : word.toCharArray()) {
      if (!curr.getChildren().containsKey(c)) return false;
      curr = curr.getChildren().get(c);
    }
    // check if the word is a full word instead of a prefix
    return curr.isWord();
  }

  public boolean startsWith(String prefix) {
    TrieNode curr = this.root;
    for (Character c : prefix.toCharArray()) {
      if (!curr.getChildren().containsKey(c)) return false;
      curr = curr.getChildren().get(c);
    }
    // because this is a prefix search => return true
    return true;
  }

  public static void main(String[] args){
    PrefixTree prefixTree = new PrefixTree();
    prefixTree.insert("dog");
    System.out.println(prefixTree.search("dog")); // return true
    System.out.println(prefixTree.search("do")); // return false
    System.out.println(prefixTree.startsWith("do")); // return true
    prefixTree.insert("do");
    System.out.println(prefixTree.search("do")); // return true
  }
}
