package alg.leetcode.amazon.datastructure.impl;

import alg.leetcode.amazon.datastructure.TicTacToe;

import java.util.HashMap;
import java.util.Map;

public class TicTacToeImpl implements TicTacToe {
  private char[][] board;
  private Map<Integer, Character> chessLkup;

  public TicTacToeImpl(int n) {
    board = new char[n][n];
    chessLkup = new HashMap<>();
    chessLkup.put(1, 'X');
    chessLkup.put(2, 'O');
  }

  @Override
  public int move(int row, int col, int player) {
    board[row][col] = chessLkup.get(player);
    if (checkWinner(row, col, board, chessLkup.get(player))) return player;
    return 0;
  }

  private boolean checkWinner(int row, int col, char[][] board, char target) {
    int len = board.length;
    int[] deltaRows = new int[]{1, 1, 1, 0 };
    int[] deltaCols = new int[]{-1, 0, 1, -1};
    for(int i = 0; i < deltaCols.length; i++) {
      int deltaRow = deltaRows[i];
      int deltaCol = deltaCols[i];
      int match = search(deltaRow, deltaCol, row, col,target ,board);
      int matchb = search(-deltaRow, -deltaCol, row, col,target ,board);
      if(match + matchb == len - 1) return true;
    }
    return false;
  }

  private int search(int deltaRow, int deltaCol, int row, int col, char target, char[][] board) {
    int newRow = row + deltaRow;
    int newCol = col + deltaCol;
    if(!onBoard(newRow, newCol, board.length) || board[newRow][newCol] != target) return 0;
    return search(deltaRow, deltaCol, newRow, newCol, target, board) + 1;

  }

  private boolean onBoard (int row, int col, int len) {
    return row >=0 && row < len && col >=0 && col < len;
  }

}
