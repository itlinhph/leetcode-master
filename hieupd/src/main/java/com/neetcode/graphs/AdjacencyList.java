package com.neetcode.graphs;

import java.util.*;

public class AdjacencyList {

  public Map<String, List<String>> buildAdjList(String[][] edges) {
    Map<String, List<String>> adjList = new HashMap<>();
    for (String[] edge : edges) {
      String src = edge[0], dst = edge[1];
      if (!adjList.containsKey(src)) adjList.put(src, new ArrayList<>());
      if (!adjList.containsKey(dst)) adjList.put(dst, new ArrayList<>());
      adjList.get(src).add(dst);
    }
    return adjList;
  }

  // count paths that lead from a source to a destination
  // Time complexity: avg N edges for each vertex, h height of the tree => N^h
  public int dfs(String node, String target, Map<String, List<String>> adjList) {
    Set<String> visit = new HashSet<>();
    return dfsHelper(node, target, adjList, visit);
  }

  private int dfsHelper(
      String node, String target, Map<String, List<String>> adjList, Set<String> visit) {
    if (visit.contains(node)) return 0;
    if (Objects.equals(node, target)) return 1;

    visit.add(node);
    int count = 0;
    for (String neighbor : adjList.get(node)) {
      count += dfsHelper(neighbor, target, adjList, visit);
    }
    visit.remove(node);
    return count;
  }

  // shortest path from node to target
  // Time: V number of vertices, E number of edges => O(v + e)
  public int bfs(String node, String target, Map<String, List<String>> adjList) {
    Set<String> visit = new HashSet<>();
    Deque<String> queue = new ArrayDeque<>();
    visit.add(node);
    queue.add(node);

    int length = 0;
    while (!queue.isEmpty()) {
      int queueSize = queue.size();
      for (int i = 0; i < queueSize; i++) {
        String curr = queue.pop();
        // reach target node
        if (Objects.equals(curr, target)) return length;
        for (String neighbor : adjList.get(curr)) {
          if (visit.contains(neighbor)) continue;
          visit.add(neighbor);
          queue.add(neighbor);
        }
      }
      length++;
    }

    // if not reach target => return -1
    return -1;
  }
}
