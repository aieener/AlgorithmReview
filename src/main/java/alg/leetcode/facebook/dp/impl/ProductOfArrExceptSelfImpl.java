package alg.leetcode.facebook.dp.impl;

import alg.leetcode.facebook.dp.ProductOfArrExceptSelf;

public class ProductOfArrExceptSelfImpl implements ProductOfArrExceptSelf {
  @Override
  public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];

    int[] leftM = new int[nums.length]; // 0 to i product -->
    leftM[0] = nums[0];
    for (int i = 1; i < leftM.length; i++) {
      leftM[i] = leftM[i - 1] * nums[i];
    }

    int[] rightM = new int[nums.length]; // len - 1 to i product <--
    rightM[rightM.length - 1] = nums[result.length - 1];
    for (int i = rightM.length - 2; i >= 0; i--) {
      rightM[i] = rightM[i + 1] * nums[i];
    }

    result[0] = rightM[1];
    result[result.length - 1] = leftM[rightM.length - 2];
    for (int i = 1; i < nums.length - 1; i++) {
      result[i] = leftM[i - 1] * rightM[i + 1];
    }
    return result;
  }
}
