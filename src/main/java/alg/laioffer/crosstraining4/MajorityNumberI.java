package alg.laioffer.crosstraining4;

import java.util.HashMap;
import java.util.Map;

public class MajorityNumberI {
  public int majority(int[] array) {
    Map<Integer, Integer> freqLkUp = new HashMap<>();
    int res = array[0];
    for (Integer cur : array) {
      if (!freqLkUp.containsKey(cur)) {
        freqLkUp.put(cur, 1);
      }
      freqLkUp.put(cur, freqLkUp.get(cur) + 1);
      if (freqLkUp.get(res) < freqLkUp.get(cur)) {
        res = cur;
      }
    }
    return res;
  }

  public int majorityArr(int[] array) {
    /**
     *  1212331
     *
     * c1010121
     *
     * c 1
     * count 0
     */
    int candidate = array[0];
    int count = 1;
    for (int i = 0; i < array.length; i++) {
      if (count == 0) {
        count++;
        candidate = array[i];
      } else if (candidate == array[i]) {
        count++;
      } else {
        count--;
      }
    }
    return candidate;
  }
}
