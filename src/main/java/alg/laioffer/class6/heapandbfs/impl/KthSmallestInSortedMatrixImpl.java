package alg.laioffer.class6.heapandbfs.impl;

import alg.laioffer.class6.heapandbfs.KthSmallestInSortedMatrix;

import java.util.*;

public class KthSmallestInSortedMatrixImpl implements KthSmallestInSortedMatrix {
    static class Pair {
        int col, row, val;

        public Pair(int row, int col, int val) {
            this.col = col;
            this.row = row;
            this.val = val;
        }
    }

    @Override
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair base, Pair other) {
                if(base.val < other.val) return -1;
                else if (base.val > other.val) return 1;
                return 0;
            }
        });
        minHeap.offer(new Pair(0, 0, matrix[0][0]));
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for(int i = 0; i < k - 1; i++) {
            Pair nodeToExpand = minHeap.poll();
            int nextRow = nodeToExpand.row + 1;
            int nextCol = nodeToExpand.col + 1;
            if(inBound(nextRow, nodeToExpand.col, matrix) && !visited[nextRow][nodeToExpand.col]) {
                minHeap.offer(new Pair(nextRow, nodeToExpand.col, matrix[nextRow][nodeToExpand.col]));
                visited[nextRow][nodeToExpand.col] = true;
            }
            if(inBound(nodeToExpand.row, nextCol, matrix) && !visited[nodeToExpand.row][nextCol]) {
                minHeap.offer(new Pair(nodeToExpand.row, nextCol, matrix[nodeToExpand.row][nextCol]));
                visited[nodeToExpand.row][nextCol] = true;
            }
        }
        return minHeap.peek().val;
    }

    private boolean inBound(int row, int col, int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        return row < rowLen && row >= 0 && col < colLen && col >=0;
    }
}
