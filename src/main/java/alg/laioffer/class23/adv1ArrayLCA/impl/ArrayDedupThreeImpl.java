package alg.laioffer.class23.adv1ArrayLCA.impl;

import alg.laioffer.class23.adv1ArrayLCA.ArrayDedupThree;

import java.util.Arrays;

public class ArrayDedupThreeImpl implements ArrayDedupThree {
  /**
   * res = array[0,slow)  // result is NOT including slow
   */
  @Override
  public int[] dedup(int[] array) {
    if (array == null || array.length <= 1) return array;
    int slow = 0;
    int fs = 0;
    int ff = 0;
    for (; ff < array.length; ff++) {
      if (array[ff] != array[fs]) {
        if (ff - fs == 1) {
          array[slow] = array[fs];
          slow++;
        }
        fs = ff;
      }
    }
    if (ff - fs == 1) {
      array[slow] = array[fs];
      slow++;
    }
    return Arrays.copyOf(array, slow);
  }
}
