package alg.penn.bloomberg;

/**
 * Created by yuding on 2/12/18.
 * LeetCode 62 -----> Compare to LaiOffer's Edit Distance!
 * lt seems to me that this one is DFS or BFS
 * But this one is actually a CLASSICAL 2D DP problem!
 * easist 2d DP!!!!!!!!!!
 */
public class uniquePaths {
    /**
     * DFS version
     * Time complexity is huge...
     * O(2^(m+n)) --> BAD!!
     */

    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) {
            return 0;
        }
        boolean [][] mat = new boolean[m][n];

        int[] res = new int[1];
        helper(mat, 0, 0, res);

        return res[0];
    }

    private void helper(boolean[][] mat, int r, int c, int[] res) {
        // base case
        if(mat[r][c]){
            return;
        } else if(r == mat.length -1 && c == mat[0].length - 1) {
            res[0]++;
            return;
        }
        mat[r][c] = true;
        // go down
        if(r + 1 <= mat.length - 1) {
            helper(mat, r + 1 , c , res);
        }

        // go right
        if(c + 1 <= mat[0].length - 1) {
            helper(mat, r , c + 1 , res);
        }
        mat[r][c] = false;
        return;
    }

    /**
     * DP version
     * 2D DP
     * M[i][j] stands for the number of ways to approach i,j
     * 0 1 1 1
     * 1 2 3 4
     * 1 3 6 10
     * 1 4 10 20
     *
     * Time = O(m*n)
     */
    public int uniquePathsDp(int m, int n) {
        if(m == 0 || n == 0) {
            return 1;
        }
        int[][] sum = new int[m][n];
        sum[0][0] = 0;
        for(int i = 1; i < m; i++) {
            sum[i][0] = 1;
            sum[i][0] = 1;
        }

        for(int i = 1; i < n; i++) {
            sum[0][i] = 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1];
            }
        }
        return sum[m-1][n-1];
    }

    public static void main(String[] args) {
        uniquePaths up = new uniquePaths();
        System.out.println(up.uniquePaths(10,12));
        System.out.println(up.uniquePathsDp(10,12));
    }



    // ------------------ prac -----------
    public int uniquePaths4(int m, int n) {
        if(m == 0 || n == 0) {
            return 1;
        }
        int [][] M = new int[m][n];
        // initialize
        for(int i = 0; i < m; i++) {
            M[i][0] = 1;
        }
        for(int j = 0; j < n; j++) {
            M[0][j] = 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                M[i][j] = M[i-1][j] + M[i][j-1];
            }
        }
        return M[m-1][n-1];
    }
}
