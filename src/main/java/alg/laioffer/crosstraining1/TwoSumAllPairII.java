package alg.laioffer.crosstraining1;

import java.util.*;

public class TwoSumAllPairII {
  /**
   * return all distinct pairs of values
   */
  public List<List<Integer>> allPairs(int[] array, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Set<Integer> valSet = new HashSet<>();
    Set<Integer> diffSet = new HashSet<>();
    for (int i = 0; i < array.length; i++) {
      if(diffSet.contains( target - array[i]) && !valSet.contains(array[i])) {
        res.add(Arrays.asList(target - array[i], array[i]));
        valSet.add(array[i]);
        valSet.add(target - array[i]);
      }
      diffSet.add(array[i]);
    }
    return res;
  }
}
