package alg.laioffer.crosstraining3;

import java.util.*;

/**
 * there are dups
 */
public class CommonNumOfTwoArrII {
  public List<Integer> common(List<Integer> a, List<Integer> b) {
    Map<Integer, Integer> valLkUp = buildValMap(a);
    Queue<Integer> minHeap = new PriorityQueue<>();
    for(Integer val : b) {
      if (valLkUp.containsKey(val) && valLkUp.get(val) > 0) {
        minHeap.offer(val);
        valLkUp.put(val, valLkUp.get(val) - 1);
      }
    }
    List<Integer> res = new ArrayList<>();
    while(!minHeap.isEmpty()) {
      res.add(minHeap.poll());
    }
    return res;
  }

  private Map<Integer, Integer> buildValMap(List<Integer> a) {
    Map<Integer, Integer> valLkUp = new HashMap<>();
    for(Integer val : a) {
      if(!valLkUp.containsKey(val)) {
        valLkUp.put(val, 0);
      }
      valLkUp.put(val, valLkUp.get(val) + 1);
    }
    return valLkUp;
  }


}
