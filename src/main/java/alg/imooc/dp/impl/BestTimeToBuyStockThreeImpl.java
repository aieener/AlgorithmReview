package alg.imooc.dp.impl;

import alg.imooc.dp.BestTimeToBuyStockThree;

public class BestTimeToBuyStockThreeImpl implements BestTimeToBuyStockThree {
    @Override
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int K = 2;
        int[][] M = new int[K][prices.length];
        // M[k][i] represents, at kth transaction (last ops is sell), at day i, the max profit, res will be M[2][prices.len - 1];
        // base case: M[k][0] = 0;  origin debt at Day 1 is - prices[0];
        // induction rule: M[k][i] = Math.max(M[k][i-1], prices[0] + curDebt); curDebt = Math.max(curDebt, prevGain - prices[i]) // buy
        for(int k = 0; k < K; k++) {
            int curDebt = - prices[0];
            for(int i = 1; i < prices.length; i++) {
                M[k][i] = Math.max(M[k][i-1], prices[i] + curDebt);
                int prevGain = k > 0 ? M[k-1][i-1] : 0;
                curDebt = Math.max(curDebt, prevGain - prices[i]);
            }
        }
        return M[K-1][prices.length - 1];
    }
}
