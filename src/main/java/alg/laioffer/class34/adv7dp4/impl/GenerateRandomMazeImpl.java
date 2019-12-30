package alg.laioffer.class34.adv7dp4.impl;

import alg.laioffer.class34.adv7dp4.GenerateRandomMaze;

public class GenerateRandomMazeImpl implements GenerateRandomMaze {
    enum Dir {
        NORTH(-1, 0),
        SOUTH(1, 0),
        EAST(0, -1),
        WEST(0, 1);
        int deltaX, deltaY;

        Dir(int deltaX, int deltaY) {
            this.deltaX = deltaX;
            this.deltaY = deltaY;
        }

        public int moveX(int x, int times) {
            return x + times * deltaX;
        }

        public int moveY(int y, int times) {
            return y + times * deltaY;
        }
    }

    @Override
    public int[][] maze(int n) {
        int[][] res = new int[n][n];
        // init the maze
        init(res);
        dfs(res, 0, 0);
        return res;
    }

    // set only the entrance to 0, all the others to be 1s
    private void init(int[][] res) {
        for (int row = 0; row < res.length; row++) {
            for (int col = 0; col < res[0].length; col++) {
                if (row == 0 && col == 0) {
                    res[row][col] = 1;
                } else {
                    res[row][col] = 0;
                }
            }
        }
    }

    private void dfs(int[][] res, int x, int y) {
        Dir[] dirs = Dir.values();
        shuffle(dirs);
        for (Dir dir : dirs) {
            int nextX = dir.moveX(x, 2);
            int nextY = dir.moveY(y, 2); // 一次走两步, 两个都设成 0
            if (isValidWall(res, nextX, nextY)) {
                res[dir.moveX(x, 1)][dir.moveY(y, 1)] = 0;
                res[nextX][nextY] = 0;
                dfs(res, nextX, nextY);
            }
        }
    }

    private void shuffle(Dir[] dirs) {
        // so every time we got random directions
        for (int i = 0; i < dirs.length; i++) {
            int idx = (int) (Math.random() * (dirs.length - i));
            Dir temp = dirs[i];
            dirs[i] = dirs[i + idx];
            dirs[i + idx] = temp;
        }
    }

    private boolean isValidWall(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y < maze[0].length && y >= 0 && maze[x][y] == 1; // if becomes 0, then its visited!
    }
}
