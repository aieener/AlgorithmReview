package alg.oa.microsoftRealOA;

import java.util.HashMap;
import java.util.Map;

/*
Given a string s containing only a and b, find longest substring of s such that s does not contain more than two contiguous occurrences of a and b.

Example 1:

Input: "aabbaaaaabb"
Output: "aabbaa"
Example 2:

Input: "aabbaabbaabbaa"
Output: "aabbaabbaabbaa

// sliding window
Time O(n)
Space O(1)
 */
public class LongestSubstringWithout3ContiguousOccurLetter {
  public String validLongestSubstring(String s) {
    if (s.length() < 3) return s;
    int start = 0;// including start
    int end = 0; // including end
    int counter = 1;
    int maxLen = 1;
    int maxStart = 0;

    char prev = s.charAt(0);
    for (; end < s.length(); end++) {
      if (s.charAt(end) == prev) {
        //repeat, increment counter
        counter++;
        if (counter < 3) {
          // update max
          if (end - start + 1 > maxLen) {
            maxLen = end - start + 1;
            maxStart = start;
          }
        } else {
          // invalid substring, move start to end - 1
          start = end - 1;
        }
      } else {
        // non repeat, renew prev and counter
        prev = s.charAt(end);
        counter = 1;
        if (end - start + 1 > maxLen) {
          // update max
          maxLen = end - start + 1;
          maxStart = start;
        }
      }
    }
    return s.substring(maxStart, maxStart + maxLen);
  }

  public static void main(String[] args) {
    LongestSubstringWithout3ContiguousOccurLetter engine = new LongestSubstringWithout3ContiguousOccurLetter();
    System.out.println(engine.validLongestSubstring("aabbaabaaabb"));
    System.out.println(engine.validLongestSubstring("aabbaabbaabbaa"));
  }
}
