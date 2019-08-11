package alg.leetcode.amazon.datastructure.impl;

import alg.leetcode.amazon.datastructure.KClosestToOrigin;

import java.util.Arrays;

/**
 * time O(n)
 * the qSort approach
 * very good problem, Needs review!
 */
public class KClosestToOriginDivideAndConquerImpl implements KClosestToOrigin {
  @Override
  public int[][] kClosest(int[][] points, int K) {
    qSort(points,0, points.length - 1, K);
    return Arrays.copyOfRange(points, 0, K);
  }

  private void qSort(int[][] points, int start, int end, int K){
    if(start >= end) return;
    int pivotIdx = partition(points, start, end);
    int leftLength = pivotIdx - start + 1;
    if(leftLength < K) {
      qSort(points, pivotIdx + 1, end, K - leftLength );
    } else if (leftLength > K) {
      qSort(points, start, pivotIdx - 1, K);
    }
  }

  private int partition(int[][] points, int start, int end) {
    int randIdx = (int) (Math.random() * ((end - start) + 1)) + start;
    int pivotDist = dist(randIdx, points);
    swap(points, randIdx, end); // swap pivot to the end
    int left = start;
    int right = end - 1;
    while(left <= right) {
      if(dist(left, points) < pivotDist) {
        left++;
      } else if (dist(right, points) > pivotDist) {
        right--;
      } else {
        swap(points, left++, right--);
      }
    }
    swap(points, left, end); // put the pivot back
    return left;
  }

  private void swap(int[][] points, int i, int j) {
    int temp0 = points[i][0];
    int temp1 = points[i][1];
    points[i][0] = points[j][0];
    points[i][1] = points[j][1];
    points[j][0] = temp0;
    points[j][1] = temp1;
  }

  private int dist(int i, int[][] points) {
    return points[i][0] * points[i][0] + points[i][1] * points[i][1];
  }
}
