package alg.laioffer.class9.stringII;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStrNoReapt {
  public static void main(String[] args) {
    LongestSubStrNoReapt ls = new LongestSubStrNoReapt();
    String input = "abcdacef";
    int out = ls.longest(input);
    System.out.println(out);
  }

  /**
   * This one is very tricky !
   * A Classical Sliding Window Prob
   * Using sliding window!!
   * <p>
   * Last review April 14 2019
   */
  public int longest(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    // sliding window
    int l = 0;
    int r = 0;
    int res = 0;
    Set<Character> set = new HashSet<>();
    while (r < s.length()) {
      if (!set.contains(s.charAt(r))) {
        set.add(s.charAt(r));
        r++;
        res = Math.max(res, r - l);
      } else {
        set.remove(s.charAt(l));
        l++;
      }
    }
    return res;
  }
}
