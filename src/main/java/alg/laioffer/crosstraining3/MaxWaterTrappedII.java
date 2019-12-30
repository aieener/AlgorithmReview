package alg.laioffer.crosstraining3;

import java.util.*;

public class MaxWaterTrappedII {
  static class Ptr {
    int row, col, height;
    public Ptr (int row, int col, int height) {
      this.row = row;
      this.col = col;
      this.height = height;
    }
  }

  public int maxTrapped(int[][] matrix) {
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
    Queue<Ptr> minHeap = new PriorityQueue<Ptr>(new Comparator<Ptr>(){
      @Override
      public int compare(Ptr base, Ptr other) {
        return base.height - other.height;
      }
    });

    boolean [][] visited = new boolean[matrix.length][matrix[0].length];

    // base case add borders
    for(int row = 0; row < matrix.length; row++) {
      minHeap.offer(new Ptr(row, 0, matrix[row][0]));
      minHeap.offer(new Ptr(row, matrix[0].length - 1, matrix[row][matrix[0].length - 1]));
      visited[row][0] = true;
      visited[row][matrix[0].length - 1] = true;
    }

    for(int col = 0; col < matrix[0].length; col++) {
      minHeap.offer(new Ptr(0, col, matrix[0][col]));
      minHeap.offer(new Ptr(matrix.length - 1, col, matrix[matrix.length - 1][col]));
      visited[0][col] = true;
      visited[matrix.length - 1][col] = true;
    }

    int totalAmt = 0;

    while(!minHeap.isEmpty()) {
      Ptr toExpand = minHeap.poll();
      int row = toExpand.row;
      int col = toExpand.col;
      int height = toExpand.height;

      if(!inValidPtr(matrix, row + 1, col) && !visited[row + 1][col]) {
        totalAmt += Math.max(0, height -  matrix[row + 1][col]);
        minHeap.offer(new Ptr(row + 1, col, Math.max(height,matrix[row + 1][col])));
        visited[row+1][col] = true;
      }
      if(!inValidPtr(matrix, row, col + 1) && !visited[row][col + 1]) {
        totalAmt += Math.max(0, height - matrix[row][col + 1]);
        minHeap.offer(new Ptr(row, col + 1, Math.max(height, matrix[row][col + 1])));
        visited[row][col + 1] = true;
      }
      if(!inValidPtr(matrix, row - 1, col) && !visited[row - 1][col]) {
        totalAmt += Math.max(0, height - matrix[row - 1][col]);
        minHeap.offer(new Ptr(row - 1, col, Math.max(height, matrix[row - 1][col])));
        visited[row - 1][col] = true;
      }
      if(!inValidPtr(matrix, row, col - 1) && !visited[row][col - 1]) {
        totalAmt += Math.max(0, height - matrix[row][col - 1]);
        minHeap.offer(new Ptr(row, col - 1, Math.max(height, matrix[row][col - 1])));
        visited[row][col - 1] = true;
      }
    }
    return totalAmt;
  }

  private boolean inValidPtr(int [][] matrix, int row, int col) {
    return row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length;
  }
}
