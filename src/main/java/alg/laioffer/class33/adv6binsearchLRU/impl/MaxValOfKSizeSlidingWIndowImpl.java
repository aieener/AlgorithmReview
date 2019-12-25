package alg.laioffer.class33.adv6binsearchLRU.impl;

import alg.laioffer.class33.adv6binsearchLRU.MaxValOfKSizeSlidingWindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaxValOfKSizeSlidingWIndowImpl implements MaxValOfKSizeSlidingWindow {
  /**
   * 1, 2, 3, 2, 4, 2, 1
   * -------
   * deque: 4 2 1
   * res : 3 3 4 4 4
   */
  @Override
  public List<Integer> maxWindows(int[] array, int k) {
    List<Integer> res = new ArrayList<>();
    Deque<Integer> deque = new LinkedList<>();

    for (int fast = 0; fast < array.length; fast++) {
      while (!deque.isEmpty() && array[deque.peekLast()] <= array[fast]) {
        deque.pollLast();
      }
      if (!deque.isEmpty() && deque.peekFirst() <= fast - k) {
        deque.pollFirst();
      }
      deque.offerLast(fast);
      if (fast >= k - 1) {
        res.add(array[deque.peekFirst()]);
      }
    }
    return res;
  }
}
