package Class_01_RecursionI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MergeSort {
  public int[] mergeSort(int[] array) {
    int[] buf = new int[array.length];
    mergeSort(array, buf, 0, array.length - 1);
    return array;
  }

  private void mergeSort(int[] input, int[] buf, int start, int end) {
    //base case
    if (start >= end) {
      return;
    }
    int mid = start + (end - start) / 2;
    mergeSort(input, buf, start, mid);
    mergeSort(input, buf, mid + 1, end);
    merge(input, buf, start, mid, end);
  }

  private void merge(int[] input, int [] buf, int start, int mid, int end) {
    int leftRunner = start;
    int rightRunner = mid + 1;
    int bufIdx = start;

    while(leftRunner <= mid && rightRunner <= end) {
      if(input[leftRunner] <= input[rightRunner]) {
        buf[bufIdx++] = input[leftRunner++];
      } else {
        buf[bufIdx++] = input[rightRunner++];
      }
    }

    while(leftRunner <= mid) {
      buf[bufIdx++] = input[leftRunner++];
    }

    while(rightRunner <= end) {
      buf[bufIdx++] = input[rightRunner++];
    }

    for (int i = start; i <= end; i++) {
      input[i] = buf[i];
    }
  }

  public static void main(String[] args) {
    int[] input = new int[]{1,3,5,7,6,2,5,4};
    new MergeSort().mergeSort(input);
    System.out.println(Arrays.toString(input));
  }
}
