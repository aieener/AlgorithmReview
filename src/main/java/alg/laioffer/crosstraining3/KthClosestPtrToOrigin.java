package alg.laioffer.crosstraining3;

import java.util.*;

/**
 * the three arrays are sorted
 */
public class KthClosestPtrToOrigin {
  public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
    Queue<Cell> minHeap = new PriorityQueue<>(new Comparator<Cell>() {
      @Override
      public int compare(Cell o1, Cell o2) {
        return o1.getDistance().compareTo(o2.getDistance());
      }
    });

    boolean[][][] visited = new boolean[a.length][b.length][c.length];
    visited[0][0][0] = true;
    minHeap.offer(new Cell(new Pair(0, a[0]), new Pair(0, b[0]), new Pair(0, c[0])));
    while (k > 1) {
      Cell nodeToExpand = minHeap.poll();
      int ai = nodeToExpand.a.idx;
      int bi = nodeToExpand.b.idx;
      int ci = nodeToExpand.c.idx;
      if (ai + 1 < a.length && !visited[ai + 1][bi][ci]) {
        visited[ai + 1][bi][ci] = true;
        minHeap.offer(new Cell(new Pair(ai + 1, a[ai + 1]), new Pair(bi, b[bi]), new Pair(ci, c[ci])));
      }

      if (bi + 1 < b.length && !visited[ai][bi + 1][ci]) {
        visited[ai][bi + 1][ci] = true;
        minHeap.offer(new Cell(new Pair(ai + 1, a[ai]), new Pair(bi + 1, b[bi + 1]), new Pair(ci, c[ci])));
      }

      if (ci + 1 < c.length && !visited[ai][bi][ci + 1]) {
        visited[ai][bi][ci + 1] = true;
        minHeap.offer(new Cell(new Pair(ai + 1, a[ai]), new Pair(bi, b[bi]), new Pair(ci + 1, c[ci + 1])));
      }
      k--;
    }
    Cell res = minHeap.peek();
    return Arrays.asList(res.a.val, res.b.val, res.c.val);
  }

  static class Pair {
    int idx;
    int val;
    Pair (int idx, int val) {
      this.idx = idx;
      this.val = val;
    }
  }

  static class Cell {
    Pair a,b,c;

    Cell(Pair a, Pair b, Pair c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }

    Integer getDistance() {
      return a.val * a.val + b.val * b.val + c.val * c.val;
    }
  }
}
