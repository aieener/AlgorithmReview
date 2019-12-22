package alg.laioffer.class15.dp3.impl;

import alg.laioffer.class15.dp3.LargestSquareOfMatches;

/*
    P is a point,
    0 no match
    1 match on its right
    2 match on its bottom
    3 match on both right & bottom

    P__ on right
    |
    on bottom
 */
public class LargestSquareOfMatchesImpl implements LargestSquareOfMatches {
    @Override
    public int largestSquareOfMatches(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int[][] MlTor = new int[rowLen][colLen];
        int[][] MuTod = new int[rowLen][colLen];

        for (int row = 0; row < rowLen; row++) {
            MlTor[row][0] = 0;
            for (int col = 1; col < colLen; col++) {
                MlTor[row][col] = hasMatchOnRight(matrix, row, col - 1) ? MlTor[row][col - 1] + 1 : 0;
            }
        }

        for (int col = 0; col < colLen; col++) {
            MuTod[0][col] = 0;
            for (int row = 1; row < rowLen; row++) {
                MuTod[row][col] = hasMatchOnBottom(matrix, row - 1, col) ? MuTod[row - 1][col] + 1 : 0;
            }
        }

        int globalMax = 0;
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                int candidateArmLen = Math.min(MlTor[row][col], MuTod[row][col]);
                while (candidateArmLen > 0) {
                    // check bleft and uright
                    if (MuTod[row][col - candidateArmLen] >= candidateArmLen
                            && MlTor[row - candidateArmLen][col] >= candidateArmLen) {
                        break;
                    }
                    candidateArmLen--;
                }
                globalMax = Math.max(globalMax, candidateArmLen);
            }
        }
        return globalMax;
    }

    private boolean hasMatchOnRight(int[][] matrix, int row, int col) {
        return matrix[row][col] == 1 || matrix[row][col] == 3;
    }

    private boolean hasMatchOnBottom(int[][] matrix, int row, int col) {
        return matrix[row][col] == 2 || matrix[row][col] == 3;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 0, 3, 3, 3, 0, 0, 2}, {3, 1, 0, 1, 0, 0, 1, 3}};
        new LargestSquareOfMatchesImpl().largestSquareOfMatches(input);
    }
}
