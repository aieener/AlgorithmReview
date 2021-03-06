package alg.oa.microsoftRealOA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Write a function that, given an array A of N integers, returns the lagest integer K > 0 such that both values K and -K
exisit in array A. If there is no such integer, the function should return 0.

Example 1:

Input: [3, 2, -2, 5, -3]
Output: 3
Example 2:

Input: [1, 2, 3, -4]
Output: 0
 */
public class LargeInteger {
  public int largestNumOptTime(int[] nums) {
    int res = 0;
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      set.add(-nums[i]);
      if (set.contains(nums[i])) {
        res = Math.max(res, Math.abs(nums[i]));
      }
    }
    return res;
  }

  public int largestNumOptSpace(int[] nums) {
    int res = 0;
    Arrays.sort(nums);
    int l = 0, r = nums.length - 1;
    while (l < r) {
      int sum = nums[l] + nums[r];
      if (sum == 0) {
        res = Math.max(res, Math.max(nums[l], nums[r]));
        l++;
        r--;
      } else if (sum < 0) {
        l++;
      } else {
        r--;
      }
    }
    return res;
  }
}
