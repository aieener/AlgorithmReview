package alg.laioffer.class34.adv7dp4.impl;

import alg.laioffer.class34.adv7dp4.MergeStones;

public class MergeStonesImpl implements MergeStones {
    @Override
    public int minCost(int[] stones) {
        //M[i][j] represents minCost to merge from store [i] to stone [j]
        // M[i][j] = min(M[i][k] + M[k + 1][j]) + weight(i,j) for all possible k where i <= k < j
        int [][] M = new int[stones.length][stones.length];
        // base case
        for(int i = 0; i < M.length - 1; i++) {
            M[i][i + 1] = stones[i] + stones[i + 1];
        }

        int[][] weight = getWeightLkup(stones);
        for(int delta = 2; delta < stones.length; delta++) {
            for (int i = 0; i < stones.length - delta; i++) {
                int j = i + delta;
                int curVal = Integer.MAX_VALUE;
                for(int k = i; k < j; k++) {
                    curVal = Math.min(M[i][k] + M[k + 1][j], curVal);
                }
                M[i][j] = curVal + weight[i][j];
            }
        }
        return M[0][M.length - 1];
    }

    private int[][] getWeightLkup (int[] stone) {
        int[][] weight = new int[stone.length][stone.length];
        for(int row = 0; row < weight.length; row++) {
            for(int col = row; col < weight[0].length; col++) {
                if(row == col) {
                    weight[row][col] = stone[row];
                } else {
                    weight[row][col] = weight[row][col - 1] + stone[col];
                }
            }
        }
        return weight;
    }
    // private int weight(int i, int j, int[] stones) {
    //   int res = 0;
    //   for(int c = i; c <= j; c++) {
    //     res += stones[c];
    //   }
    //   return res;
    // }

    public static void main(String[] args) {
        int[] input = new int[] {4,3,3,4};
        new MergeStonesImpl().minCost(input);
    }
}
