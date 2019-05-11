package alg.laioffer.class1.recursion;
// This is the answer from laiOffer where we pick random
// This version is the same as from Alg text book
// index as pivot

// Review nov_5 video, ---> 1:45 to 1:50
// Two bars with 3 zone!
//  [0,... l) to the left of l, not including l, will be <=  pivot
//  (r, ... n-1] to the right of r, not including r, will be >= pivot
// in between, unexplored zone [l,r]

// QSort can do concurrently! better than mergeSort
//      Worst case O(n^2)
//      Average O(nlogn)

import java.util.Arrays;

/**
 * - Dec 31 revisit
 */
public class QuickSort {
  public int[] quickSort(int[] array) {
    qSort(array, 0, array.length - 1);
    return array;
  }

  private void qSort(int[] array, int start, int end) {
    // base case
    if (start >= end) {
      return;
    }
    int pivotIdx = (int) (Math.random() * ((end - start) + 1)) + start;
//    int pivotIdx = start + (end - start) / 2;
    int pivot = array[pivotIdx];

    // swap pivot to the end
    swap(array, pivotIdx, end);
    // move
    int l = start;
    int r = end - 1;
    while (l <= r) {
      if(array[l] < pivot) {
        l++;
      } else if (array[r] >= pivot) {
        r--;
      } else {
        swap(array, l, r);
        l++;
        r--;
      }
    }
    //swap back
    swap(array, l, end);
    qSort(array, start, l - 1);
    qSort(array, l + 1, end);

  }

  private void swap(int[] input, int l, int r) {
    int temp = input[l];
    input[l] = input[r];
    input[r] = temp;
  }


  public static void main(String[] args) {
    QuickSort sol = new QuickSort();


    int[] array = new int[]{1, 4, 3, 3, 4, 3, 3, 2, 1};
    array = sol.quickSort(array);
    System.out.println(Arrays.toString(array));

    array = new int[]{1, 9, 8, 3, 5, 3, 3, 2, 1, 0};
    array = sol.quickSort(array);
    System.out.println(Arrays.toString(array));
  }
}


