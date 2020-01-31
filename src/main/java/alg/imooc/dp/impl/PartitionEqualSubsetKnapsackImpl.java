package alg.imooc.dp.impl;

import alg.imooc.dp.PartitionEqualSubsetSumKnapsack;

public class PartitionEqualSubsetKnapsackImpl implements PartitionEqualSubsetSumKnapsack {
    @Override
    public boolean canPartition(int[] nums) {
        int sum = getSum(nums);
        if (sum % 2 != 0) return false;
        int halfWeight = sum / 2;
        boolean[][] M = new boolean[nums.length][halfWeight + 1];
        // M[i][j] represents using item from 0 to i, can fill the sum to j
        // base case M[i][nums[i]] = true;
        // recursive rule M[i][j] = M[i-1][j](not take) OR M[i - 1][j - nums[i]] (take)

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= halfWeight) {
                M[i][nums[i]] = true;
            }
        }

        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j <= halfWeight; j++) {
                M[i][j] = j - nums[i] >=0 ? (M[i-1][j] || M[i-1][j-nums[i]]) : M[i-1][j];
            }
        }
        return M[M.length - 1][M[0].length - 1];
    }

    private int getSum(int[] nums) {
        int res = 0;
        for (int val : nums) {
            res += val;
        }
        return res;
    }
}
