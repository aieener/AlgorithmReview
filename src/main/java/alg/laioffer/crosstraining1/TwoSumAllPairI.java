package alg.laioffer.crosstraining1;

import java.util.*;

public class TwoSumAllPairI {
  public List<List<Integer>> allPairs(int[] array, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Map<Integer, List<Integer>> diffIndexMap = new HashMap<>();
    for(int i = 0; i < array.length; i++) {
      if(diffIndexMap.containsKey(array[i])) {
        List<Integer> idxs = diffIndexMap.get(array[i]);
        for(Integer idx : idxs) {
          res.add(Arrays.asList(idx, i));
        }
      }
      if(!diffIndexMap.containsKey(target - array[i])) {
        diffIndexMap.put(target - array[i], new ArrayList<>());
      }
      diffIndexMap.get(target - array[i]).add(i);
    }
    return res;
  }
}
