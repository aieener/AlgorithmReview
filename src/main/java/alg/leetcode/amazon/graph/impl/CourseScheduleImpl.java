package alg.leetcode.amazon.graph.impl;

import alg.leetcode.amazon.graph.CourseSchedule;

import java.util.*;

/**
 * topoSort
 * key thought:
 * dependency --------------> dependent indegree of dependent is 2
 *                  /
 * dependency 2 ---
 *
 * dependency ---> dependant ,
 * if dependency course has been taken, all dependant degree - 1
 * List<List<Integer>>> edges : dependant: [dependency 1 , dependency 2, dependency 3, ...];
 */
public class CourseScheduleImpl implements CourseSchedule {
  @Override
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> edges = getDefaultEdges(numCourses);
    int[] degree = new int[numCourses]; // will mutate through bfs
    calcInDegree(numCourses, prerequisites, edges, degree);

    // find start Nodes
    Queue<Integer> queue = new LinkedList<>();
    for(int i = 0; i < degree.length; i++) {
      if(degree[i] == 0) queue.offer(i);
    }
    int courseTaken = 0;
    // bfs
    while(!queue.isEmpty()) {
      Integer nodeToExpand = queue.poll();
      courseTaken++;
      for(Integer dependant : edges.get(nodeToExpand)) {
        degree[dependant]--;
        if(degree[dependant] == 0) queue.offer(dependant);
      }
    }
    return courseTaken == numCourses;
  }

  private List<List<Integer>> getDefaultEdges(int numCourses) {
    List<List<Integer>> edges = new ArrayList<>();
    for(int i = 0; i < numCourses; i++) {
      edges.add(new ArrayList<>());
    }
    return edges;
  }

  private void calcInDegree (int numCourses, int[][] prerequisites, List<List<Integer>> edges, int [] degree) {
    for(int[] prerequisite : prerequisites) {
      int dependent = prerequisite[0];
      int dependency = prerequisite[1];
      degree[dependent]++;
      edges.get(dependency).add(dependent);

    }
  }
}
