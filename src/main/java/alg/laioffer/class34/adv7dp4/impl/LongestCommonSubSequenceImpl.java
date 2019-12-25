package alg.laioffer.class34.adv7dp4.impl;

import alg.laioffer.class34.adv7dp4.LongestCommonSubsequence;

public class LongestCommonSubSequenceImpl implements LongestCommonSubsequence {
    @Override
    public int longest(String source, String target) {
        int[][] M = new int[source.length() + 1][target.length() + 1];

        for(int i = 1; i < M.length; i++) {
            for(int j = 1; j < M[0].length; j++) {
                if(source.charAt(i - 1) == target.charAt(j - 1)) {
                    M[i][j] = M[i-1][j-1] + 1;
                } else  {
                    M[i][j] = Math.max(M[i-1][j], M[i][j-1]);
                }
            }
        }
        return M[source.length()][target.length()];
    }
}
