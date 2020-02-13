package alg.oa.microsoftRealOA;

/*
  S = "baaaaa" return 1 --> "baabaa"
  S = "baaabbaabbba" return 2 --> "bbaabbaabbaa"
  S = "baabab" return 0
 */
public class MinMoveToMakeStringWithout3IdenticalConsecutiveLetters {

  // baaab --> babab
  // baaaab --> babaab
  // baaaaab --> baabaab
  // baaaaaab --> baababab
  // ...

  public int minMove(String s) {
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
      int chunkLen = 1;
      while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
        chunkLen++;
        i++;
      }
      res += chunkLen / 3;
    }
    return res;
  }
}
