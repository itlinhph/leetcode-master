package com.neetcode.trees.basics;

// https://leetcode.com/problems/search-in-a-binary-search-tree
// https://leetcode.com/problems/insert-into-a-binary-search-tree
// https://leetcode.com/problems/delete-node-in-a-bst

public class BST {

  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) return null;
    if (root.val == val) return root;
    if (root.val < val) return searchBST(root.right, val);
    return searchBST(root.left, val);
  }

  // insert a new node and return the root of BST
  public TreeNode insert(TreeNode root, int val) {
    if (root == null) return new TreeNode(val);
    if (val > root.val) root.right = insert(root.right, val);
    else if (val < root.val) root.left = insert(root.left, val);
    return root;
  }

  // 2 scenarios:
  // 1. Target node has 0 or 1 child => replace by the child node
  // 2. Target node has 2 children => replace by the smallest nodes among all greater nodes of
  // the target node
  public TreeNode remove(TreeNode root, int val) {
    if (root == null) return null;
    if (val > root.val) {
      root.right = remove(root.right, val);
    } else if (val < root.val) {
      root.left = remove(root.left, val);
    } else {
      if (root.left == null) return root.right;
      else if (root.right == null) return root.left;
      else {
        // find the min node of all greater nodes of the target node
        TreeNode minNode = findMinNode(root.right);
        root.val = minNode.val;
        root.right = remove(root.right, minNode.val);
      }
    }
    return root;
  }

  private TreeNode findMinNode(TreeNode root) {
    TreeNode curr = root;
    // traverse to the left branch
    while (curr != null && curr.left != null) curr = curr.left;
    return curr;
  }
}
