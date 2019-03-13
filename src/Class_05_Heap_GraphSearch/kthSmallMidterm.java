package Class_05_Heap_GraphSearch;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yuding on 1/25/18.
 * This one is very much like search KthSortMatrix!
 */
public class kthSmallMidterm {
    class Cell {
        int aIdx;
        int bIdx;
        public Cell(int aIdx, int bIdx) {
            this.aIdx = aIdx;
            this.bIdx = bIdx;
        }
    }
    public int kthSmallest(int [] A, int [] B, int k) {
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(2, new Comparator<Cell>() {
            @Override
            public int compare(Cell c1, Cell c2) {
                int sum1 = A[c1.aIdx] + B[c1.bIdx];
                int sum2 = A[c2.aIdx] + B[c2.bIdx];
                return Integer.compare(sum1, sum2);
            }
        });

        boolean[][] visited = new boolean[A.length][B.length];
        minHeap.offer(new Cell(0,0));
        visited[0][0] = true;
        for(int i = 0; i < k - 1; i++) {
            Cell temp = minHeap.poll();
            if(temp.aIdx + 1 < A.length && !visited[temp.aIdx + 1][temp.bIdx]){
                visited[temp.aIdx + 1][temp.bIdx] = true;
                minHeap.offer(new Cell(temp.aIdx + 1, temp.bIdx));
            }
            if(temp.bIdx + 1 < B.length && !visited[temp.aIdx][temp.bIdx + 1]) {
                visited[temp.aIdx][temp.bIdx + 1] = true;
                minHeap.offer(new Cell(temp.aIdx, temp.bIdx +1));
            }
        }
        Cell res = minHeap.poll();
        return A[res.aIdx] + B[res.bIdx];
    }
}
