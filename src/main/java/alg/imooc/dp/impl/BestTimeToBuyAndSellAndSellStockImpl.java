package alg.imooc.dp.impl;

import alg.imooc.dp.BestTimeToBuyAndSellStockThree;

public class BestTimeToBuyAndSellAndSellStockImpl implements BestTimeToBuyAndSellStockThree {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int minIdx = 0;
        int res = 0;
        for(int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[minIdx];
            if(profit < 0) {
                minIdx = i;
            } else {
                res = Math.max(res, profit);
            }
        }
        return res;
    }
}
