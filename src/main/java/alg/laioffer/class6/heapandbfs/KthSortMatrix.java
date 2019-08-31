package alg.laioffer.class6.heapandbfs;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

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
    Integer value;
    Cell (int row, int column, Integer value) {
      this.row = row;
      this.column = column;
      this.value = value;
    }
  }

  public int kthSmallest(int[][] matrix, int k) {
    // Write your solution here
    Queue<Cell> minHeap = new PriorityQueue<>(new Comparator<Cell>() {
      @Override
      public int compare(Cell o1, Cell o2) {
        return (o1.value).compareTo(o2.value);
      }
    });

    minHeap.offer(new Cell(0, 0, matrix[0][0]));
    int colLen = matrix[0].length;
    int rowLen = matrix.length;
    int i = 0;
    boolean[][] visited = new boolean[rowLen][colLen];
    while(i < k - 1) {
      Cell nodeToExpand = minHeap.poll();
      System.out.println(nodeToExpand.value);
      int rowIdx = nodeToExpand.row;
      int colIdx = nodeToExpand.column;
      // candidate 1 = col + 1, row | candidate 2 = col, row + 1;
      if(colIdx + 1 < colLen && !visited[rowIdx][colIdx + 1]){
        minHeap.offer(new Cell(rowIdx, colIdx + 1, matrix[rowIdx][colIdx + 1]));
        visited[rowIdx][colIdx + 1] = true;
      }
      if(rowIdx + 1 < rowLen && !visited[rowIdx + 1][colIdx]) {
        minHeap.offer(new Cell(rowIdx + 1, colIdx, matrix[rowIdx + 1][colIdx]));
        visited[rowIdx+1][colIdx] = true;
      }
      i++;
    }
    return minHeap.peek().value;
  }

  public static void main(String[] args) {
    int[] input1 = new int[]{1,2,3,4};
    int[] input2 = new int[]{11,12,13,14};
    int[] input3 = new int[]{15,16,17,18};
    int[] input4 = new int[]{19,20,21,22};

    int[][]input = new int[][]{input1,input2,input3,input4};

    System.out.println(new KthSortMatrix().kthSmallest(input,4));
  }
}
