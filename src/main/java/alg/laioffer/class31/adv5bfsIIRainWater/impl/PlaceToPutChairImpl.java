package alg.laioffer.class31.adv5bfsIIRainWater.impl;

import alg.laioffer.class31.adv5bfsIIRainWater.PlaceToPutChair;

import java.util.*;

/**
 * for every Equipment, do dijk, find globalMin
 * for unweighted graph, BFS is the same as BFS2 (dijkstra)
 */
public class PlaceToPutChairImpl implements PlaceToPutChair {
  private final char EQUIP = 'E';
  private final char CHAIR = 'C';
  private final char OB = 'O';

  @Override
  public List<Integer> putChair(char[][] gym) {
    if (gym == null || gym.length == 0 || gym[0].length == 0) return Arrays.asList(-1, -1);
    Ptr res = findPlaceToPutChair(gym);
    return Arrays.asList(res.row, res.col);
  }

  private Ptr findPlaceToPutChair(char[][] gym) {
    int[][] cost = addCost(gym);
    return findMinCostPtr(cost, gym);
  }

  private Ptr findMinCostPtr(int[][] cost, char[][] gym) {
    Ptr sol = new Ptr(-1, -1);
    int curCost = Integer.MAX_VALUE;
    for (int row = 0; row < cost.length; row++) {
      for (int col = 0; col < cost[0].length; col++) {
        if (gym[row][col] == CHAIR && cost[row][col] < curCost) {
          curCost = cost[row][col];
          sol.row = row;
          sol.col = col;
        }
      }
    }
    return sol;
  }

  private int[][] addCost(char[][] gym) {
    int rowLen = gym.length;
    int colLen = gym[0].length;
    int[][] cost = new int[rowLen][colLen];
    for (int row = 0; row < rowLen; row++) {
      for (int col = 0; col < colLen; col++) {
        if (gym[row][col] == EQUIP)
          dijkstra(new Ptr(row, col), gym, cost);
      }
    }
    return cost;
  }

  private void dijkstra(Ptr seed, char[][] gym, int[][] cost) {
    Queue<Ptr> queue = new LinkedList();

    queue.offer(seed);
    boolean[][] visited = new boolean[cost.length][cost[0].length];
    visited[seed.row][seed.col] = true;
    int level = 1;
    while (!queue.isEmpty()) {

      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Ptr nodeToExpand = queue.poll();
        List<Ptr> neis = findNeighbor(nodeToExpand, gym);
        for (Ptr nei : neis) {
          if (!visited[nei.row][nei.col]) {
            visited[nei.row][nei.col] = true;
            cost[nei.row][nei.col] += level;
            queue.offer(nei);
          }
        }
      }
      level++;
    }
  }

  private List<Ptr> findNeighbor(Ptr base, char[][] gym) {
    int[] deltaRow = new int[]{1, 0, -1, 0};
    int[] deltaCol = new int[]{0, 1, 0, -1};
    List<Ptr> neighbors = new ArrayList<>();
    for (int d = 0; d < deltaCol.length; d++) {
      int newRow = base.row + deltaRow[d];
      int newCol = base.col + deltaCol[d];
      if (validate(gym, newRow, newCol)) {
        neighbors.add(new Ptr(newRow, newCol));
      }
    }
    return neighbors;
  }

  private boolean validate(char[][] gym, int newRow, int newCol) {
    return newRow >= 0 && newRow < gym.length && newCol >= 0 && newCol < gym[0].length && gym[newRow][newCol] != OB;
  }

  static class Ptr {
    int row, col;

    Ptr(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }
}
