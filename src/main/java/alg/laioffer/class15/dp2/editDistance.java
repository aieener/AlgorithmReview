package alg.laioffer.class15.dp2;

public class editDistance {
    // M[i][j] represents the min number of actions to transform
    // the first i letter of s1 into the first j letters of s2

    /**
     * last review Feb 26 2019
     * Base
     * Induction rule
     */
    public int minDinstance(String word1, String word2) {
        int m = word1.length() + 1;
        int n = word2.length() + 1;
        int [][] M = new int [m][n];
        M[0][0] = 0;
        //init
        for(int i = 1; i < m; i++) {
            M[i][0] = i;
        }
        for(int j = 1; j < n; j++) {
            M[0][j] = j;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    M[i][j] = M[i-1][j-1];
                } else {
                    int add = M[i-1][j] + 1;
                    int del = M[i][j-1] + 1;
                    int edit = M[i-1][j-1] + 1;
                    M[i][j] = Math.min(Math.min(add,del), edit);
                }
            }
        }
        return M[m-1][n-1];
    }
}
