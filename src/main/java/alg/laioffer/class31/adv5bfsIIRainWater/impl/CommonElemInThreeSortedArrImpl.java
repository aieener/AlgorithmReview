package alg.laioffer.class31.adv5bfsIIRainWater.impl;

import alg.laioffer.class31.adv5bfsIIRainWater.CommonElemInThreeSortedArr;

import java.util.ArrayList;
import java.util.List;

public class CommonElemInThreeSortedArrImpl implements CommonElemInThreeSortedArr {
  @Override
  public List<Integer> common(int[] a, int[] b, int[] c) {
    int aPtr = 0;
    int bPtr = 0;
    int cPtr = 0;
    List<Integer> res = new ArrayList<>();
    while (aPtr < a.length && bPtr < b.length && cPtr < c.length) {
      if (a[aPtr] == b[bPtr] && b[bPtr] == c[cPtr]) {
        res.add(a[aPtr]);
        aPtr++;
        bPtr++;
        cPtr++;
      } else if (a[aPtr] <= b[bPtr] && a[aPtr] <= c[cPtr]) {
        aPtr++;
      } else if (b[bPtr] <= a[aPtr] && b[bPtr] <= c[cPtr]) {
        bPtr++;
      } else {
        cPtr++;
      }
    }
    return res;
  }

}
