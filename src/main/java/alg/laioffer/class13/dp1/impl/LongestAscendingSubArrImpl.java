package alg.laioffer.class13.dp1.impl;

import alg.laioffer.class13.dp1.LongestAscendingSubArr;

public class LongestAscendingSubArrImpl implements LongestAscendingSubArr {
    @Override
    public int longest(int[] array) {
        if (array == null || array.length == 0) return 0;
        // M[i] represents longestAscendingArr, including i
        int[] M = new int[array.length];
        M[0] = 1;
        int global_max = 1;
        for (int i = 1; i < M.length; i++) {
            if (array[i] > array[i - 1]) {
                M[i] = M[i - 1] + 1;
            } else {
                M[i] = 1;
            }
            global_max = Math.max(M[i], global_max);
        }
        return global_max;
    }

    private int longestOpt(int[] array) {
        if (array == null || array.length == 0) return 0;
        int curMax = 1;
        int globalMax = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                curMax = curMax + 1;
            } else {
                curMax = 1;
            }
            globalMax = Math.max(curMax, globalMax);
        }
        return globalMax;
    }
}
