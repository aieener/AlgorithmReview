package alg.oa.microsoftRealOA;

/*
return maximum num of letters'a' that can be inserted and won't contain 3 consecutive as
 */
public class MaxInsertToObtainStringWithout3SonsecutiveA {
  public int maxInsert(String s) {
    int res = 0;
    int aCounter = 0;
    for (int i = 0; i < s.length(); i++) {
      while (i < s.length() && s.charAt(i) == 'a') {
        aCounter++;
        i++;
      }
      if (aCounter >= 3) {
        return -1; // invalid
      } else if (i < s.length()) {
        res += 2 - aCounter;
        aCounter = 0;
      }
    }
    if (s.charAt(s.length() - 1) != 'a') {
      res += 2;
    } else {
      res += 2 - aCounter;
    }
    return res;
  }

  public static void main(String[] args) {
    MaxInsertToObtainStringWithout3SonsecutiveA engine = new MaxInsertToObtainStringWithout3SonsecutiveA();
    String s1 = "aabab"; //aabaabaa 3
    String s2 = "dog"; // aadaaoaagaa 8
    String s3 = "aa"; // aa 0
    String s4 = "baaaa"; // -1
    String s5 = "aaba"; // aabaa 1
    System.out.println(engine.maxInsert(s1));
    System.out.println(engine.maxInsert(s2));
    System.out.println(engine.maxInsert(s3));
    System.out.println(engine.maxInsert(s4));
    System.out.println(engine.maxInsert(s5));
  }
}
