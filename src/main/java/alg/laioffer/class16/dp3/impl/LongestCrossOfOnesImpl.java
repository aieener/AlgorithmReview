package alg.laioffer.class16.dp3.impl;

public class LongestCrossOfOnesImpl {
  /**
   * fake 2D DP
   * check LaiOffer's Sol!
   * for each direction, we run for LongCOne
   */
  public int largest(int[][] matrix) {
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
    // step 1 scan for all 4 directions
    int[][] MLeftToRight = getMemoizeLeftToRight(matrix);
    int[][] MRightToLeft = getMemoizeRightToLeft(matrix);
    int[][] MUpToDown = getMemoizeUpToDown(matrix);
    int[][] MDownToUp = getMemoizeDownToUp(matrix);
    // step 2 check Matrix
    int res = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        int cur = Math.min(MRightToLeft[i][j], MLeftToRight[i][j]);
        cur = Math.min(cur, MUpToDown[i][j]);
        cur = Math.min(cur, MDownToUp[i][j]);
        res = Math.max(res, cur);
      }
    }
    return res;
  }

  private int[][] getMemoizeDownToUp(int[][] matrix) {
    int[][] MDownToUp = new int[matrix.length][matrix[0].length];
    int len = matrix[0].length;
    for (int col = 0; col < len; col++) {
      MDownToUp[matrix.length - 1][col] = matrix[matrix.length - 1][col] == 1 ? 1 : 0;
      for (int row = matrix.length - 2; row >= 0; row--) {
        if (matrix[row][col] == 1) {
          MDownToUp[row][col] = MDownToUp[row + 1][col] + 1;
        } else {
          MDownToUp[row][col] = 0;
        }
      }
    }
    return MDownToUp;
  }

  private int[][] getMemoizeUpToDown(int[][] matrix) {
    int[][] MUpToDown = new int[matrix.length][matrix[0].length];
    int len = matrix[0].length;
    for (int col = 0; col < len; col++) {
      MUpToDown[0][col] = matrix[0][col] == 1 ? 1 : 0;
      for (int row = 1; row < matrix.length; row++) {
        if (matrix[row][col] == 1) {
          MUpToDown[row][col] = MUpToDown[row - 1][col] + 1;
        } else {
          MUpToDown[row][col] = 0;
        }
      }
    }
    return MUpToDown;
  }

  private int[][] getMemoizeRightToLeft(int[][] matrix) {
    int[][] MRightToLeft = new int[matrix.length][matrix[0].length];
    int len = matrix[0].length;
    for (int i = 0; i < matrix.length; i++) {
      MRightToLeft[i][len - 1] = matrix[i][len - 1] == 1 ? 1 : 0;
      for (int j = len - 2; j >= 0; j--) {
        if (matrix[i][j] == 1) {
          MRightToLeft[i][j] = MRightToLeft[i][j + 1] + 1;
        } else {
          MRightToLeft[i][j] = 0;
        }
      }
    }
    return MRightToLeft;
  }

  private int[][] getMemoizeLeftToRight(int[][] matrix) {
    int[][] MLeftToRight = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      MLeftToRight[i][0] = matrix[i][0] == 1 ? 1 : 0;
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][j] == 1) {
          MLeftToRight[i][j] = MLeftToRight[i][j - 1] + 1;
        } else {
          MLeftToRight[i][j] = 0;
        }
      }
    }
    return MLeftToRight;
  }
}
