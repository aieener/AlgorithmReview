package alg.lintcode.amazon.novVO1;

public class SearchA2DMatrixII {
    public int searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int res = 0;
        int r = rowLen - 1;
        int c = 0;
        while(r >=0 && c < colLen) {
            if(target == matrix[r][c]) {
                res++;
                r--;
                c++;
            } else if (target > matrix[r][c]) {
                c++;
            } else {
                r--;
            }
        }
        return res;
    }
}
