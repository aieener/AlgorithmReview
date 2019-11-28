package alg.leetcode.dp.impl;

import alg.leetcode.dp.RegularExMatching;

/**
 * M[i][j] stands for s.substring(0, i) matches p.substring(0,j);
 * base case:
 * M[0][0] = true;
 * M[k][0] = false; where k > 0;
 * M[0][l] = p.charAt(l-1) == '*' && M[0][l-2] ;
 * induction rule:
 * if s.charAt(i-1) == p.charAt(j - 1) || p.charAt(j-1) == '.'
 * M[i][j] = M[i-1][j-1]
 * if p.charAt(j-1) == '*';
 * M[i][j] = M[i][j-2] (x* act as empty set)|| (M[i-1][j] && s.charAt(i - 1) == p.charAt(j-2) || . (x is repeating in s)
 * else
 * M[i][j] = false;
 */
public class RegularExMatchingImpl implements RegularExMatching {
    @Override
    public boolean isMatch(String s, String p) {
        boolean[][] M = new boolean[s.length() + 1][p.length() + 1];
        M[0][0] = true; // M[k > 0][0] is default to false
        // base case
        for (int j = 2; j <= p.length(); j++) {
            M[0][j] = p.charAt(j - 1) == '*' && M[0][j - 2];
        }

        // fill M
        for (int row = 1; row < s.length() + 1; row++) {
            for (int col = 1; col < p.length() + 1; col++) {
                if (matchChar(s, p, row - 1, col - 1)) {
                    M[row][col] = M[row - 1][col - 1];
                } else if (p.charAt(col - 1) == '*') {
                    M[row][col] = M[row][col - 2] || (M[row - 1][col] && matchChar(s, p, row - 1, col - 2));
                }
            }
        }
        return M[s.length()][p.length()];
    }

    private boolean matchChar(String s, String p, int i, int j) {
        return s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';
    }
}
