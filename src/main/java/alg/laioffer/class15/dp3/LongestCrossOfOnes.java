package alg.laioffer.class15.dp3;

public class LongestCrossOfOnes {
    /**
     * fake 2D DP
     * check LaiOffer's Sol!
     * for each direction, we run for LongCOne
     */
    public int largest(int[][] matrix) {
        // Write your solution here
        if(matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] Mup_Down  =new int[m][n];
        int [][] Mdown_Up  =new int[m][n];
        int [][] Mleft_Right  =new int[m][n];
        int [][] Mright_Left  =new int[m][n];

        // up - down
        for(int i = 0; i < n; i++) {
            if(matrix[0][i] == 1){
                Mup_Down[0][i] = 1;
            } else {
                Mup_Down[0][i] = 0;
            }
            for(int j = 1; j < m; j++) {
                if(matrix[j][i] == 1){
                    Mup_Down[j][i] = Mup_Down[j][i-1] + 1;
                } else {
                    Mup_Down[j][i] = 0;
                }
            }
        }
        // down up
        for(int i = 0; i < n; i++) {
            if(matrix[n-1][i] == 1){
                Mdown_Up[m-1][i] = 1;
            } else {
                Mdown_Up[m-1][i] = 0;
            }
            for(int j = m-2; j >=0 ; j--) {
                if(matrix[j][i] == 1){
                    Mdown_Up[j][i] = Mdown_Up[j][i+1] + 1;
                } else {
                    Mdown_Up[j][i] = 0;
                }
            }
        }
        // left - right
        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 1){
                Mleft_Right[i][0] = 1;
            } else {
                Mleft_Right[i][0] = 0;
            }
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 1){
                    Mleft_Right[i][j] = Mleft_Right[i][j-1] + 1;
                } else {
                    Mleft_Right[i][j] = 0;
                }
            }
        }

        // right - left
        for(int i = 0; i < m; i++) {
            if(matrix[i][n-1] == 1){
                Mright_Left[i][n-1] = 1;
            } else {
                Mright_Left[i][n-1] = 0;
            }
            for(int j = n-2; j >=0 ; j--) {
                if(matrix[i][j] == 1){
                    Mright_Left[i][j] = Mright_Left[i][j+1] + 1;
                } else {
                    Mright_Left[i][j] = 0;
                }
            }
        }

        int [][] M = new int[m][n];
        int res = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j< n; j++) {
                M[i][j] = Math.min(Mleft_Right[i][j], Mright_Left[i][j]);
                M[i][j] = Math.min(M[i][j], Mup_Down[i][j]);
                M[i][j] = Math.min(M[i][j], Mdown_Up[i][j]);
                res = Math.max(M[i][j],res);
            }
        }
        return res;
    }

}
