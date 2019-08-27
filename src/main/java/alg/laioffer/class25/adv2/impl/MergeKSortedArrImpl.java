package alg.laioffer.class25.adv2.impl;

import alg.laioffer.class25.adv2.MergeKSortedArr;

import java.util.*;

/**
 * Best First Search
 */
public class MergeKSortedArrImpl implements MergeKSortedArr {
  @Override
  public int[] merge(int[][] arrayOfArrays) {
    List<Integer> res = new ArrayList<>();
    Queue<Node> minHeap = new PriorityQueue<>(Comparator.comparing(o -> o.val));
    // starting nodes
    for (int k = 0; k < arrayOfArrays.length; k++) {
      if(arrayOfArrays[k].length > 0) {
        minHeap.offer(new Node(arrayOfArrays[k][0], 0, k));
      }
    }
    // bfs
    while (!minHeap.isEmpty()) {
      Node nodeToExpand = minHeap.poll();
      res.add(nodeToExpand.val);
      int nextIdx = nodeToExpand.valIdx + 1;
      int arrIdx = nodeToExpand.arrIdx;
      if (nextIdx < arrayOfArrays[arrIdx].length) {
        minHeap.offer(new Node(arrayOfArrays[arrIdx][nextIdx], nextIdx, arrIdx));
      }
    }
    return res.stream().mapToInt(Integer::intValue).toArray();
  }

  static class Node {
    Integer valIdx, val, arrIdx;

    Node(Integer val, Integer valIdx, Integer arrIdx) {
      this.val = val;
      this.valIdx = valIdx;
      this.arrIdx = arrIdx;
    }
  }
}
