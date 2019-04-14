package Class_08_StringII;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReorderArray {
  /**
   * Need to Revisit!!! very very good string hard problem!!!!
   * lase visit April 14 2019, took more than an hour to debug
   */
  public int[] reorder(int[] array) {
    if (array.length % 2 != 0) {
      reorder(array, 0, array.length - 2);
    } else {
      reorder(array, 0, array.length - 1);
    }
    return array;
  }

  private void reorder(int[] input, int start, int end) {
    // base case
    int len = end - start + 1;
    if (len <= 2) return;
    int m = start + len / 2;
    int lm = start + len / 4;
    int rm = m + len / 4;
    int leftChunkLen = lm - start ;

    reverse(input, lm, m, rm);
    reorder(input, start, start + 2 * leftChunkLen - 1);
    reorder(input, start + 2 * leftChunkLen, end);
  }

  private void reverse(int[] input, int start, int mid, int end) {
    reverseChar(input, start, mid - 1);
    reverseChar(input, mid, end - 1);
    reverseChar(input, start, end - 1);
  }

  private void reverseChar(int[] input, int start, int end) {
    while (start < end) {
      swap(input, start++, end--);
    }
  }

  private void swap(int[] input, int left, int right) {
    int buf = input[left];
    input[left] = input[right];
    input[right] = buf;
  }

  public static void main(String[] args) {
    int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    ReorderArray ro = new ReorderArray();
    ro.reorder(input);
    System.out.println(Arrays.stream(input).boxed().collect(Collectors.toList()));
  }
}
