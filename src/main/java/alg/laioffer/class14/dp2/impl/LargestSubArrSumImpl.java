package alg.laioffer.class14.dp2.impl;

import alg.laioffer.class14.dp2.LargestSubArrSum;

public class LargestSubArrSumImpl implements LargestSubArrSum {
    @Override
    public int largestSum(int[] array) {
        if (array == null || array.length == 0) return 0;
        int globalMax = array[0];
        int curMaxSum = array[0];
        for (int i = 1; i < array.length; i++) {
            curMaxSum = Math.max(0, curMaxSum) + array[i];
            globalMax = Math.max(globalMax, curMaxSum);
        }
        return globalMax;
    }
}
