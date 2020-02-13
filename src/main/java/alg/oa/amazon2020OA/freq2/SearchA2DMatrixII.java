package alg.oa.amazon2020OA.freq2;

/*
leetcode 240
bfs2
 */
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        // search from left bottom
        int r = rowLen - 1;
        int c = 0;
        while (r >= 0 && c < colLen) {
            if (matrix[r][c] < target) {
                c++;
            } else if (matrix[r][c] > target) {
                r--;
            } else {
                return true;
            }
        }
        return false;
    }
}
