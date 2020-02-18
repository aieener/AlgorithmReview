package alg.oa.microsoftRealOA;

/*
give string only contains ABs
return min del to make it in format A...AB...B
S = BAAABAB --> 2
S = BBABAA  --> 3
S = AABBBB --> 0
 */
public class MinDeletionToMakeABConsecutive {
  public static void main(String[] args) {
    String s1 = "BAAABAB";
    String s2 = "BBABAA";
    String s3 = "AABBBB";
    System.out.println(minDelete(s1));
    System.out.println(minDelete(s2));
    System.out.println(minDelete(s3));
  }

  private static int minDelete(String s) {
    int cntA = 0, cntB = 0, cntRemove = 0;
    // remove all A to make Bs
    // remove all B to make As
    // remove A and B to make A..AB..B
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == 'A') {
        cntA++;
        if (cntB > cntRemove) { // AABA, has to remove this A, so cntRemove++
          // remove A
          cntRemove++;
        }
      } else {
        cntB++;
        if (cntA == 0) { // not seen A yet, so if saw one, we have to remove all B before A, so cntRemove++
          // remove B
          cntRemove++;
        }
      }
    }
    return Math.min(cntA, Math.min(cntB, cntRemove));
  }
}
