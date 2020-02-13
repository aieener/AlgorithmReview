package alg.oa.microsoftRealOA;

import javax.print.attribute.standard.MediaSize;
import java.util.HashMap;
import java.util.Map;

/*
return the maximum sum of two numbers whose digits add up to an equal sum
if no valid case return -1;
A = [51,71,17,42] --> return 93 (51,42) and (17,71) (5 + 1 = 6 | 4 + 2 = 6)
A = [42,33,60] --> return 102 (42, 60)

  time O(n * logk), where k is the ave len of digit, k = log n
  space O(n)
 */
public class NumWithEqualDigitSum {
  /*
    Assumptions : 1. all values are positive
   */
  public int solution(int[] A) {
    Map<Integer, Integer> lkup = new HashMap<>();
    int res = -1;
    for (Integer val : A) {
      int curDigitSum = digitSum(val);
      if (lkup.containsKey(curDigitSum)) {
        res = Math.max(res, lkup.get(curDigitSum) + val);
        lkup.put(curDigitSum, Math.max(val, lkup.get(curDigitSum)));
      } else {
        lkup.put(curDigitSum, val);
      }
    }
    return res;
  }

  private int digitSum(int val) {
    int res = 0;
    while (val > 0) {
      res += val % 10;
      val /= 10;
    }
    return res;
  }

  public static void main(String[] args) {
    NumWithEqualDigitSum engine = new NumWithEqualDigitSum();
    System.out.println(engine.solution(new int[]{51, 71, 17, 42}));
    System.out.println(engine.solution(new int[]{42, 33, 60}));
    System.out.println(engine.solution(new int[]{51, 32, 43}));
  }
}
