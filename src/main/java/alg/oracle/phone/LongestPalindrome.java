package alg.oracle.phone;

import java.util.HashMap;
import java.util.Map;

/*
leetcode 409 easy
 */
public class LongestPalindrome {
  public int longestPalindrome(String s) {
    int res = 0;
    Map<Character, Integer> freqLkup = new HashMap<>();
    for (Character ch : s.toCharArray()) {
      freqLkup.put(ch, freqLkup.getOrDefault(ch, 0) + 1);
    }
    boolean remain = false;
    for (Map.Entry<Character, Integer> entry : freqLkup.entrySet()) {
      if (entry.getValue() % 2 == 0) res += entry.getValue();
      else {
        res += entry.getValue() - 1;
        remain = true;
      }
    }
    if (remain) return res + 1;
    return res;
  }
}
