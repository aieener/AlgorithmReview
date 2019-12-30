package alg.laioffer.class31.adv5bfsIIRainWater.impl;

import alg.laioffer.class31.adv5bfsIIRainWater.CommonNumberOfTwoArr;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class CommonNumOfTwoArrImpl implements CommonNumberOfTwoArr {
  @Override
  public List<Integer> common(int[] A, int[] B) {
    int[] smallerOne = A.length < B.length ? A : B;
    int[] iterArr = A.length > B.length ? A : B;
    Map<Integer, Integer> map = getSetFromArr(smallerOne);
    List<Integer> common = new ArrayList<>();
    for (Integer cur : iterArr) {
      if (map.containsKey(cur) && map.get(cur) > 0) {
        map.put(cur, map.get(cur) - 1);
        common.add(cur);
      }
    }
    Collections.sort(common); // not necessary, just need to sort it to pass LaiCode
    return common;
  }

  private Map<Integer, Integer> getSetFromArr(int[] arr) {
    Map<Integer, Integer> res = new HashMap<>();
    for (Integer cur : arr) {
      res.put(cur, res.getOrDefault(cur, 0) + 1);
    }
    return res;
  }
}
