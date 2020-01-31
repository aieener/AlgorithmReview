package alg.audible.impl;

import alg.audible.NumberOfIsland;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsImpl implements NumberOfIsland {
    static class Ptr {
        int row, col;

        public Ptr(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int numIslands(char[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) return res;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (grid[row][col] == '1' && !visited[row][col]) {
                    bfs(new Ptr(row, col), visited, grid);
                    res += 1;
                }
            }
        }
        return res;
    }

    private void bfs(Ptr seed, boolean[][] visited, char[][] grid) {
        Queue<Ptr> queue = new LinkedList<>();
        queue.offer(seed);
        visited[seed.row][seed.col] = true;
        int[] deltaX = new int[]{0, 0, -1, 1};
        int[] deltaY = new int[]{-1, 1, 0, 0};
        while (!queue.isEmpty()) {
            Ptr toExpand = queue.poll();
            for (int i = 0; i < deltaX.length; i++) {
                int genRow = toExpand.row + deltaY[i];
                int genCol = toExpand.col + deltaX[i];
                Ptr generate = new Ptr(genRow, genCol);
                if (isValid(generate, grid) && !visited[genRow][genCol]) {
                    queue.offer(generate);
                    visited[genRow][genCol] = true;
                }
            }
        }
    }

    private boolean isValid(Ptr target, char[][] grid) {
        return target.row >= 0 && target.row < grid.length && target.col >= 0 && target.col < grid[0].length && grid[target.row][target.col] == '1';
    }
}
