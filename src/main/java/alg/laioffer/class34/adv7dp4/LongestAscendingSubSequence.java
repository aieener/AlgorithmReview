package alg.laioffer.class34.adv7dp4;

import java.util.Arrays;

public class LongestAscendingSubSequence {
  /**
   * follow Up prob of LongestAscendingSubArray
   *  1. base case: M[0] = 1;
   *  2. induction rule
   *    M[i] represents 0th to ith, including i, the value of the
   *    longest ascending subSequence
   *
   *  Sol 1. linear scan, 打擂台 O(n^2)
   *  Sol 2. O(nlogn) 非常难想到，非常难证明,奇技淫巧 binSearch + DP
   *    key insight 1: if <a[j1], M[j1]> , <a[j2], M[j2]> are both in candidate set
   *       and M[j1] == M[j2], then I only keep the smaller one between a[j1] and a[j2
   *       M值相等去最小
   *    key insight 2: ending 越大， 长度越长, 可以排序
   *       prove: if <a[j], M[j]> is refined candidate, then a[j] is the smallest
   *       ending of all ascending subsequences of length M[j]
   *    refined candidate is sorted, do binSearch
   */
  public int longest(int[] array) {
    if(array == null || array.length == 0) return 0;
    int[] M = new int[array.length];
    M[0] = 1;
    int res = M[0];
    for(int i = 1; i < array.length; i++) {
      M[i] = 1;
      for(int j = 0; j < i; j++) {
        if(array[i] > array[j]) {
          M[i] = Math.max(M[i], M[j] + 1);
        }
      }
      res = Math.max(res, M[i]);
    }
    return res;
  }

  public int longestWithBinSearch(int [] array) {
    if(array.length == 0) {
      return 0;
    }
    int[] M = new int[array.length + 1];
    int res = 1;
    M[1] = array[0];
    for(int i = 1; i < array.length; i++) {
      int idx = find(M, 1, res, array[i]);
      if(idx == res) {
        res++;
        M[res] = array[i];
      } else {
        M[idx + 1] = array[i];
      }
    }
    return res;
  }

  /**
   * res++
   * M[res] = ... ===> M[++res] = ...
   *
   * M[res] = ...
   * res++        ===> M[res++] = ...
   */

  private int find(int[] M, int left, int right, int target) {
    // do binSearch find elem < target, the largest smaller val
    while(left <= right) {
      int mid = left + (right - left) /2;
      if(M[mid] >= target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    System.out.println(Arrays.toString(M));
    System.out.println(target);
    System.out.println(right);
    return right;
  }

  public static void main(String[] args) {
    int[] input = new int[] {5,4,3,2,1};
    LongestAscendingSubSequence engine = new LongestAscendingSubSequence();
    engine.longestWithBinSearch(input);
  }
}
