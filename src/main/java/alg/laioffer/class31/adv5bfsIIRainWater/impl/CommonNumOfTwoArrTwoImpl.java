package alg.laioffer.class31.adv5bfsIIRainWater.impl;

import alg.laioffer.class31.adv5bfsIIRainWater.CommonNumOfTwoArraysTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * similar size: 谁小移谁
 * diff size: binSearch
 */
public class CommonNumOfTwoArrTwoImpl implements CommonNumOfTwoArraysTwo {
  @Override
  public List<Integer> common(int[] a, int[] b) {
    int[] smaller, bigger;
    if (a.length > b.length) {
      smaller = a;
      bigger = b;
    } else {
      smaller = b;
      bigger = a;
    }
    int sLen = smaller.length;
    int bLen = bigger.length;
    if (sLen * 100 < bLen) {
      return commonBinSearch(a, b);
    }
    return moveSmaller(smaller, bigger);
  }

  private List<Integer> commonBinSearch(int[] smaller, int[] bigger) {
    List<Integer> res = new ArrayList<>();
    for (Integer cur : smaller) {
      if (binSearch(bigger, cur)) res.add(cur);
    }
    return res;
  }

  private boolean binSearch(int[] a, int target) {
    if (a == null || a.length == 0) return false;
    int start = 0;
    int end = a.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (a[mid] > target) {
        end = mid;
      } else if (a[mid] < target) {
        start = mid;
      } else {
        return true;
      }
    }
    return a[start] == target || a[end] == target;
  }


  private List<Integer> moveSmaller(int[] a, int[] b) {
    List<Integer> res = new ArrayList<>();
    int aPtr = 0;
    int bPtr = 0;
    while (aPtr < a.length && bPtr < b.length) {
      if (a[aPtr] == b[bPtr]) {
        res.add(a[aPtr]);
        aPtr++;
        bPtr++;
      } else if (a[aPtr] < b[bPtr]) {
        aPtr++;
      } else {
        bPtr++;
      }
    }
    return res;
  }
}
