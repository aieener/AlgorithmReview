package alg.laioffer.class2.binsearch.impl;

import alg.laioffer.class2.binsearch.LargestElemSmallerThanTarget;

public class LargestElemSmallerThanTargetImpl implements LargestElemSmallerThanTarget {
  @Override
  public int largestElementSmallerThanTarget(int[] array, int target) {
    if (array == null || array.length == 0) return -1;
    int start = 0;
    int end = array.length - 1;
    while (start < end + 1) {
      int mid = start + (end - start) / 2;
      if (target <= array[mid]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return end >= 0 ? end : -1;
  }
}
