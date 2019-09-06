package alg.leetcode.facebook.dp.impl;

import alg.leetcode.facebook.dp.ProductOfArrExceptSelf;

/**
 * Reuse the res Arr to emulate leftM and rightM
 */
public class ProductOfArrExceptSelfSpaceOneImpl implements ProductOfArrExceptSelf {
  @Override
  public int[] productExceptSelf(int[] nums) {
    int len = nums.length;
    int[] result = new int[len];
    result[0] = nums[0];
    for (int i = 1; i < len; i++) {
      result[i] = result[i - 1] * nums[i];
    }

    int nextRightProduct = nums[len - 1];
    result[len - 1] = result[len - 2];
    for (int i = len - 2; i > 0; i--) {
      result[i] = result[i - 1] * nextRightProduct;
      nextRightProduct *= nums[i];
    }
    result[0] = nextRightProduct;

    return result;
  }
}
