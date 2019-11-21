package alg.laioffer.class2.binsearch.impl;

import alg.laioffer.class2.binsearch.SmallestElemLargerThanTarget;

public class SmallestElemLargerThanTargetImpl implements SmallestElemLargerThanTarget {
  @Override
  public int smallestElementLargerThanTarget(int[] array, int target) {
    if(array == null || array.length == 0) return -1;
    int start = 0;
    int end = array.length - 1;
    /**
     * start + 1 < end ; // ... start end ... --> when out of loop --> need post processing
     */
    while (start < end + 1) { //<==> start <= end  ... end start ... --> when out of loop
      int mid = start + (end - start) / 2;
      if(target >= array[mid]){
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return start <= array.length - 1 ? start : -1;

  }
}
