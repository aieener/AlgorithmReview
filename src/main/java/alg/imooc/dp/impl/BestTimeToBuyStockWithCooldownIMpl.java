package alg.imooc.dp.impl;

import alg.imooc.dp.BestTimeToBuyAndSellStockWithCooldown;

public class BestTimeToBuyStockWithCooldownIMpl implements BestTimeToBuyAndSellStockWithCooldown {
    @Override
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int[] sell = new int[prices.length]; // sell[i] represent maxProfit at day i, and last operation is Sell
        int[] buy = new int[prices.length]; // buy[i] represent minDebt at day i, neg val, and last operation is buy

        // sell[i] = Math.max(sell[i-1], prices[i] + buy[i-1]);
        // buy[i] = Math.max(sell[i-2] - prices[i], buy[i-1])
        sell[0] = 0;
        buy[0] = -prices[0];
        sell[1] = Math.max(0, buy[0] + prices[1]);
        buy[1] = Math.max(-prices[0], -prices[1]);
        for(int i = 2; i < prices.length; i++) {
            sell[i] = Math.max(sell[i-1], prices[i] + buy[i-1]);
            buy[i] = Math.max(sell[i-2] - prices[i], buy[i-1]);
        }
        return sell[sell.length - 1];
    }
}
