package alg.leetcode.dp.impl;

import alg.leetcode.dp.MaxProductSubarray;

public class MaxProductSubarrayImpl implements MaxProductSubarray {
    /**
     * maintain two states: curMax and curMin
     */
    @Override
    public int maxProduct(int[] nums) {
        if (nums == null) return 0;
        int dp_Max = nums[0];
        int dp_Min = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = dp_Max;
            dp_Max = Math.max(Math.max(dp_Max * nums[i], dp_Min * nums[i]), nums[i]);
            dp_Min = Math.min(Math.min(temp * nums[i], dp_Min * nums[i]), nums[i]);
            globalMax = Math.max(globalMax, dp_Max);
        }
        return globalMax;
    }
}
