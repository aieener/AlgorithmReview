package alg.laioffer.class23.adv1ArrayLCA.impl;

import alg.laioffer.class23.adv1ArrayLCA.ArrayDedupTwo;

import java.util.Arrays;

public class ArrayDedupTwoImpl implements ArrayDedupTwo {
  @Override
  public int[] dedup(int[] array) {
    if (array == null || array.length <= 2) return array;
    int slow = 1;
    int fast = 2;
    for (; fast < array.length; fast++) {
      if (array[fast] != array[slow - 1]) {
        slow++;
        array[slow] = array[fast];
      }
    }
    return Arrays.copyOf(array, slow + 1);
  }
}
