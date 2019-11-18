package alg.laioffer.class31.adv5bfsIIRainWater.impl;

import alg.laioffer.class31.adv5bfsIIRainWater.CommonElemInKSortedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonElemInKSortedListImpl implements CommonElemInKSortedList {
  /**
   * merge sort like approach
   */
  @Override
  public List<Integer> commonElementsInKSortedArrays(List<List<Integer>> input) {
    return mergeCommon(input, 0, input.size() - 1);
  }

  private List<Integer> mergeCommon(List<List<Integer>> input, int start, int end) {
    if (start == end) return input.get(start);
    int mid = start + (end - start) / 2;
    List<Integer> leftCommon = mergeCommon(input, start, mid);
    List<Integer> rightCommon = mergeCommon(input, mid + 1, end);
    return findCommonInTwoArr(leftCommon, rightCommon);
  }

  private List<Integer> findCommonInTwoArr(List<Integer> A, List<Integer> B) {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    for (Integer a : A) {
      map.put(a, map.getOrDefault(a, 0) + 1);
    }
    for (Integer b : B) {
      if (map.containsKey(b) && map.get(b) > 0) {
        res.add(b);
        map.put(b, map.get(b) - 1);
      }
    }
    return res;
  }
}
