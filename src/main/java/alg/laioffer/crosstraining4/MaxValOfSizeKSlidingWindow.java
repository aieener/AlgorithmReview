package alg.laioffer.crosstraining4;

import java.util.*;

public class MaxValOfSizeKSlidingWindow {
  public List<Integer> maxWindows(int[] array, int k) {
    List<Integer> res = new ArrayList<>();
    Deque<Integer> deque = new LinkedList<>(); // store index
    // for any idx, the previous idx with smaller value is descared from the queue
    for(int i = 0; i < array.length; i++) {
      while(!deque.isEmpty() && array[i] >= array[deque.peekLast()]) {
        deque.pollLast();
      }
      if(!deque.isEmpty() && deque.peekFirst() <= i - k){
        deque.pollFirst();
      }
      deque.offerLast(i);
      if(i >= k -1) {
        res.add(array[deque.peekFirst()]);
      }
    }
    return res;
  }
}
