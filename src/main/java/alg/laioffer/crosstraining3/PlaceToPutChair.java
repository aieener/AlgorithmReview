package alg.laioffer.crosstraining3;

import java.util.*;

/**
 * BFS
 */
public class PlaceToPutChair {
  private static final char OB = 'O';
  private static final char EQUIP = 'E';
  private static final char CHAIR = 'C';

  public List<Integer> putChair(char[][] gym) {
    int height = gym.length;
    int width = gym[0].length;
    // fill cost matrix
    int[][] cost = new int[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (gym[i][j] == EQUIP) {
          if (!addCost(cost, gym, i, j)) {
            return Arrays.asList(-1, -1);
          }
        }
      }
    }

    // find the smallest cost
    List<Integer> res = null;
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (gym[i][j] == CHAIR) {
          if (res == null) {
            res = Arrays.asList(i, j);
          } else if (cost[i][j] < cost[res.get(0)][res.get(1)]) {
            res.set(0, i);
            res.set(1, j);
          }
        }
      }
    }

    return res != null ? res : Arrays.asList(-1, -1);
  }

  private boolean addCost(int[][] cost, char[][] gym, int i, int j) {
    // DO BFS here
    boolean[][] visited = new boolean[gym.length][gym[0].length];
    int pathCost = 1;
    Queue<Pair> queue = new LinkedList<>();

    visited[i][j] = true;
    queue.offer(new Pair(i, j));
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int l = 0; l < size; l++) {
        Pair nodeToExpand = queue.poll();
        List<Pair> neis = getNeis(nodeToExpand, gym);
        for (Pair nei : neis) {
          if (!visited[nei.i][nei.j]) {
            visited[nei.i][nei.j] = true;
            cost[nei.i][nei.j] += pathCost;
            queue.offer(nei);
          }
        }
      }

      pathCost++;
    }

    // check if there is any unreachable E
    for (int l = 0; l < gym.length; l++) {
      for (int m = 0; m < gym[0].length; m++) {
        if (!visited[l][m] && gym[l][m] == EQUIP) {
          return false;
        }
      }
    }
    return true;
  }

  private List<Pair> getNeis(Pair cur, char[][] gym) {
    int x = cur.i;
    int y = cur.j;
    int height = gym.length;
    int width = gym[0].length;
    List<Pair> nei = new ArrayList<>();
    if (x + 1 < height && gym[x + 1][y] != OB) {
      nei.add(new Pair(x + 1, y));
    }
    if (y + 1 < width && gym[x][y + 1] != OB) {
      nei.add(new Pair(x, y + 1));
    }

    if (x - 1 >= 0 && gym[x - 1][y] != OB) {
      nei.add(new Pair(x - 1, y));
    }
    if (y - 1 >= 0 && gym[x][y - 1] != OB) {
      nei.add(new Pair(x, y - 1));
    }
    return nei;
  }

  static class Pair {
    int i, j;

    Pair(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }
}

