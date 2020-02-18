package alg.oa.microsoftRealOA;

import java.util.Deque;
import java.util.LinkedList;

/*
Lintcode 1337
max possible by inserting '5'
N=268 --> 5268
N=670 --> 6750
N=0 --> 50
N=-999 ---> -5999

单调栈
 */
public class MaxPossibleValue {

  private final int TARGET = 5;

  public int MaximumPossibleValue(int N) {
    if (N == 0) return 50;
    Deque<Integer> stack = new LinkedList<>();
    int absVal = Math.abs(N);
    loadToStack(absVal, stack);

    boolean hasInsert = false;
    int res = 0;
    int sign = N > 0 ? 1 : -1;

    while (!stack.isEmpty()) {
      if (!hasInsert && sign * stack.peek() < sign * TARGET) {
        res = res * 10 + TARGET;
        hasInsert = true;
      } else {
        res = res * 10 + stack.pop();
      }
    }
    if (!hasInsert) {
      res = res * 10 + TARGET;
    }

    return res * sign;
  }

  private void loadToStack(int val, Deque<Integer> stack) {
    while (val > 0) {
      stack.push(val % 10);
      val /= 10;
    }
  }
}
