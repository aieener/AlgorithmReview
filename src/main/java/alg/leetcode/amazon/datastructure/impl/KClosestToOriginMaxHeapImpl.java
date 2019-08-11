package alg.leetcode.amazon.datastructure.impl;

import alg.leetcode.amazon.datastructure.KClosestToOrigin;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * time O(nlogn)
 */
public class KClosestToOriginMaxHeapImpl implements KClosestToOrigin {
  class Point {
    int row, col;
    Point(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  class PointComparator implements Comparator<Point> {
    @Override
    public int compare(Point p1, Point p2) {
      Integer disP1 = p1.row * p1.row + p1.col * p1.col;
      Integer disP2 = p2.row * p2.row + p2.col * p2.col;
      return disP2.compareTo(disP1);
    }
  }

  @Override
  public int[][] kClosest(int[][] points, int K) {
    int[][] result = new int[K][2];
    Comparator<Point> pointMaxComparator = new PointComparator();
    Queue<Point> maxHeap = new PriorityQueue<Point>(pointMaxComparator);

    for(int[] point : points) {
      Point current =new Point(point[0],point[1]);
      if(maxHeap.size() < K) {
        maxHeap.offer(current);
      } else {
        Point top = maxHeap.peek();
        if( pointMaxComparator.compare(top, current) < 1) {
          maxHeap.poll();
          maxHeap.offer(current);
        }
      }
    }

    for(int i = K - 1; i >= 0; i--) {
      Point cur = maxHeap.poll();
      result[i][0] = cur.row;
      result[i][1] = cur.col;
    }

    return result;
  }
}
