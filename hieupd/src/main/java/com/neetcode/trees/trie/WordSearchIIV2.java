package com.neetcode.trees.trie;

import java.util.*;

public class WordSearchIIV2 {

  Node root = new Node();
  int ROWS;
  int COLS;
  Set<String> result;
  int[][] visit;

  // build a trie from words, then traverse through the board and look up
  public List<String> findWords(char[][] board, String[] words) {
    // build the trie
    for (String word : words) {
      this.addWord(word);
    }

    ROWS = board.length;
    COLS = board[0].length;
    result = new HashSet<>();
    visit = new int[ROWS][COLS];

    for (int r = 0; r < ROWS; r++) {
      for (int c = 0; c < COLS; c++) {
        dfs(r, c, root, board, "");
      }
    }
    return result.stream().toList();
  }

  private void dfs(int r, int c, Node node, char[][] board, String word) {
    if (r < 0
        || c < 0
        || r == ROWS
        || c == COLS
        || visit[r][c] == 1
        || node.children[board[r][c] - 'a'] == null) return;

    visit[r][c] = 1;
    char ch = board[r][c];
    // shift to the child node
    node = node.children[ch - 'a'];
    word += ch;
    if (node.isWord) result.add(word);

    // dfs to 4 directions
    dfs(r - 1, c, node, board, word);
    dfs(r + 1, c, node, board, word);
    dfs(r, c - 1, node, board, word);
    dfs(r, c + 1, node, board, word);

    // mark as unread
    visit[r][c] = 0;
  }

  public void addWord(String word) {
    Node curr = this.root;
    for (char c : word.toCharArray()) {
      int idx = c - 'a';
      if (curr.children[idx] == null) curr.children[idx] = new Node(c);
      curr = curr.children[idx];
    }
    curr.isWord = true;
  }

  class Node {
    char ch;
    Node[] children;
    boolean isWord;

    public Node() {
      this.children = new Node[26];
      this.isWord = false;
    }

    public Node(char ch) {
      this.ch = ch;
      this.children = new Node[26];
      this.isWord = false;
    }
  }

  public static void main(String[] args) {
    String[] words = {"ab", "cb", "ac", "ad", "ag"};
    char[][] board = new char[4][4];
    Random random = new Random();
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        board[i][j] = (char) ('a' + random.nextInt(10));
      }
    }
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }

    WordSearchIIV2 searcher = new WordSearchIIV2();
    System.out.println(searcher.findWords(board, words));
  }
}
