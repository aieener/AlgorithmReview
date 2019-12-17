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
    if (array == null || array.length == 0) return 0;
    int prevMax = array[0] == 1 ? 1 : 0;
    int res = prevMax;
    for (int i = 1; i < array.length; i++) {
      int curMax = array[i] == 1 ? prevMax + 1 : 0;
      res = Math.max(curMax, res);
      prevMax = curMax;
    }
    return res;
  }
}
