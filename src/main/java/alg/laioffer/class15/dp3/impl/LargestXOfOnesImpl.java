package alg.laioffer.class15.dp3.impl;

import alg.laioffer.class15.dp3.LargestXOfOnes;

import java.util.Arrays;

public class LargestXOfOnesImpl implements LargestXOfOnes {
  public static void main(String[] args) {
    int[][] input = {
        {1, 1, 1, 1, 1},
        {1, 0, 0, 1, 1},
        {1, 1, 1, 1, 1},
        {1, 1, 1, 1, 0},
        {0, 0, 0, 1, 1}
    };
    LargestXOfOnes engine = new LargestXOfOnesImpl();
    System.out.println(engine.largest(input));
  }

  @Override
  public int largest(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
    // step 1 scan for all 4 directions
    int[][] MUpV = getMemoizeUpV(matrix);
    int[][] MDownA = getMemoizeDownA(matrix);
    // step 2 check Matrix
    return mergeLkup(MUpV, MDownA);
  }

  private int mergeLkup(int[][] toMerge, int[][] M2) {
    int N = toMerge.length;
    int M = toMerge[0].length;
    int res = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        toMerge[i][j] = Math.min(toMerge[i][j], M2[i][j]);
        res = Math.max(res, toMerge[i][j]);
      }
    }
    return res;
  }

  private int[][] getMemoizeDownA(int[][] matrix) {
    int rowLen = matrix.length;
    int colLen = matrix[0].length;
    int[][] leftDown = new int[rowLen][colLen];
    int[][] rightDown = new int[rowLen][colLen];
    // scan down to up, right to left, lower matrix is already filled
    for (int row = rowLen - 1; row >= 0; row--) {
      for (int col = colLen - 1; col >= 0; col--) {
        if (matrix[row][col] == 1) {
          rightDown[row][col] = getNumber(rightDown, row + 1, col + 1) + 1;
          leftDown[row][col] = getNumber(leftDown, row + 1, col - 1) + 1;
        }
      }
    }
    mergeLkup(leftDown, rightDown);
    return leftDown;
  }

  private int[][] getMemoizeUpV(int[][] matrix) {
    int rowLen = matrix.length;
    int colLen = matrix[0].length;
    int[][] leftUp = new int[rowLen][colLen];
    int[][] rightUp = new int[rowLen][colLen];
    // scan up to down, left to right, upper matrix is already filled
    for (int row = 0; row < rowLen; row++) {
      for (int col = 0; col < colLen; col++) {
        if (matrix[row][col] == 1) {
          leftUp[row][col] = getNumber(leftUp, row - 1, col - 1) + 1;
          rightUp[row][col] = getNumber(rightUp, row - 1, col + 1) + 1;
        }
      }
    }
    mergeLkup(leftUp, rightUp);
    return leftUp;
  }

  /**
   * {1,1,1,1,1},
   * {1,0,0,1,1},
   * {1,1,1,1,1},
   * {1,1,1,1,0},
   * {0,0,0,1,1}}
   */

  private int getNumber(int[][] number, int row, int col) {
    int rowLen = number.length;
    int colLen = number[0].length;
    if (row < 0 || row >= rowLen || col < 0 || col >= colLen) return 0;
    return number[row][col];
  }

  private void printMatrix(int[][] M) {
    for (int i = 0; i < M.length; i++) {
      System.out.println(Arrays.toString(M[i]));
    }
  }
}
