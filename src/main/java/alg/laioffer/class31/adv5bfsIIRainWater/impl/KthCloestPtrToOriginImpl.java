package alg.laioffer.class31.adv5bfsIIRainWater.impl;

import alg.laioffer.class31.adv5bfsIIRainWater.KthClosestPtrToOrigin;

import java.util.*;

public class KthCloestPtrToOriginImpl implements KthClosestPtrToOrigin {
  @Override
  public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
    boolean[][][] visited = new boolean[a.length][b.length][c.length];
    Queue<Ptr> minHeap = new PriorityQueue<>(new Comparator<Ptr>() {
      @Override
      public int compare(Ptr o1, Ptr o2) {
        return getDistance(a, b, c, o1).compareTo(getDistance(a, b, c, o2));
      }
    });

    minHeap.offer(new Ptr(0, 0, 0));
    visited[0][0][0] = true;

    for (int i = 0; i < k - 1; i++) {
      Ptr nodeToExpand = minHeap.poll();
      int ai = nodeToExpand.ai;
      int bi = nodeToExpand.bi;
      int ci = nodeToExpand.ci;
      if (ai + 1 < a.length && !visited[ai + 1][bi][ci]) {
        minHeap.offer(new Ptr(ai + 1, bi, ci));
        visited[ai + 1][bi][ci] = true;
      }

      if (bi + 1 < b.length && !visited[ai][bi + 1][ci]) {
        minHeap.offer(new Ptr(ai, bi + 1, ci));
        visited[ai][bi + 1][ci] = true;
      }

      if (ci + 1 < c.length && !visited[ai][bi][ci + 1]) {
        minHeap.offer(new Ptr(ai, bi, ci + 1));
        visited[ai][bi][ci + 1] = true;
      }
    }
    Ptr res = minHeap.peek();
    return Arrays.asList(a[res.ai], b[res.bi], c[res.ci]);
  }

  private Integer getDistance(int[] a, int[] b, int[] c, Ptr ptr) {
    return a[ptr.ai] * a[ptr.ai] + b[ptr.bi] * b[ptr.bi] + c[ptr.ci] * c[ptr.ci];
  }

  static class Ptr {
    int ai, bi, ci;

    Ptr(int ai, int bi, int ci) {
      this.ai = ai;
      this.bi = bi;
      this.ci = ci;
    }
  }
}
