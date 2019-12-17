package alg.laioffer.class11.recursionII.impl;

import alg.laioffer.class11.recursionII.SpiralOrderTraverseOne;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraverseOneImpl implements SpiralOrderTraverseOne {
  @Override
  public List<Integer> spiral(int[][] matrix) {
    List<Integer> res = new ArrayList<>();
    spiralTranverse(matrix, 0, matrix.length, res);
    return res;
  }

  private void spiralTranverse(int[][] matrix, int offset, int len, List<Integer> res) {
    // base case
    if (len == 0) {
      return;
    }
    if (len == 1) {
      res.add(matrix[offset][offset]);
      return;
    }

    for (int i = 0; i < len - 1; i++) {
      res.add(matrix[offset][offset + i]);
    }
    for (int i = 0; i < len - 1; i++) {
      res.add(matrix[offset + i][offset + len - 1]);
    }
    for (int i = len - 1; i >= 1; i--) {
      res.add(matrix[offset + len - 1][offset + i]);
    }
    for (int i = len - 1; i >= 1; i--) {
      res.add(matrix[offset + i][offset]);
    }
    spiralTranverse(matrix, offset + 1, len - 2, res);
  }
}
