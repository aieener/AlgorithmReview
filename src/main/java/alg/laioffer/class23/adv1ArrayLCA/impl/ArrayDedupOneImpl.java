package alg.laioffer.class23.adv1ArrayLCA.impl;

import alg.laioffer.class23.adv1ArrayLCA.ArrayDedupOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayDedupOneImpl implements ArrayDedupOne {
  @Override
  public int[] dedup(int[] array) {
    if (array == null || array.length <= 1) return array;
    int slow = 0;
    int fast = 1;
    for (; fast < array.length; fast++) {
      if (array[fast] != array[slow]) {
        slow++;
        array[slow] = array[fast];
      }
    }
    return Arrays.copyOf(array, slow + 1);
//    return Arrays.copyOfRange(array, 0, slow + 1);
  }
}
