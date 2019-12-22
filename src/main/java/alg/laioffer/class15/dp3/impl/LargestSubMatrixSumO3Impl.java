package alg.laioffer.class15.dp3.impl;

import alg.laioffer.class15.dp3.LargestSubMatrixSum;

import java.rmi.MarshalException;

public class LargestSubMatrixSumO3Impl implements LargestSubMatrixSum {
    @Override
    public int largest(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int rowLen = matrix.length;

        int globalMax = Integer.MIN_VALUE;
        for (int bottomRow = 0; bottomRow < rowLen; bottomRow++) {
            for (int topRow = 0; topRow <= bottomRow; topRow++) {
                int[] colSumArray = getColSumArr(matrix, topRow, bottomRow);
                int curMaxSum = maxSubArraySum(colSumArray);
                globalMax = Math.max(globalMax, curMaxSum);
            }
        }
        return globalMax;
    }

    private int[] getColSumArr(int[][] matrix, int topRow, int bottomRow) {
        int colLen = matrix[0].length;
        int[] colSum = new int[colLen];
        for (int row = topRow; row <= bottomRow; row++) {
            for (int col = 0; col < colLen; col++) {
                colSum[col] += matrix[row][col];
            }
        }
        return colSum;
    }

    private int maxSubArraySum(int[] input) {
        int curSum = input[0];
        int globalMax = curSum;
        for (int i = 1; i < input.length; i++) {
            curSum = Math.max(curSum, 0) + input[i];
            globalMax = Math.max(curSum, globalMax);
        }
        return globalMax;
    }
}
