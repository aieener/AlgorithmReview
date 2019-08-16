package alg.leetcode.amazon.datastructure.impl;

import alg.leetcode.amazon.datastructure.TicTacToe;

public class TicTacToeO1SpaceImpl implements TicTacToe {
  private int[] row, col;
  private int diag1, diag2;
  private int len;

  public TicTacToeO1SpaceImpl(int n) {
    this.row = new int[n];
    this.col = new int[n];
    this.len = n;
  }

  @Override
  public int move(int i, int j, int player) {
    if (player == 1) {
      row[i]++;
      col[j]++;
    } else {
      row[i]--;
      col[j]--;
    }

    if (i == j) diag1 += (player == 1) ? 1 : -1;
    if (i + j == len - 1) diag2 += (player == 1) ? 1 : -1;
    if (row[i] == len || col[j] == len || diag1 == len || diag2 == len) return 1;
    if (row[i] == -len || col[j] == -len || diag1 == -len || diag2 == -len) return 2;
    return 0;
  }
}
