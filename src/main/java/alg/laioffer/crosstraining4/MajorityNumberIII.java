package alg.laioffer.crosstraining4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * find more than N / k
 */
public class MajorityNumberIII {
  public List<Integer> majority(int[] array, int k) {
    Map<Integer, Integer> freqLkup = getNumCount(array);
    return getRes(array.length / k, freqLkup);
  }

  private List<Integer> getRes(int threshold,  Map<Integer, Integer> freqLkup) {
    List<Integer> res = new ArrayList<>();
    for(Map.Entry<Integer, Integer> entry : freqLkup.entrySet()) {
      if(entry.getValue() > threshold) {
        res.add(entry.getKey());
      }
    }
    return res;
  }

  private Map<Integer, Integer> getNumCount(int[] array) {
    Map<Integer, Integer> numCountLkUp = new HashMap<>();
    for (Integer cur : array) {
      if (!numCountLkUp.containsKey(cur)) {
        numCountLkUp.put(cur, 0);
      }
      numCountLkUp.put(cur, numCountLkUp.get(cur) + 1);
    }
    return numCountLkUp;
  }
}
