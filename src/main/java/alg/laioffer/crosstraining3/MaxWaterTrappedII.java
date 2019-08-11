package alg.laioffer.crosstraining3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxWaterTrappedII {
  public int maxTrapped(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    if (rows < 3 || cols < 3) {
      return 0;
    }
    Queue<Pair> minHeap = new PriorityQueue<Pair>();
    boolean[][] visited = new boolean[rows][cols];
    processBorder(matrix, visited, minHeap, rows, cols);
    int result = 0;
    while(!minHeap.isEmpty()) {
      Pair cur = minHeap.poll();
      List<Pair> neis = allNeis(cur, matrix, visited);
      for(Pair nei : neis) {
        if(visited[nei.x][nei.y])
          continue;
        visited[nei.x][nei.y] = true;
        //-------- do the rain water procedure-------
        result += Math.max(cur.height - nei.height, 0);
        nei.height = Math.max(cur.height, nei.height);
        minHeap.offer(nei);
      }
    }
    return result;
  }

  private void processBorder(int[][] matrix, boolean[][] visited, Queue<Pair> minHeap, int rows, int cols) {
    for (int j = 0; j < cols; j++) {
      minHeap.offer(new Pair(0, j, matrix[0][j]));
      minHeap.offer(new Pair(rows - 1, j, matrix[rows - 1][j]));
      visited[0][j] = true;
      visited[rows - 1][j] = true;
    }

    for (int i = 0; i < rows; i++) {
      minHeap.offer(new Pair(i, 0, matrix[1][0]));
      minHeap.offer(new Pair(i, cols - 1, matrix[1][cols - 1]));
      visited[i][0] = true;
      visited[i][cols - 1] = true;
    }
  }

  private List<Pair> allNeis(Pair cur, int[][] matrix, boolean[][] visited) {
    List<Pair> neis = new ArrayList<>();
    if (cur.x + 1 < matrix.length && visited[cur.x + 1][cur.y]) {
      neis.add(new Pair(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
    }
    if (cur.x - 1 >= 0 && visited[cur.x - 1][cur.y]) {
      neis.add(new Pair(cur.x - 1, cur.y, matrix[cur.x - 1][cur.y]));
    }
    if (cur.y + 1 < matrix[0].length && visited[cur.x][cur.y + 1]) {
      neis.add(new Pair(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1]));
    }
    if (cur.y - 1 >= 0 && visited[cur.x][cur.y - 1]) {
      neis.add(new Pair(cur.x, cur.y - 1, matrix[cur.x][cur.y - 1]));
    }
    return neis;
  }

  static class Pair implements Comparable<Pair> {
    int x;
    int y;
    int height;

    public Pair(int x, int y, int height) {
      this.x = x;
      this.y = y;
      this.height = height;
    }

    @Override
    public int compareTo(Pair other) {
      if (this.height == other.height) {
        return 0;
      }
      return this.height < other.height ? -1 : 1;
    }
  }
}
