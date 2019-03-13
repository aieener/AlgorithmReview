package Class_10_RecurII;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuding on 2/1/18.
 * recur + 2D array
 * The Key point of this one is offset and size
 * Draw the graph to debug!!!
 * THis one is N x N
 */
public class SpiralOrderTraverseI {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int size = matrix.length;

        helper(matrix, res , 0, size);
        return res;
    }

    private void helper(int[][] matrix, List<Integer> res, int offset, int size) {
        //base case
        if (size == 1) {
            // last elem in center
            res.add(matrix[offset][offset]);
            return;
        } else if (size == 0){
            return;
        }

        for(int i = 0; i < size - 1; i++) {
            res.add(matrix[offset][i + offset]);
        }
        for(int i = 0; i < size - 1; i++) {
            res.add(matrix[i + offset][size - 1 + offset]);
        }
        for(int i = size - 1; i >= 1 ; i--) {
            res.add(matrix[size - 1 + offset][i + offset]);
        }
        for(int i = size - 1; i >= 1 ; i--) {
            res.add(matrix[i + offset][offset]);
        }
        // recur Rule
        helper(matrix, res, offset + 1, size - 2);
    }

    public static void main(String[] args) {
        SpiralOrderTraverseI so = new SpiralOrderTraverseI();
//        int [][] input = new int [][]{{1,2,3},{4,5,6},{7,8,9}};
        int [][] input = new int [][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}, {13,14,15,16}};
        /**
         *  1  2  3  4
         *  5  6  7  8
         *  9 10 11 12
         * 13 14 15 16
         *
         * 1 2 3
         * 4 5 6
         * 7 8 9
         *
         */
        List<Integer> res =  so.spiral(input);
        System.out.println(res);
    }
}
