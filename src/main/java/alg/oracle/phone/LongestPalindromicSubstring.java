package alg.oracle.phone;

/*
leetcode 5
 */
public class LongestPalindromicSubstring {
  // DP sol
  public String longestPalindrome(String s) {
    if (s == null || s.length() == 0) return s;
    int resStart = 0;
    int resEnd = 0;
    char[] input = s.toCharArray();
    boolean[][] M = new boolean[s.length()][s.length()];
    // M[i][j] represents s.substring(i, j + 1) is palindrome
    // base case: len = 1, and len = 2
    // M[i][i] = true; and M[i][i+1] == s.charAt(i)== s.charAt(i+1);
    // induction rule: M[i][j] = s[i] == s[j] && M[i+1][j-1]; // look at down and left

    for (int i = 0; i < s.length(); i++) {
      M[i][i] = true;
      if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
        M[i][i + 1] = true;
        resStart = i;
        resEnd = i + 1;
      }
    }

    for (int len = 3; len <= s.length(); len++) {
      for (int start = 0; start + len - 1 < s.length(); start++) {
        int end = start + len - 1;
        M[start][end] = s.charAt(start) == s.charAt(end) && M[start + 1][end - 1];
        int resLen = resEnd - resStart + 1;
        if (M[start][end] && len > resLen) {
          resStart = start;
          resEnd = end;
        }
      }
    }
    return s.substring(resStart, resEnd + 1);
  }

  // 中心开花，non-DP
  public String longestPalindromeNonDP(String s) {
    if (s == null || s.length() == 0) return s;
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
      int len1 = expandAroundCenter(s, i, i);
      int len2 = expandAroundCenter(s, i, i + 1);
      int len = Math.max(len1, len2);
      if (len > end - start) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
      }
    }
    return s.substring(start, end + 1);
  }

  private int expandAroundCenter(String s, int left, int right) {
    int L = left, R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
      L--;
      R++;
    }
    return R - L - 1;
  }

}
