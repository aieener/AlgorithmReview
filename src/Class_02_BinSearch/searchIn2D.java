package Class_02_BinSearch;

/**
 * Created by yuding on 12/18/17.
 */
public class searchIn2D {
    public int[] search(int [][] matrix, int target){
        if(matrix.length == 0 || matrix[0].length == 0){
            return new int[] {-1, -1};
        }

        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int start = 0;
        // last elem idx = (rowLen - 1, colLen - 1);
        int end = colLen - 1 + (rowLen-1) * colLen;

        // the classical BS template
        while(start <= end){
            int mid = start + (end - start)/2;
            int row = mid / (colLen);
            int col = mid % (colLen);
            if(target < matrix[row][col]){
                end = mid - 1;
            } else if (target > matrix[row][col]){
                start = mid + 1;
            } else {
                return new int[] {row, col};
            }
        }

        return new int[] {-1, -1};
    }

    // --- prac ---
    public int[] search2(int[][]matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return new int[] {-1, -1};
        }
        // 1 2 3
        // 4 5 7
        // 8 9 10
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int start = 0;
        int end = rowLen * colLen - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            int row = mid / colLen;
            int col = mid % colLen;
            if(matrix[row][col] < target) {
                start = mid;
            } else if (matrix[row][col] > target){
                end = mid;
            } else {
                return new int[] {row, col};
            }
        }
        int strow = start / colLen;
        int stcol = start % colLen;

        int enrow = end / colLen;
        int encol = end % colLen;
        if(matrix[strow][stcol] == target){
            return new int [] {strow, stcol};
        } else if (matrix[enrow][encol] == target) {
            return new int [] {enrow, encol};
        }
        return new int [] {-1, -1};
    }

}
