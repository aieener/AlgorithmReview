package alg.laioffer.crosstraining3;

import java.util.*;

/**
 * return common number in increasing order
 * no dups
 */
public class CommonNumOfTwoArr {
  public List<Integer> common(List<Integer> a, List<Integer> b) {
    Set<Integer> aVals = new HashSet<>();
    aVals.addAll(a);
    Queue<Integer> minHeap = new PriorityQueue<>();
    for(Integer val : b) {
      if(aVals.contains(val)) minHeap.offer(val);
    }
    List<Integer> result = new ArrayList<>();
    while(!minHeap.isEmpty()){
      result.add(minHeap.poll());
    }
    return result;
  }
}
