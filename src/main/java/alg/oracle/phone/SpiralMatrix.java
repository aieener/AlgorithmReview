package alg.oracle.phone;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList<>();
    if (matrix == null || matrix.length == 0) {
      return res;
    }
    int m = matrix.length;
    int n = matrix[0].length;
    // needs 4 pos!
    int left = 0;
    int right = n - 1;
    int up = 0;
    int down = m - 1;


    while (left < right && up < down) {
      //--->
      for (int i = left; i <= right; i++) {
        res.add(matrix[up][i]);
      }
      // | down
      for (int i = up + 1; i <= down - 1; i++) {
        res.add(matrix[i][right]);
      }
      //<---
      for (int i = right; i >= left; i--) {
        res.add(matrix[down][i]);
      }
      // | up
      for (int i = down - 1; i >= up + 1; i--) {
        res.add(matrix[i][left]);
      }
      left++;
      right--;
      up++;
      down--;
    }

    // nothing left
    if (left > right || up > down) {
      return res;
    }
    if (left == right) {
      // left one col
      for (int i = up; i <= down; i++) {
        res.add(matrix[i][left]);
      }
    } else {
      // left one row
      for (int i = left; i <= right; i++) {
        res.add(matrix[up][i]);
      }
    }
    return res;
  }
}
