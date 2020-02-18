package alg.oa.microsoftRealOA;

import java.util.*;

/*
Give you one sorted array, please put them into n buckets, we need to ensure we get n sub array with approximately equal weights.
Example;
input {1, 2, 3, 4, 5} n = 3
output [[[5],[1,4],[2,3]];
 */
public class PartitionArrayIntoNSubsetsWithBalancedSum {
  static class Bucket {
    Integer idx;
    Integer sum;

    public Bucket(int idx, int sum) {
      this.idx = idx;
      this.sum = sum;
    }
  }

  public List<List<Integer>> partition(int[] arr, int n) {
    List<List<Integer>> res = new ArrayList<>();
    Bucket[] buckets = new Bucket[n];
    Queue<Bucket> minHeap = new PriorityQueue<>(new Comparator<Bucket>() {
      @Override
      public int compare(Bucket base, Bucket other) {
        return base.sum.compareTo(other.sum);
      }
    });

    for (int i = 0; i < n; i++) {
      res.add(new ArrayList<>());
      minHeap.offer(new Bucket(i, 0));
    }

    for (int i = arr.length - 1; i >= 0; i--) {
      Bucket bucket = minHeap.poll();
      bucket.sum += arr[i];
      res.get(bucket.idx).add(arr[i]);
      minHeap.offer(bucket);
    }
    return res;
  }

  public static void main(String[] args) {
    PartitionArrayIntoNSubsetsWithBalancedSum engine = new PartitionArrayIntoNSubsetsWithBalancedSum();
    List<List<Integer>> result = engine.partition(new int[] {1,2,3,4,5,6,7,8,9,10}, 3);
    List<List<Integer>> result2 = engine.partition(new int[] {1,2,3,4,5}, 3);
    System.out.println(result);
    System.out.println(result2);
  }
}
