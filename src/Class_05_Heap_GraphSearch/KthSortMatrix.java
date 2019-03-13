package Class_05_Heap_GraphSearch;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Need revisit!
 *  - Dec 31 revisit
 *  BFS2(Best first search)
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

    static class Cell2 {
        int row, col, val;
        Cell2(int r, int c, int v){
            row = r;
            col = c;
            val = v;
        }
    }

    public int kthSmallest2(int[][]matrix, int k){
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        PriorityQueue<Cell2> minheap = new PriorityQueue<>(k, new Comparator<Cell2>() {
            @Override
            public int compare(Cell2 t0, Cell2 t1) {
                if(t0.val == t1.val) {
                    return 0;
                }
                return t0.val < t1.val ? -1 : 1;
            }
        });

        boolean[][] visited = new boolean[rowLen][colLen];
        minheap.offer(new Cell2(0, 0, matrix[0][0]));
        visited[0][0] = true;
        int count = 0;
        while (count < k - 1 ){
            // poll k - 1 times, the one left at heap will be kth smallest
            Cell2 cur = minheap.poll();

            if(cur.row + 1 < rowLen &&
                     !visited[cur.row + 1][cur.col]){
                Cell2 nei1 = new Cell2(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]);
                minheap.offer(nei1);
                visited[nei1.row][nei1.col] = true;
            }
            if(cur.col + 1 < colLen &&
                     !visited[cur.row][cur.col + 1]){
                Cell2 nei2 = new Cell2(cur.row , cur.col + 1, matrix[cur.row ][cur.col + 1]);
                minheap.offer(nei2);
                visited[nei2.row][nei2.col] = true;
            }
            count++;
        }
        return minheap.peek().val;
    }
}
