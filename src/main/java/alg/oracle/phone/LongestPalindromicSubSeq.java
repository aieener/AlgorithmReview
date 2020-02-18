package alg.oracle.phone;

/*
leetcode 516
 */
public class LongestPalindromicSubSeq {
  public int longestPalindromeSubseq(String s) {
    int[][] M = new int[s.length()][s.length()];
    // M[i][j] represents lps for s.substring(i, j + 1);
    // base case M[i][i] = 1;
    for (int i = 0; i < s.length(); i++) {
      M[i][i] = 1;
    }
    // induction rule: M[i][j] = M[i+1][j-1] + 2 if s[i] == s[j];
    //                  M[i][j] = Math.max(M[i + 1][j], M[i][j-1]);
    for (int len = 2; len <= s.length(); len++) {
      for (int start = 0; start + len - 1 < s.length(); start++) {
        int end = start + len - 1;
        if (s.charAt(start) == s.charAt(end)) {
          M[start][end] = M[start + 1][end - 1] + 2;
        } else {
          M[start][end] = Math.max(M[start + 1][end], M[start][end - 1]);
        }
      }
    }
    return M[0][s.length() - 1];
  }
}
