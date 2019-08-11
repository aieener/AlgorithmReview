package alg.laioffer.crosstraining3;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleInHistogram {
  // use a stack
  // linear scan, hui tou kan
  public int largest(int[] array) {
    int res = 0;
    Deque<Integer> stack = new LinkedList<>(); // stack store the idx!
    for (int i = 0; i <= array.length; i++) {
      int cur = i == array.length ? 0 : array[i];
      while (!stack.isEmpty() && array[stack.peekFirst()] > cur) {
        int height = array[stack.pollFirst()];
        int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
        res = Math.max(res, height * (i - left));
      }
      stack.offerFirst(i);
    }
    return res;
  }
}
