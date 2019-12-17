package alg.laioffer.class11.recursionII.impl;

import alg.laioffer.class11.recursionII.NQueens;

import java.util.ArrayList;
import java.util.List;

public class NQueensImpl implements NQueens {
  @Override
  public List<List<Integer>> nqueens(int n) {
    List<List<Integer>> res = new ArrayList<>();
    dfs(n, res, new ArrayList<Integer>(), 0);
    return res;
  }

  private void dfs(int n, List<List<Integer>> res, List<Integer> curSol, int layer) {
    // base case
    if (layer == n) {
      res.add(new ArrayList<>(curSol));
      return;
    }
    for (int col = 0; col < n; col++) {
      if (canPut(curSol, col)) {
        curSol.add(col);
        dfs(n, res, curSol, layer + 1);
        curSol.remove(curSol.size() - 1);
      }
    }
  }

  private boolean canPut(List<Integer> curSol, int colPos) {
    for (int row = 0; row < curSol.size(); row++) {
      int col = curSol.get(row);
      if (!CouldCoexist(row, col, curSol.size(), colPos)) {
        return false;
      }
    }
    return true;
  }

  private boolean CouldCoexist(int row, int col, int otherRow, int otherCol) {
    return !(col == otherCol || Math.abs(col - otherCol) == otherRow - row);
  }
}
