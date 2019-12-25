package alg.laioffer.class34.adv7dp4.impl;

import alg.laioffer.class34.adv7dp4.LongestCommonSubString;

public class LongestCommonSubStringImpl implements LongestCommonSubString {
  /**
   * Class 34 Tang
   */
  public String longestCommon(String source, String target) {
    char[] sa = source.toCharArray();
    char[] ta = target.toCharArray();
    /**
     * M[i][j] represents longest for source[0,i] target[0,j]'s longest common len (including i and j)
     * M[i][j] = M[i-1][j-1] + 1           if s[i] == t[j]
     *         = 0                         otherwise
     */

    int start = 0;
    int longest = 0;
    int[][] M = new int[source.length()][target.length()];
    for (int i = 0; i < sa.length; i++) {
      for (int j = 0; j < ta.length; j++) {
        if (sa[i] == ta[j]) {
          if (i == 0 || j == 0) {
            M[i][j] = 1;
          } else {
            M[i][j] = M[i - 1][j - 1] + 1;
          }
        }
        if (M[i][j] > longest) {
          longest = M[i][j];
          start = i - longest + 1;
        }
      }
    }
    return source.substring(start, start + longest);
  }
}
