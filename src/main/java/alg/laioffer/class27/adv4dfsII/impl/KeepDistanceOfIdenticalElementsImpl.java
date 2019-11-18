package alg.laioffer.class27.adv4dfsII.impl;

import alg.laioffer.class27.adv4dfsII.KeepDistanceForIndenticalElements;

import java.util.Arrays;

/**
 * 参考 Piazza https://piazza.com/class/j0eqhhdregb3i?cid=827
 * Space: O(k)
 * Time: O(2k!) upper bound, but will be better
 */
public class KeepDistanceOfIdenticalElementsImpl implements KeepDistanceForIndenticalElements {
  public static void main(String[] args) {
    KeepDistanceForIndenticalElements engine = new KeepDistanceOfIdenticalElementsImpl();
    System.out.println(Arrays.toString(engine.keepDistance(7)));
  }

  @Override
  public int[] keepDistance(int k) {
    int[] array = new int[2 * k];
    int[] result = new int[2 * k];
    Arrays.fill(array, 0);
    helper(array, k, 2 * k, result); // number is filling from big to small: K, K-1, K-2,...., 1
    return isValid(result, 2 * k) ? result : null;
  }

  private void helper(int[] array, int curNumber, int len, int[] result) {
    if (curNumber == 0) {
      // base case
      if (isValid(array, len)) {
        for (int i = 0; i < len; i++) {
          result[i] = array[i];
        }
      }
      return;
    }

    int spaceNeededAfter = curNumber + 1;
    for (int i = 0; i < len - spaceNeededAfter; i++) {
      if (array[i] == 0 && array[i + spaceNeededAfter] == 0) { // not filled yet
        array[i] = curNumber;
        array[i + spaceNeededAfter] = curNumber;
        helper(array, curNumber - 1, len, result);
        array[i] = 0;
        array[i + spaceNeededAfter] = 0;
      }
    }
  }

  private boolean isValid(int[] array, int len) {
    for (int i = 0; i < len; i++) {
      if (array[i] == 0) {
        return false;
      }
    }
    return true;
  }
}
