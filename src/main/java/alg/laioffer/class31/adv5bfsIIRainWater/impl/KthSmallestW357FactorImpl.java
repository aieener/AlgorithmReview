package alg.laioffer.class31.adv5bfsIIRainWater.impl;

import alg.laioffer.class31.adv5bfsIIRainWater.KthSmallestWIthOnly357AsFactors;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * BFS2
 * f(x,y,z) = 3^x * 5^y * 7^z
 */
public class KthSmallestW357FactorImpl implements KthSmallestWIthOnly357AsFactors {
  @Override
  public long kth(int k) {
    Queue<Long> minHeap = new PriorityQueue<>();
    Set<Long> visited = new HashSet<>();
    long seed = 3 * 5 * 7L;
    minHeap.offer(seed);
    for (int i = 0; i < k - 1; i++) {
      Long seedToExpand = minHeap.poll();
      expand(minHeap, visited, seedToExpand, 3);
      expand(minHeap, visited, seedToExpand, 5);
      expand(minHeap, visited, seedToExpand, 7);
    }
    return minHeap.peek();
  }

  private void expand(Queue<Long> minHeap, Set<Long> visited, Long seedToExpand, int i2) {
    if (!visited.contains(seedToExpand * i2)) {
      minHeap.offer(seedToExpand * i2);
      visited.add(seedToExpand * i2);
    }
  }
}
