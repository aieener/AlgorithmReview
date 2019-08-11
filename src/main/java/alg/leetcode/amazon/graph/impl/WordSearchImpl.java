package alg.leetcode.amazon.graph.impl;

import alg.leetcode.amazon.graph.WordSearch;

import java.util.ArrayList;
import java.util.List;

public class WordSearchImpl implements WordSearch {
  @Override
  public boolean exist(char[][] board, String word) {
    if (word == null || word.length() == 0) return true;
    List<Point> seeds = findSeeds(board, word.charAt(0));
    if(seeds.size() == 0) return false;
    // do bfs on seeds
    int[] maxLen = new int[1];
    maxLen[0] = 0;
    for (Point seed : seeds) {
      boolean[][] visited = new boolean[board.length][board[0].length];
      dfs(board, seed, visited, word, 0, maxLen);
    }
    return maxLen[0] == word.length() - 1;
  }

  private void dfs(char[][] board, Point seed, boolean[][] visited, String word, int idx, int[] maxLen){
    // base case
    if(idx == word.length()) {
      maxLen[0] = idx;
    }

    if(seed.val == word.charAt(idx)) {
      visited[seed.row][seed.col] = true;
      idx++;
      List<Point> neighbors = getNeighbors(board, seed, visited);
      for(Point ptr : neighbors) {
        if(idx < word.length() && ptr.val == word.charAt(idx)) {
          maxLen[0] = Math.max(maxLen[0], idx);
          dfs(board, ptr, visited, word, idx, maxLen);
        }
      }
      visited[seed.row][seed.col] = false;
    }
  }

  private List<Point> findSeeds(char[][] board, char startLetter) {
    List<Point> seeds = new ArrayList<>();
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        if (startLetter == board[row][col]) {
          Point seed = new Point(row, col, startLetter);
          seeds.add(seed);
        }
      }
    }
    return seeds;
  }

  private List<Point> getNeighbors(char[][] board, Point currentPtr, boolean[][] visited) {
    int rowLen = board.length;
    int colLen = board[0].length;
    int[] deltaX = new int[]{-1, 0, 0, 1};
    int[] deltaY = new int[]{0, -1, 1, 0};
    List<Point> neighbors = new ArrayList<>();
    for (int i = 0; i < deltaX.length; i++) {
      int newRow = currentPtr.row + deltaY[i];
      int newCol = currentPtr.col + deltaX[i];
      if (newRow < rowLen && newRow >= 0 && newCol < colLen && newCol >= 0 && !visited[newRow][newCol]) {
        neighbors.add(new Point(newRow, newCol, board[newRow][newCol]));
      }
    }
    return neighbors;
  }

  class Point {
    char val;
    int col;
    int row;

    Point(int row, int col, char val) {
      this.val = val;
      this.row = row;
      this.col = col;
    }
  }

  public static void main(String[] args) {
    String input = "ABCESEEEFS";
    char[][] table = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};

    WordSearch ws = new WordSearchImpl();
    System.out.println(ws.exist(table, input));
  }
}
