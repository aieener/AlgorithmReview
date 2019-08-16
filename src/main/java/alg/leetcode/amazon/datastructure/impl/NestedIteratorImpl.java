package alg.leetcode.amazon.datastructure.impl;

import alg.leetcode.amazon.datastructure.NestedIterator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * [1, [4, [6]] -->
 *
 *        []
 *      /    \
 *     1     []
 *           /\
 *          4  []
 *              \
 *              6
 *  do dfs and load the leaf to queue
 */

public class NestedIteratorImpl implements NestedIterator {
  private Queue<Integer> it;
  interface NestedInteger {
    boolean isInteger();
    Integer getInteger();
    List<NestedInteger> getList();
  }
  public NestedIteratorImpl(List<NestedInteger> nestedList) {
    it = new LinkedList<>();
    for(NestedInteger ni : nestedList) {
      loadToQueue(ni);
    }
  }
  private void loadToQueue(NestedInteger ni) {
    //dfs
    if(ni.isInteger()) {
      it.offer(ni.getInteger()); // base case : reach leafNode, load it to queue
      return;
    }

    List<NestedInteger> list = ni.getList();
    for(NestedInteger cur : list) {
      loadToQueue(cur); // recursion rule
    }
  }
  @Override
  public Integer next() {
    return it.poll();
  }
  @Override
  public boolean hasNext() {
    return !it.isEmpty();

  }
}
