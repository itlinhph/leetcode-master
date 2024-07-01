package com.neetcode.graphs;

import java.util.*;

public class CloneGraph {

  // DFS to traverse through all nodes of graph and clone
  // Time: O(n + m) with n = number of vertices, m = number of edges
  public Node cloneGraph(Node node) {
    // mapping value - new node
    Map<Integer, Node> map = new HashMap<>();
    return dfs(node, map);

  }

  private Node dfs(Node node, Map<Integer, Node> map) {
    if (node == null) return null;
    if (map.containsKey(node.val)) return map.get(node.val);
    // new node
    Node newNode = new Node(node.val);
    map.put(node.val, newNode);
    // DFS on each neighbor of the node
    for (Node neighbor : node.neighbors) {
      newNode.neighbors.add(dfs(neighbor, map));
    }
    return newNode;
  }
}
