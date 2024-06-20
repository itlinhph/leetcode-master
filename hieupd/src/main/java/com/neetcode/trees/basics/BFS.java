package com.neetcode.trees.basics;

import java.util.ArrayDeque;
import java.util.Deque;

public class BFS {

  // use a queue to store and remove traversed nodes by level => no need recursion
  public static void bfs(TreeNode root) {
    Deque<TreeNode> queue = new ArrayDeque<>();
    if (root != null) queue.add(root);

    int level = 0;

    while (!queue.isEmpty()) {
      System.out.printf("\nLevel %s:", level);
      int levelLength = queue.size();
      for (int i = 0; i < levelLength; i++) {
        TreeNode curr = queue.pop();
        System.out.print(" " + curr.val);
        if (curr.left != null) queue.add(curr.left);
        if (curr.right != null) queue.add(curr.right);
      }
      level++;
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);
    bfs(root);
  }
}
