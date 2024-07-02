package com.neetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> preMap = new HashMap<>();
    // prepare the preMap
    for (int i = 0; i < numCourses; i++) preMap.put(i, new ArrayList<>());

    // build preMap
    for (int[] pre : prerequisites) {
      preMap.get(pre[0]).add(pre[1]);
    }

    // dfs and check if any cycle in the graph
    int[] visit = new int[numCourses];
    for (int crs = 0; crs < numCourses; crs++) {
      if (dfs(crs, preMap, visit)) return false;
    }
    return true;
  }

  private boolean dfs(int crs, Map<Integer, List<Integer>> preMap, int[] visit) {
      // visited => cycle graph => cannot finish and return false
      if (visit[crs] == 1) return true;

      // no dependencies => can finish
      if (preMap.get(crs).isEmpty()) return false;

      visit[crs] = 1;
      for (int pre : preMap.get(crs)) {
          if (dfs(pre, preMap, visit)) return true;
      }
      // unmark the crs as unvisited
      visit[crs] = 0;
      // update the dependencies is empty => we know that the crs can be finished
      // no need to check in the next time we visit it
      preMap.put(crs, new ArrayList<>());
      return false;
  }


}
