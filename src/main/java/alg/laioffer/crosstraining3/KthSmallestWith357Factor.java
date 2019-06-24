package alg.laioffer.crosstraining3;

import java.util.*;

public class KthSmallestWith357Factor {
  public long kth(int k) {
    Queue<Cell> minHeap = new PriorityQueue<Cell>(new Comparator<Cell>() {
      @Override
      public int compare(Cell o1, Cell o2) {
        if (o1.val == o2.val) return 0;
        return o1.val > o2.val ? 1 : -1;
      }
    });
    minHeap.offer(new Cell(1, 1, 1));
    boolean[][][] visited = new boolean[k + 1][k + 1][k + 1];
    visited[1][1][1] = true;
    while (k > 1) {
      Cell noteToExpand = minHeap.poll();
      // add three cancidate
      int curA = noteToExpand.a;
      int curB = noteToExpand.b;
      int curC = noteToExpand.c;
      if (!visited[curA + 1][curB][curC]) {
        minHeap.offer(new Cell(curA + 1, curB, curC));
        visited[curA + 1][curB][curC] = true;
      }
      if (!visited[curA][curB + 1][curC]) {
        minHeap.offer(new Cell(curA, curB + 1, curC));
        visited[curA][curB + 1][curC] = true;
      }
      if (!visited[curA][curB][curC + 1]) {
        minHeap.offer(new Cell(curA, curB, curC + 1));
        visited[curA][curB][curC + 1] = true;
      }
      k--;
    }
    return minHeap.peek().val;
  }

  /**
   * 3: 1 2 3 4 5
   * 5: 1 2 3 4 5
   * 7: 1 2 3 4 5
   */

  static class Cell {
    int a, b, c;
    long val;

    Cell(int a, int b, int c) {
      this.a = a;
      this.b = b;
      this.c = c;
      this.val = this.calc(a, b, c);
    }

    long calc(int a, int b, int c) {
      return aPowb(3, a) * aPowb(5, b) * aPowb(7, c);
    }

    long aPowb(int a, int b) {
      // assume a and b are both positive
      if (b == 0) return 1;
      if (b == 1) return a;
      long sqrt = aPowb(a, b / 2);
      if (b % 2 == 0) {
        return sqrt * sqrt;
      }
      return a * sqrt * sqrt;
    }
  }

  /**
   * LaiOffer's simple sol
   */
  public long kthSimple(int k) {
    Queue<Long> minHeap = new PriorityQueue<>();
    Set<Long> visited = new HashSet<>();
    minHeap.offer(3 * 5 * 7L);
    visited.add(3 * 5 * 7L);
    while( k > 1) {
      long current = minHeap.poll();
      if(visited.add(3*current)) {
        minHeap.offer(3 * current);
      }
      if(visited.add(5 * current)) {
        minHeap.offer(5 * current);
      }
      if(visited.add(7 * current)) {
        minHeap.offer(7 * current);
      }
      k--;
    }
    return minHeap.peek();
  }


}
