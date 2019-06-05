package alg.laioffer.crosstraining1;

import java.util.Arrays;

public class DeDupIV {
  /**
   * Unsorted, repeatedly remove dups
   * 0 1 2 3 4 5 6 7
   * 1 2 3 3 3 3 2 2
   * s
   *               f
   * <p>
   * using the left part of the array as stack
   */
  public int[] dedup(int[] array) {
    int end = -1; // stack goes to empty
    for (int i = 0; i < array.length; i++) {
      if (end == -1 || array[end] != array[i]) {
        array[++end] = array[i];
      } else {
        while (i + 1 < array.length && array[i + 1] == array[end]) {
          i++;
        }
        end--;
      }
    }
    return Arrays.copyOf(array, end + 1);
  }

  public static void main(String[] args) {
    DeDupIV dedup = new DeDupIV();
    int[] input = new int[]{1, 2, 3, 3, 3, 3, 2, 2};
    System.out.println(Arrays.toString(dedup.dedup(input)));
  }
}
