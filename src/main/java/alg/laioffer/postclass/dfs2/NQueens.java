package alg.laioffer.postclass.dfs2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuding on 2/2/18.
 * Recursion row by row | DFS: recur inside a for loop ---> 100% DFS
 * Base case: the last row is done, 0 row left
 * Recursion rule: iff position(i,j) valid -> go to next row :(i + 1)
 * xxxx
 * xxxx
 * xxxx
 * <p>
 * Time(n^n) -- > O(n!)
 */
public class NQueens {
  public List<List<Integer>> nqueens(int n) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> curLayerSol = new ArrayList<>();
    dfs(res, curLayerSol, 0, n);
    return res;
  }

  private void dfs(List<List<Integer>> res, List<Integer> curLayerSol, int layer, int n) {
    // base case
    if (layer == n) {
      if (curLayerSol.size() == n) {
        res.add(new ArrayList<>(curLayerSol));
      }
    }
    for (int i = 0; i < n; i++) {
      if (validate(curLayerSol, i, layer, n)) {
        curLayerSol.add(i);
        dfs(res, curLayerSol, layer + 1, n);
        curLayerSol.remove(curLayerSol.size() - 1);
      }
    }
  }

  private boolean validate(List<Integer> curLayerSol, int colPos, int rowPos, int n) {
    // check if the current state is valid
    for (int row = 0; row < curLayerSol.size(); row++) {
      int col = curLayerSol.get(row);
      if (!twoQueenCouldCoExist(row, col, rowPos, colPos, n)) {
        return false;
      }
    }
    return true;
  }

  private boolean twoQueenCouldCoExist(int row, int col, int otherRow, int otherCol, int n) {
    if (row == otherRow || col == otherCol) return false;
    int[] delaX = new int[]{1, 1, -1, -1};
    int[] delaY = new int[]{1, -1, 1, -1};

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < delaX.length; j++) {
        int curRow = row + i * delaX[j];
        int curCol = col + i * delaY[j];
        if (outOfBound(curRow, n) || outOfBound(curCol, n)) continue;
        if (curRow == otherRow && curCol == otherCol) return false;
      }
    }
    return true;
  }

  private boolean outOfBound(int x, int n) {
    return x < 0 || x >= n;
  }


  public static void main(String[] args) {
    NQueens nq = new NQueens();
    List<List<Integer>> res = nq.nqueens(4);
    System.out.print(res);
    System.out.print(res.size());
  }

  //--------- prac --------------
}
