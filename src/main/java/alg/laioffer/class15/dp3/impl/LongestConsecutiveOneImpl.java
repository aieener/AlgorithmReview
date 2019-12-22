package alg.laioffer.class15.dp3.impl;

import alg.laioffer.class15.dp3.LongestConsecutiveOnes;

public class LongestConsecutiveOneImpl implements LongestConsecutiveOnes {
  /**
   * 0 1 0 1 1 1 0
   * M[i] = M[i - 1] + 1 if arr[i] == 1
   * = 0 otherwise
   */
  @Override
  public int longest(int[] array) {
    if(array == null || array.length == 0) return 0;
    int globalMax = array[0] == 1 ? 1 : 0;
    int curMaxIncludingCur = globalMax;
    for(int i = 1; i < array.length; i++) {
      if(array[i] == 1) {
        curMaxIncludingCur++;
      } else {
        curMaxIncludingCur = 0;
      }
      globalMax = Math.max(globalMax, curMaxIncludingCur);
    }
    return globalMax;
  }
}
