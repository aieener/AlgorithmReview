package alg.laioffer.crosstraining4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * find more than N / 3
 */
public class MajorityNumberII {
  public List<Integer> majority(int[] array) {
    Map<Integer, Integer> freqLkUp = getNumCount(array);
    return getRes(freqLkUp, array.length);
  }
  private List<Integer> getRes(Map<Integer,Integer> freqLkUp, int len) {
    int threshold = len / 3;
    List<Integer> res = new ArrayList<>();
    for(Map.Entry<Integer, Integer> entry : freqLkUp.entrySet()) {
      if(entry.getValue() > threshold) {
        res.add(entry.getKey());
      }
    }
    return res;
  }

  private Map<Integer, Integer> getNumCount (int[] array) {
    Map<Integer, Integer> numCountLkUp = new HashMap<>();
    for(Integer cur : array) {
      if(!numCountLkUp.containsKey(cur)) {
        numCountLkUp.put(cur,0);
      }
      numCountLkUp.put(cur, numCountLkUp.get(cur) + 1);
    }
    return numCountLkUp;
  }
}
