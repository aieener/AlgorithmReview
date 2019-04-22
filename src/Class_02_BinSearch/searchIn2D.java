package Class_02_BinSearch;

/**
 * Created by yuding on 12/18/17.
 */
public class searchIn2D {
  public int[] search(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) {
      return new int[]{-1, -1};
    }
    // first find row
    int start = 0;
    int end = matrix.length - 1;
    while (start + 1< end) {
      int mid = start + (end - start) / 2;
      int curMidValue = matrix[mid][0];
      if (target == curMidValue) {
        return new int[]{mid, 0};
      } else if (target < curMidValue) {
        end = mid;
      } else {
        start = mid;
      }
    }
    // start is at the left of end

    int resRow = target > matrix[end][0] ? end : start;

    // then search on that row,
    start = 0;
    end = matrix[resRow].length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      int curMidValue = matrix[resRow][mid];
      if (target == curMidValue) {
        return new int [] {resRow, mid};
      } else if (target < curMidValue) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return new int[] {-1, -1};
  }
}
