package alg.laioffer.class25.adv2.impl;

import alg.laioffer.class25.adv2.CutWood;

public class CutWoodImpl implements CutWood {
    @Override
    public int minCost(int[] cuts, int length) {
        int[] padCuts = getPaddedCuts(cuts, length);
        return getMinCost(padCuts, length);
    }

    /**
     * M[i][j] represents the min cost of cutting the wood between index i and j from cuts[]
     * Sol = M[0][4] (y = 0, x = 4, the right top corner)
     * base case: M[0][1] = 0, M[1][2] = 0, ... M[len - 1][len] = 0
     * induction rule : M[i][j] = min(padCuts[j] - padCuts[i] + M[i][k] + M[k][j]) where i < k < j
     * M is fill from left to right, bottom to up
     */
    private int getMinCost(int[] padCuts, int length) {
        int[][] M = new int[padCuts.length][padCuts.length];
        for (int j = 1; j < padCuts.length; j++) {
            // left to right
            for (int i = j - 1; i >= 0; i--) {
                // bottom to up
                if (i + 1 == j) {
                    M[i][j] = 0; // base case
                } else {
                    M[i][j] = Integer.MAX_VALUE;

                    for (int k = i + 1; k <= j - 1; k++) {
                        // i < k < j
                        M[i][j] = Math.min(M[i][j], M[i][k] + M[k][j]);
                    }
                    int curCutCost = padCuts[j] - padCuts[i];
                    M[i][j] += curCutCost;
                }
            }
        }
        return M[0][padCuts.length - 1];
    }

    private int[] getPaddedCuts(int[] cuts, int length) {
        int[] helper = new int[cuts.length + 2];
        // preCuts with leftMost and rightMost partition (padding cuts)
        helper[0] = 0;
        System.arraycopy(cuts, 0, helper, 1, cuts.length);
        helper[helper.length - 1] = length;
        return helper;
    }
}
