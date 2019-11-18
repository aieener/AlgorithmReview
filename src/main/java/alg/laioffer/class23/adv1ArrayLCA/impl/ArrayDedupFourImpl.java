package alg.laioffer.class23.adv1ArrayLCA.impl;

import alg.laioffer.class23.adv1ArrayLCA.ArrayDedupFour;

import java.util.Arrays;

/**
 * simulate stack within Arr
 */
public class ArrayDedupFourImpl implements ArrayDedupFour {
  @Override
  public int[] dedup(int[] array) {
    int slow = -1;
    int fast = 0;
    for (; fast < array.length; fast++) {
      if (slow == -1 || array[fast] != array[slow]) {
        slow++;
        array[slow] = array[fast];
      } else {
        while (fast + 1 < array.length && array[fast + 1] == array[slow]) {
          fast++;
        }
        slow--;
      }
    }
    return Arrays.copyOf(array, slow + 1);
  }
}
