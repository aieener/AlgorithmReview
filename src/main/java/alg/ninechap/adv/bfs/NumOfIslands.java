package alg.ninechap.adv.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yuding on 1/25/18.
 * Given a boolean 2D matrix,0is represented as the sea,
 * 1 is represented as the island. If two 1 is adjacent,
 * we consider them in the same island. We only consider
 * up/down/left/right adjacent. Find the number of islands.
 */
public class NumOfIslands {
    class Cell{
        int row, col;
        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int numIslands(boolean[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++){
                if(grid[i][j]){
                    res++;
                    BFS(grid, new Cell(i,j));
                }
            }
        }
        return res;
    }

    private void BFS(boolean[][] grid, Cell cell){
        Queue<Cell> queue = new LinkedList<>();
        queue.offer(cell);
        int [] dirR = {1,0,0,-1};
        int [] dirC = {0,1,-1,0};
        while(!queue.isEmpty()) {
            Cell cur = queue.poll();
            grid[cur.row][cur.col] = false;
            for(int i = 0; i < 4; i++) {
                int neiRow = cur.row + dirR[i];
                int neiCol = cur.col + dirC[i];
                if(inBound(neiRow,neiCol, grid) && grid[neiRow][neiCol]){
                    queue.offer(new Cell(neiRow, neiCol));
                }
            }
        }
    }

    private boolean inBound(int row, int col, boolean[][] grid){
        return row >= 0 && row < grid.length && col >=0 && col < grid[0].length;
    }
}
