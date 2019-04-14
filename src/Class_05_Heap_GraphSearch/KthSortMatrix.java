package Class_05_Heap_GraphSearch;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * last review 3/19/2019, test failed, need to redo
 *
 * Need revisit!
 *  - Dec 31 revisit
 *  BFS2(Best first search)
 *  sol:
 *  1. initial state : input[0][0]
 *  2. node expansion/generation rule
 *      a. expand node [i][j]
 *          i. generate [i][j + 1\
 *          ii. generate [i + 1][j]
 *  3. termination condition
 *      a when the kth elements is popped out for expansion, then we know it's kth smallest!
 *  4. be careful about deduplication
 *
 *  time O(klogk)
 */
public class KthSortMatrix {
  static class Cell {
    int row;
    int column;
    int value;
    Cell (int row, int column, int value) {
      this.row = row;
      this.column = column;
      this.value = value;
    }
  }

  public int kthSmallest(int[][] matrix, int k) {
    int rowLen = matrix.length;
    int colLen = matrix[0].length;
    PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell>() {
      @Override
      public int compare(Cell o1, Cell o2) {
        if(o1.value == o2.value) {
          return 0;
        }
        return o1.value > o2.value ? 1 : -1;
      }
    });

    boolean [][] visited = new boolean[rowLen][colLen];
    minHeap.offer(new Cell(0,0,matrix[0][0]));
    visited[0][0] = true;

    // Do BFS2
    // Every iter, minHeap pop the minimum one, when the iteration is done
    // minheap will pop k - 1 elems, the one left on the top will be the kth smallest elem!
    for(int i = 0; i < k - 1; i++) {
      Cell cur = minHeap.poll();
      // Every iter, 一次加俩
      // insert the neighbor cell only if A. inbound, B. have not been generated before
      if(cur.row + 1 < rowLen && !visited[cur.row + 1][cur.column]) {
        minHeap.offer(new Cell(cur.row + 1, cur.column, matrix[cur.row + 1][cur.column]));
        visited[cur.row + 1][cur.column] = true; // mark as visited
      }
      if (cur.column + 1 < colLen && !visited[cur.row][cur.column + 1]) {
        minHeap.offer(new Cell(cur.row, cur.column + 1, matrix[cur.row][cur.column + 1]));
        visited[cur.row][cur.column + 1] = true; // mark as visited
      }
    }
    return minHeap.peek().value;
  }

  // prac
}
