package alg.laioffer.class15.dp3.impl;

import alg.laioffer.class15.dp3.LargestSubMatrixSum;

public class LargestSubMatrixSumO4Impl implements LargestSubMatrixSum {
    @Override
    public int largest(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int[][] M = getSubArraySumLkup(matrix, rowLen, colLen);

        int globalMax = matrix[0][0];
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                // matrix ending at (row, col)
                // handle fixed row case
                int curSum = M[row][col];
                for (int colLeft = 0; colLeft < col; colLeft++) {
                    curSum = Math.max(curSum, M[row][col] - M[row][colLeft]);
                }
                // handle fixed col case
                for (int rowUp = 0; rowUp < row; rowUp++) {
                    curSum = Math.max(curSum, M[row][col] - M[rowUp][col]);
                }
                // handle subMatrix case
                for (int rowUp = 0; rowUp < row; rowUp++) {
                    for (int colLeft = 0; colLeft < col; colLeft++) {
                        curSum = Math.max(curSum, M[row][col] - M[rowUp][col] - M[row][colLeft] + M[rowUp][colLeft]);
                    }
                }
                globalMax = Math.max(curSum, globalMax);
            }
        }
        return globalMax;
    }

    private int[][] getSubArraySumLkup(int[][] matrix, int rowLen, int colLen) {
        // M[i][j] represents sum of square (0,0) to (i, j)
        int[][] M = new int[rowLen][colLen];
        M[0][0] = matrix[0][0];
        for (int row = 1; row < rowLen; row++) {
            M[row][0] = M[row - 1][0] + matrix[row][0];
        }
        for (int col = 1; col < colLen; col++) {
            M[0][col] = M[0][col - 1] + matrix[0][col];
        }

        for (int row = 1; row < rowLen; row++) {
            for (int col = 1; col < colLen; col++) {
                M[row][col] = M[row - 1][col] + M[row][col - 1] - M[row - 1][col - 1] + matrix[row][col];
            }
        }
        return M;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {-4, 2, -1, 0, 2},
                {2, 3, 2, 1, -3},
                {-3, -3, -2, 2, 4},
                {1, 1, 2, -2, 5},
                {-4, 0, 1, 1, -4}};
        System.out.println(new LargestSubMatrixSumO4Impl().largest(input));
    }
}
