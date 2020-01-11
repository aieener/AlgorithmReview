package alg.imooc.dp.impl;

import alg.imooc.dp.IntegerBreak;

public class IntegerBreakImpl implements IntegerBreak {
    @Override
    public int integerBreak(int n) {
        if (n == 0 || n == 1) return 0;
        int[] M = new int[n + 1];
        // M[i] represent the max product when len = i;
        // M[i] = max(M[j], j )* (i-j) for 1 <=j <i (initially set M[i] = 0, j start from 1 cause we have to at least one cut);
        M[0] = 1;
        M[1] = 1; // must cut
        for (int i = 2; i <= n; i++) {
            M[i] = 0;
            for (int j = 1; j < i; j++) { // must cut for 0 to i, so j start at 1
                M[i] = Math.max(M[i], Math.max(M[j], j) * (i - j)); // for sub chunk j, we don't have to cut
            }
        }
        return M[n];
    }
}
