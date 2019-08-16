package alg.leetcode.amazon.datastructure.impl;

import alg.leetcode.amazon.datastructure.RandomizedSet;

import java.util.*;

public class RandomizedSetImpl implements RandomizedSet {

  private List<Integer> list;
  private Map<Integer, Integer> map; // <val, pos>
  private Random rand;

  public RandomizedSetImpl() {
    map = new HashMap<>();
    list = new ArrayList<>();
    rand = new Random();
  }

  @Override
  public boolean insert(int val) {
    if (map.containsKey(val)) return false;
    map.put(val, list.size());
    list.add(val);
    return true;
  }

  @Override
  public boolean remove(int val) {
    if (!map.containsKey(val)) return false;
    // swap
    swapEndToValPosInList(val);
    map.remove(val);
    list.remove(list.size() - 1);
    return true;
  }

  private void swapEndToValPosInList(int val) {
    int pos = map.get(val);
    list.set(pos, list.get(list.size() - 1));
    map.put(list.get(list.size() - 1), pos);
  }

  @Override
  public int getRandom() {
    int randIdx = rand.nextInt(list.size());
    return list.get(randIdx);
  }
}
