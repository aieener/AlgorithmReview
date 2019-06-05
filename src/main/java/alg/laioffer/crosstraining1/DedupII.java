package alg.laioffer.crosstraining1;

import java.util.Arrays;

public class DedupII {
  /**
   * each val at most two cpy
   * 1 1 1
   *   f
   * s
   */
  public int[] dedup(int[] array) {
    if (array == null || array.length == 0 || array.length == 1) return array;
    int slow = 1;
    for (int f = 2; f < array.length; f++) {
      if(array[f] != array[slow - 1]) {
        array[++slow] = array[f];
      }
    }
    return Arrays.copyOf(array, slow + 1);
  }

  public static void main(String[] args) {
    DedupII dedup = new DedupII();
    int[] input = new int[]{1, 1, 1};
    System.out.println(Arrays.toString(dedup.dedup(input)));
  }
}
