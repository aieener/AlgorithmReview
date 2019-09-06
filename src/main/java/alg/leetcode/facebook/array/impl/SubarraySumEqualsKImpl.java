package alg.leetcode.facebook.array.impl;

import alg.leetcode.facebook.array.SubarraySumEqualsK;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsKImpl implements SubarraySumEqualsK {
  public static void main(String[] args) {
    int[] input = new int[]{1, 1, 1};
    SubarraySumEqualsK engine = new SubarraySumEqualsKImpl();
    System.out.println(engine.checkSubarraySum(input, 2));
  }

  @Override
  public int checkSubarraySum(int[] nums, int k) {
    Map<Integer, Integer> prefixSum = new HashMap<>(); // <sum, freq>
    int curTotalPrefixSum = 0;
    int count = 0;
    prefixSum.put(0, 1);
    for (int i = 0; i < nums.length; i++) {
      curTotalPrefixSum += nums[i];
      if (prefixSum.containsKey(curTotalPrefixSum - k)) count += prefixSum.get(curTotalPrefixSum - k);
      prefixSum.put(curTotalPrefixSum, prefixSum.getOrDefault(curTotalPrefixSum, 0) + 1);
    }
    return count;
  }
}
