package alg.oa.microsoftRealOA;

/*
same as LongestSubstringWithout3ContiguousOccurLetter
semiAlter: not contain three identical consecutive ch
S = "baaabbabbb" --> return 7 "aabbabb"
S = "babba" --> return 5
S = "abaaa" --> return 4 "abaa"
 */
public class LongestSemiAlternatingSubstring {
  public int getLongestSemiAlterSubstring(String s) {
    if (s.length() < 3) return s.length();
    int start = 0;// including start
    int end = 0; // including end
    int counter = 1;
    int maxLen = 1;

    char prev = s.charAt(0);
    for (; end < s.length(); end++) {
      if (s.charAt(end) == prev) {
        //repeat, increment counter
        counter++;
        if (counter < 3) {
          // update max
          if (end - start + 1 > maxLen) {
            maxLen = end - start + 1;
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
        }
      }
    }
    return maxLen;
  }

  public static void main(String[] args) {
    LongestSemiAlternatingSubstring engine = new LongestSemiAlternatingSubstring();
    System.out.println(engine.getLongestSemiAlterSubstring("abaaa"));
    System.out.println(engine.getLongestSemiAlterSubstring("baaabbabbb"));
    System.out.println(engine.getLongestSemiAlterSubstring("babba"));
  }
}
