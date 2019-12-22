package alg.laioffer.class15.dp3.impl;

import alg.laioffer.class15.dp3.LargestXOfOnes;

import java.util.Arrays;

public class LargestXOfOnesImpl implements LargestXOfOnes {
  public int largest(int[][] matrix) {
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
    int[][] MV = findVLkup(matrix);
    int[][] MA = findALkup(matrix);
    return findLargest(MV, MA, matrix);
  }

  private int findLargest(int[][] MV, int[][] MA, int[][] matrix) {
    int rowLen = matrix.length;
    int colLen = matrix[0].length;
    int res = 0;
    for(int row = 0; row < rowLen; row++) {
      for(int col = 0; col < colLen; col++) {
        int curRes = Math.min(MA[row][col], MV[row][col]);
        res = Math.max(curRes, res);
      }
    }
    return res;
  }

  private int[][] findALkup(int[][] matrix) {
    // MA[i][j] = maxArmLen with continue 1 in 'A' shape
    int rowLen = matrix.length;
    int colLen = matrix[0].length;
    int [][] MALeft = new int[rowLen][colLen]; // '/'
    int [][] MARight = new int[rowLen][colLen]; // '\'
    // base case:
    for(int col = 0; col < colLen; col++) {
      MALeft[rowLen - 1][col] = matrix[rowLen - 1][col] == 1 ? 1 : 0;
      MARight[rowLen - 1][col] = matrix[rowLen - 1][col] == 1 ? 1 : 0;
    }

    for(int row = rowLen - 2; row >=0; row--) {
      for(int col = 0; col < colLen; col++) {
        if(matrix[row][col] == 1) {
          if(col == 0 || col == colLen - 1){
            MALeft[row][col] = 1;
            MARight[row][col] = 1;
          }
          else {
            MALeft[row][col] = MALeft[row + 1][col - 1] + 1;
            MARight[row][col] = MARight[row + 1][col + 1] + 1;
          }
        }
      }
    }
    merge(MALeft, MARight);
    return MALeft;
  }

  private int[][] findVLkup(int[][] matrix) {
    // MV[i][j] = maxArmLen with continue 1 in 'v' shape
    int rowLen = matrix.length;
    int colLen = matrix[0].length;
    int [][] MVLeft = new int[rowLen][colLen];   // '\'
    int [][] MVRight = new int[rowLen][colLen];  // '/'
    // base case:
    for(int col = 0; col < colLen; col++) {
      MVLeft[0][col] = matrix[0][col] == 1 ? 1 : 0;
      MVRight[0][col] = matrix[0][col] == 1 ? 1 : 0;
    }
    for(int row = 1; row < rowLen; row++) {
      for(int col = 0; col < colLen; col++) {
        //do maxLenOfOnes for \ arm and / arm
        if(matrix[row][col] == 1) {
          if(col == 0 || col == colLen - 1) {
            MVLeft[row][col] = 1;
            MVRight[row][col] = 1;
          } else {
            MVLeft[row][col] = MVLeft[row - 1][col - 1] + 1;
            MVRight[row][col] = MVRight[row - 1][col + 1] + 1;
          }
        }
      }
    }
    merge(MVLeft, MVRight);
    return MVLeft;
  }

  private void merge(int[][] base, int[][] other) {
    int rowLen = base.length;
    int colLen = base[0].length;
    for(int row = 0; row < rowLen; row++) {
      for(int col = 0; col < colLen; col++) {
        base[row][col] = Math.min(base[row][col], other[row][col]);
      }
    }
  }
}
