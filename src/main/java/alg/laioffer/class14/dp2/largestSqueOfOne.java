package alg.laioffer.class14.dp2;

public class largestSqueOfOne {
    /**
     * pretty much the same as editDistance!!!!!
     * how many squares are there in a n by n matrix?
     * n^3 , why? 1^2 + 2^2 + 3^2 + ... + n^2 --> n(n+1)(2n+1) / 6 --> O(n^3)
     *
     * M[i][j] represents the max size of the square with (i,j) as
     * its bottom right corner
     * Base case:
     * M[0][0] = 0;
     * M[0][j] = 0;
     * M[i][0] = 0;
     *
     * induction rule:
     * M[i][j] = 0   if A[i][j] == 0;
     *          min(M[i-1][j-1], M[i][j-1], M[i-1][j]) + 1
     */
    public int largest(int[][] matrix) {
        int [][] M = new int[matrix.length][matrix[0].length];
        // base case init
        M[0][0] = matrix[0][0];
        int globalMax = M[0][0];
        for(int i = 1; i < matrix.length; i++){
            if(matrix[i][0] == 1) {
                M[i][0] = 1;
                globalMax = 1;
            } else {
                M[i][0] = 0;
            }
        }

        for(int j = 1; j < matrix[0].length; j++){
            if(matrix[0][j] == 1) {
                M[0][j] = 1;
                globalMax = 1;
            } else {
                M[0][j] = 0;
            }
        }

        for(int i = 1; i< matrix.length; i++) {
            for(int j = 1; j<matrix[0].length; j++) {
                if(matrix[i][j] == 1) {
                    int up = M[i-1][j];
                    int left = M[i][j-1];
                    int leftUp = M[i-1][j-1];
                    int prev = Math.min(leftUp, Math.min(up, left));
                    M[i][j] = prev + 1;
                    globalMax = Math.max(M[i][j], globalMax);
                } else {
                    M[i][j] = 0;
                }
            }
        }
        return globalMax;
    }

    /**
     * LaiOffer's Sol
     */
    public int largestLai(int[][] matrix) {
        int N = matrix.length;
        if (N == 0) {
            return 0;
        }
        int res = 0;
        int[][] largest = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i==0 || j == 0) {
                    largest[i][j] = matrix[i][j] == 1? 1: 0;
                } else if (matrix[i][j] == 1) {
                    largest[i][j] = Math.max(largest[i][j - 1] + 1, largest[i-1][j] + 1);
                    largest[i][j] = Math.max(largest[i- 1][j - 1] + 1, largest[i][j]);
                }
                res = Math.max(res, largest[i][j]);
            }
        }
        return res;
    }
}
