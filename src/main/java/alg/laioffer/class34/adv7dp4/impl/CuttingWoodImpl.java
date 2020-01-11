package alg.laioffer.class34.adv7dp4.impl;

import alg.laioffer.class34.adv7dp4.CuttingWood;

public class CuttingWoodImpl implements CuttingWood {
    @Override
    public int minCost(int[] cuts, int length) {
        // M[i][j] represents minCost for cut from cut[i] to cut[j]
        // result will be M[0][len - 1]
        // M[i][j] = min(M[i][k] + M[k][j]) + eCuts[j] - eCuts[i] for all ks
        // expand cuts;
        int[] eCuts = getExpandedCurs(cuts, length);
        int[][] M = new int[eCuts.length][eCuts.length];

        for(int i = 0; i < M.length - 1; i++) {
            M[i][i + 1] = 0;
        }

        for(int delta = 2; delta < M.length; delta++) {
            for(int i = 0; i < M.length - delta ; i++) {
                int j = i + delta;
                int curVal = Integer.MAX_VALUE;
                for(int k = i + 1; k < j; k++) {
                    curVal = Math.min(curVal, M[i][k] + M[k][j]);
                }
                M[i][j] = curVal + eCuts[j] - eCuts[i];

            }
        }
        return M[0][M.length - 1];
    }

    private int[] getExpandedCurs(int[] cuts, int length) {
        int[] expandedCutPos = new int[cuts.length + 2];
        expandedCutPos[0] = 0;
        for(int i = 0; i < cuts.length; i++) {
            expandedCutPos[i + 1] = cuts[i];
        }
        expandedCutPos[expandedCutPos.length - 1] = length;
        return expandedCutPos;
    }
}
