package alg.leetcode.amazon.datastructure;

/**
 * Design a data structure that supports all following operations in average O(1) time.
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 */
public interface RandomizedSet {
  public boolean insert(int val);

  public boolean remove(int val);

  public int getRandom();
}
