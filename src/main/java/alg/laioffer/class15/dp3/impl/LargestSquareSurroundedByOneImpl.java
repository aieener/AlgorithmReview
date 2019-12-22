package alg.laioffer.class15.dp3.impl;

import alg.laioffer.class15.dp3.LargestSquareSurroundedByOne;

public class LargestSquareSurroundedByOneImpl implements LargestSquareSurroundedByOne {
  @Override
  public int largestSquareSurroundedByOne(int[][] matrix) {
    // find right bottom corner, compare leftM and rightM take min
    // then check [row, col - min], and [row - min][col], if their M >= min
    if(matrix==null || matrix.length == 0 || matrix[0].length == 0) return 0;
    int rowLen = matrix.length;
    int colLen = matrix[0].length;
    int[][] MlTor = new int[rowLen][colLen];
    int[][] MuTod = new int[rowLen][colLen];

    // left to right
    for(int row = 0; row < rowLen; row++) {
      MlTor[row][0] = matrix[row][0] == 1 ? 1 : 0;
      for(int col = 1; col < colLen; col++) {
        MlTor[row][col] = matrix[row][col] == 1 ? MlTor[row][col - 1] + 1 : 0;
      }
    }
    // up to down
    for(int col = 0; col < colLen; col++) {
      MuTod[0][col] = matrix[0][col] == 1 ? 1 : 0;
      for(int row = 1; row < rowLen; row++) {
        MuTod[row][col] = matrix[row][col] == 1 ? MuTod[row - 1][col] + 1 : 0;
      }
    }
    int globalMax = 0;
    for(int row = 0; row < rowLen; row++) {
      for(int col = 0; col < colLen; col++) {
        int candidateLen = Math.min(MlTor[row][col], MuTod[row][col]);
        while(candidateLen >0) {
          // validate left bottom corner
          // and validate right to corner
          if(MuTod[row][col - candidateLen + 1] >= candidateLen && MlTor[row - candidateLen + 1][col] >= candidateLen) break;
          candidateLen--;
        }
        globalMax = Math.max(globalMax, candidateLen);
      }
    }
    return globalMax;
  }
}
