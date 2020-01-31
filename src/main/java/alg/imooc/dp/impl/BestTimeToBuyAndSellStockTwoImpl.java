package alg.imooc.dp.impl;

import alg.imooc.dp.BestTimeToBuyAndSellStockTwo;

public class BestTimeToBuyAndSellStockTwoImpl implements BestTimeToBuyAndSellStockTwo {
    @Override
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int own = -prices[0];
        int prevProfit = 0;
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(prevProfit, own + prices[i]);
            own = Math.max(own, prevProfit - prices[i]);
            prevProfit = maxProfit;
        }
        return maxProfit;

    }
}
