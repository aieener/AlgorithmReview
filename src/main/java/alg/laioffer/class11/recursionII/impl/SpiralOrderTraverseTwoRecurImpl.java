package alg.laioffer.class11.recursionII.impl;

import alg.laioffer.class11.recursionII.SpiralOrderTraverseTwo;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraverseTwoRecurImpl implements SpiralOrderTraverseTwo {
    @Override
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        recurSpiral(matrix, res, 0, 0, matrix.length, matrix[0].length);
        return res;
    }

    private void recurSpiral(int[][] matrix, List<Integer> res, int rowStart, int colStart, int rowLen, int colLen) {
        // base case
        if (rowLen == 0 || rowLen == 0) {
            return; // nothing left
        } else if (rowLen == 1) {
            for (int i = colStart; i < colStart + colLen; i++) {
                res.add(matrix[rowStart][i]);
            }
            return;
        } else if (colLen == 1) {
            for (int i = rowStart; i < rowStart + rowLen; i++) {
                res.add(matrix[i][colStart]);
            }
            return;
        }

        int rowChunkLen = rowLen - 1;
        int colChunkLen = colLen - 1;
        // lt -> rt
        for (int i = 0; i < colChunkLen; i++) {
            res.add(matrix[rowStart][colStart + i]);
        }
        // rt -> rb
        for (int i = 0; i < rowChunkLen; i++) {
            res.add(matrix[rowStart + i][colStart + colChunkLen]);
        }
        // rb -> lb
        for (int i = colChunkLen; i >= 1; i--) {
            res.add(matrix[rowStart + rowChunkLen][colStart + i]);
        }
        // lb -> lt
        for (int i = rowChunkLen; i >= 1; i--) {
            res.add(matrix[rowStart + i][colStart]);
        }
        recurSpiral(matrix, res, rowStart + 1, colStart + 1, rowLen - 2, colLen - 2);
    }
}
