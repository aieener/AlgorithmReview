package alg.laioffer.class31.adv5bfsIIRainWater.impl;

import alg.laioffer.class31.adv5bfsIIRainWater.MaxWaterTrappedTwo;

import java.util.*;

public class MaxWaterTrappedTwoImpl implements MaxWaterTrappedTwo {
    @Override
    public int maxTrapped(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows < 3 || cols < 3) {
            return 0;
        }
        Queue<Pair> minHeap = new PriorityQueue<Pair>(Comparator.comparing(Pair::getHeight));

        boolean[][] visited = new boolean[rows][cols];
        processBorder(matrix, visited, minHeap, rows, cols);
        int result = 0;
        while (!minHeap.isEmpty()) {
            Pair cur = minHeap.poll();
            List<Pair> neis = allNeis(cur, matrix);
            for (Pair nei : neis) {
                if (visited[nei.x][nei.y])
                    continue;
                visited[nei.x][nei.y] = true;
                //-------- do the rain water procedure-------
                result += Math.max(cur.height - nei.height, 0);
                // the code blow is crucial and is equal to leftMax = Math.max(leftMax, arr[left]) for 1D version
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
            minHeap.offer(new Pair(i, 0, matrix[i][0]));
            minHeap.offer(new Pair(i, cols - 1, matrix[i][cols - 1]));
            visited[i][0] = true;
            visited[i][cols - 1] = true;
        }
    }

    private List<Pair> allNeis(Pair cur, int[][] matrix) {
        List<Pair> neis = new ArrayList<>();
        if (cur.x + 1 < matrix.length) {
            neis.add(new Pair(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
        }
        if (cur.x - 1 >= 0) {
            neis.add(new Pair(cur.x - 1, cur.y, matrix[cur.x - 1][cur.y]));
        }
        if (cur.y + 1 < matrix[0].length) {
            neis.add(new Pair(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1]));
        }
        if (cur.y - 1 >= 0) {
            neis.add(new Pair(cur.x, cur.y - 1, matrix[cur.x][cur.y - 1]));
        }
        return neis;
    }

    static class Pair {
        int x;
        int y;
        int height;

        public Pair(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }

        public int getHeight() {
            return height;
        }
    }
}
