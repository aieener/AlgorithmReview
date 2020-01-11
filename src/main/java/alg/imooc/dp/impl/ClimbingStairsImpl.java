package alg.imooc.dp.impl;

import alg.imooc.dp.ClimbingStairs;

public class ClimbingStairsImpl implements ClimbingStairs {
    @Override
    public int climbStairs(int n) {
        int[] M = new int[n + 1]; // M[i] represents numOf ways to climb to i
        // base case
        M[0] = 1;
        M[1] = 1;
        for(int i = 2; i < n + 1; i++) {
            M[i] = M[i-1] + M[i-2]; // num ways climb one step + num ways climb two step
        }
        return M[n];
    }
}
