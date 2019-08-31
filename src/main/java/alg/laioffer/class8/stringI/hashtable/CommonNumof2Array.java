package alg.laioffer.class8.stringI.hashtable;

import java.util.*;


public class CommonNumof2Array {
  public List<Integer> common(List<Integer> A, List<Integer> B) {
    int aPtr = 0;
    int bPtr = 0;
    List<Integer> res = new ArrayList<>();
    while (aPtr < A.size() && bPtr < B.size()) {
      Integer curA = A.get(aPtr);
      Integer curB = B.get(bPtr);
      if (curA.compareTo(curB) == 0) {
        res.add(curA);
        aPtr++;
        bPtr++;
      } else if (curA.compareTo(curB) < 0) {
        aPtr++;
      } else {
        bPtr++;
      }
    }
    return res;
  }
}


