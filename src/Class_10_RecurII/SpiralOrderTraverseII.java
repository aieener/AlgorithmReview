package Class_10_RecurII;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuding on 2/6/18.
 * This one is M X N
 */
public class SpiralOrderTraverseII {
    public List<Integer> spiral(int [][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // needs 4 pos!
        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = m - 1;

        /** Three cases: 1. there is nothing left
         *               2. there is one column left
         *               3. there is one row left
         *
         *               1  2  3  4
         *               5  6  7  8   ---> one row left
         *               9 10 11 12
         *
         *               1  2  3
         *               4  5  6       ---> nothing left
         *               7  8  9
         *
         *               1  2  3
         *               4  5  6       ---> one col left
         *               7  8  9
         *               10 11 12
         */

        while(left< right && up < down) {
            //--->
            for(int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            // | down
            for(int i = up + 1; i <= down - 1; i++) {
                res.add(matrix[i][right]);
            }
            //<---
            for(int i = right; i >= left; i--) {
                res.add(matrix[down][i]);
            }
            // | up
            for(int i = down - 1; i >= up + 1; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            right--;
            up++;
            down--;
        }

        // nothing left
        if(left > right || up > down) {
            return res;
        }
        // left one col
        if(left == right) {
            for(int i = up; i <= down; i++) {
                res.add(matrix[i][left]);
            }
        } else {
            for(int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
        }
        return res;
    }
}
