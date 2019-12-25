package alg.leetcode.amazon.graph.impl;

import alg.leetcode.amazon.graph.WordSearch;

/**
 * Time complexity: O(m * n * 4^k) where k is the length of the word ( really it should be 3^k, don't have to search on parent stream direction)
 * dfs has been called m * n times
 * each dfs on the worst case would run O(4^k) 4 branch for each layer, and there are k layers
 */
public class WordSearchImpl implements WordSearch {
  @Override
  public boolean exist(char[][] board, String word) {
    int rowLen = board.length;
    int colLen = board[0].length;
    boolean [][] visited = new boolean[rowLen][colLen];
    boolean result = false;
    for (int i = 0; i < rowLen; i++) {
      for (int j = 0; j < colLen; j++) {
        if (dfs(board, word, i, j, 0, visited)) {
          result = true;
        }
      }
    }
    return result;
  }

  private boolean dfs(char[][] board, String word, int i, int j, int idx, boolean[][] visited) {
    int rowLen = board.length;
    int colLen = board[0].length;
    if (i < 0 || j < 0 || i > rowLen - 1 || j > colLen - 1 || visited[i][j] || board[i][j] != word.charAt(idx))
      return false;

    if (idx == word.length() - 1) return true;
    visited[i][j] = true;
    int[] deltaX = new int[]{-1, 0, 0, 1};
    int[] deltaY = new int[]{0, -1, 1, 0};
    for (int k = 0; k < deltaX.length; k++) {
      if (dfs(board, word, i + deltaX[k], j + deltaY[k], idx + 1, visited)) {
        return true;
      }
    }
    visited[i][j] = false;
    return false;
  }

  private boolean dfsWithOutSpace(char[][]board, String word, int i, int j, int idx) {
    int rowLen = board.length;
    int colLen = board[0].length;
    if (i < 0 || j < 0 || i > rowLen - 1 || j > colLen - 1 || board[i][j] != word.charAt(idx))
      return false;

    if (idx == word.length() - 1) return true;
    char temp = board[i][j];
    board[i][j] = '#';
    int[] deltaX = new int[]{-1, 0, 0, 1};
    int[] deltaY = new int[]{0, -1, 1, 0};
    for (int k = 0; k < deltaX.length; k++) {
      if (dfsWithOutSpace(board, word, i + deltaX[k], j + deltaY[k], idx + 1)) {
        return true;
      }
    }
    board[i][j] = temp;
    return false;
  }
}
