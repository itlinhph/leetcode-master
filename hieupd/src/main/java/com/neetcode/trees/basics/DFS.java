package com.neetcode.trees.basics;

public class DFS {

  // left branch => root => right branch
  public void inOrder(TreeNode root) {
    if (root == null) return;
    inOrder(root.left);
    System.out.println(root.val);
    inOrder(root.right);
  }

  // root => left branch => right branch
  public void preOrder(TreeNode root) {
    if (root == null) return;
    System.out.println(root.val);
    preOrder(root.left);
    preOrder(root.right);
  }

  // left branch => right branch => root
  public void postOrder(TreeNode root) {
    if (root == null) return;
    postOrder(root.left);
    postOrder(root.right);
    System.out.println(root.val);
  }
}
