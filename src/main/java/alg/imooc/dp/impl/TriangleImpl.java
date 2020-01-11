package alg.imooc.dp.impl;

import alg.imooc.dp.Triangle;

import java.util.List;

public class TriangleImpl implements Triangle {
    @Override
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) return 0;
        int rowLen = triangle.size();
        if(rowLen == 1) return triangle.get(0).get(0);
        int[][] M = new int[rowLen][triangle.get(triangle.size() - 1).size()]; // M represents minPathSum to (i, j)

        int res = Integer.MAX_VALUE;
        M[0][0] = triangle.get(0).get(0);
        for(int row = 1; row < rowLen; row++) {
            int colLen = triangle.get(row).size();
            int prevColLen = triangle.get(row - 1).size();
            for(int col = 0; col < colLen; col++) {
                int leftUp = col - 1 >= 0 ? M[row - 1][col - 1] : Integer.MAX_VALUE;
                int rightUp = col < prevColLen ? M[row - 1][col] : Integer.MAX_VALUE;
                M[row][col] = Math.min(rightUp, leftUp) + triangle.get(row).get(col);
                if(row == rowLen-1)  res = Math.min(res, M[row][col]);
            }
        }

        return res;
    }
}
