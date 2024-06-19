package com.neetcode.trees.trie;

// https://leetcode.com/problems/design-add-and-search-words-data-structure

public class WordDictionary {

  Node root;

  public WordDictionary() {
    this.root = new Node();
  }

  public void addWord(String word) {
    Node curr = this.root;
    for (char c : word.toCharArray()) {
      int idx = c - 'a';
      if (curr.nodes[idx] == null) curr.nodes[idx] = new Node(c);
      curr = curr.nodes[idx];
    }
    // mark as a completed word
    curr.isWord = true;
  }

  public boolean search(String word) {
    return searchHelper(word, root, 0);
  }

  private boolean searchHelper(String word, Node curr, int idx) {
    for (int i = idx; i < word.length(); i++) {
      char c = word.charAt(i);
      if (c == '.') {
        // ignore current char, and run dfs with all children of the current node
        for (Node child : curr.nodes) {
          if (child != null && searchHelper(word, child, i + 1)) return true;
        }
        return false;
      }
      if (curr.nodes[c - 'a'] == null) return false;
      curr = curr.nodes[c - 'a'];
    }
    return curr.isWord();
  }

  public static void main(String[] args) {
    WordDictionary wordDictionary = new WordDictionary();
    wordDictionary.addWord("day");
    wordDictionary.addWord("bay");
    wordDictionary.addWord("may");
    System.out.println(wordDictionary.search("say")); // return false
    System.out.println(wordDictionary.search("day")); // return true
    System.out.println(wordDictionary.search(".ay")); // return true
    System.out.println(wordDictionary.search("b..")); // return true
  }
}
