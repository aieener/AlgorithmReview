package alg.laioffer.class14.dp2.impl;

import alg.laioffer.class14.dp2.LargestSquareOfOnes;

public class LargestSquareOfOnesImpl implements LargestSquareOfOnes {
    @Override
    public int largest(int[][] matrix) {
        int[][] M = new int[matrix.length][matrix[0].length];
        int globalMax = 0;
        // base case
        for (int i = 0; i < matrix.length; i++) {
            M[i][0] = matrix[i][0];
            globalMax = Math.max(globalMax, M[i][0]);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            M[0][i] = matrix[0][i];
            globalMax = Math.max(globalMax, M[0][i]);
        }

        // M[i][j] represents, square's left corner pos, the Maximum amt

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                int left = M[row][col - 1];
                int up = M[row - 1][col];
                int inner = M[row - 1][col - 1];
                int minNeighbor = Math.min(inner, Math.min(left, up));
                if (matrix[row][col] == 1) {
                    M[row][col] = minNeighbor + 1;
                } else {
                    M[row][col] = 0;
                }
                globalMax = Math.max(globalMax, M[row][col]);
            }
        }
        return globalMax;
    }
}
