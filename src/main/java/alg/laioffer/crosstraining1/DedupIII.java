package alg.laioffer.crosstraining1;

import java.util.Arrays;

public class DedupIII {
  /**
   * don't keep any of the repeated key
   * 2 1 2 3 3 4 5 5 5
   * s
   * m
   * f
   */
  public int[] dedup(int[] array) {
    if (array == null || array.length == 1) return array;
    int slow = 0;
    int mid = 0;
    for (int fast = 0; fast < array.length; fast++) {
      if (array[mid] == array[fast]) continue;
      if (fast - mid == 1) {
        array[slow] = array[mid];
        slow++;
      }
      mid = fast;
    }
    if (array[array.length - 1] != array[array.length - 2]) {
      array[slow] = array[mid];
      slow++;
    }
    return Arrays.copyOf(array,  slow);
  }

  public static void main(String[] args) {
    DedupIII dedup = new DedupIII();
    int[] input = new int[]{1, 1, 2, 3, 3, 4, 5, 5, 5};
    int[] input2 = new int[]{1, 1, 2, 2, 2, 3};
    System.out.println(Arrays.toString(dedup.dedup(input)));
  }
}
