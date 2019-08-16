package alg.laioffer.class15.dp3.impl;

import alg.laioffer.class15.dp3.LargestSquareSurroundedByOne;

public class LargestSquareSurroundedByOneImpl implements LargestSquareSurroundedByOne {
  @Override
  public int largestSquareSurroundedByOne(int[][] matrix) {
    // step 1 preprocessing
    int[][] MRightToLeft = getMRightToLeft(matrix);
    int[][] MDownToUp = getMDownToUp(matrix);

    int rowLen = matrix.length;
    int colLen = matrix[0].length;
    // step 2 check
    int res = 0;
    for (int row = 0; row < rowLen; row++) {
      for (int col = 0; col < colLen; col++) {
        int horArmLen = MRightToLeft[row][col];
        int verArmLen = MDownToUp[row][col];
        int armLen = Math.min(horArmLen, verArmLen);
        int proposeLen = armLen;
        for (int delta = armLen - 1; delta >= 0; delta--) {
          int curRow = row + delta;
          int curCol = col + delta;
          if (MRightToLeft[curRow][col] >= proposeLen && MDownToUp[row][curCol] >= proposeLen) break;
          proposeLen--;
        }
        res = Math.max(res, proposeLen);
      }
    }
    return res;
  }

  private int[][] getMRightToLeft(int[][] matrix) {
    int rowLen = matrix.length;
    int colLen = matrix[0].length;
    int[][] MRightToLeft = new int[rowLen][colLen];
    for (int row = 0; row < rowLen; row++) {
      for (int col = colLen - 1; col >= 0; col--) {
        if(matrix[row][col] == 1) {
          MRightToLeft[row][col] = getNumber(MRightToLeft, row, col + 1) + 1;
        }
      }
    }
    return MRightToLeft;
  }

  private int getNumber(int[][] m, int row, int col) {
    int rowLen = m.length;
    int colLen = m[0].length;
    if (row < 0 || row >= rowLen || col < 0 || col >= colLen) return 0;
    return m[row][col];
  }

  private int[][] getMDownToUp(int[][] matrix) {
    int rowLen = matrix.length;
    int colLen = matrix[0].length;
    int[][] MDownToUp = new int[rowLen][colLen];
    for (int col = 0; col < colLen; col++) {
      for (int row = rowLen - 1; row >= 0; row--) {
        if(matrix[row][col] == 1) {
          MDownToUp[row][col] = getNumber(MDownToUp, row + 1, col) + 1;
        }
      }
    }
    return MDownToUp;
  }
}
