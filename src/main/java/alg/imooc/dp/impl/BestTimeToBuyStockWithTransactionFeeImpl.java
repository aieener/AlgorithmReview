package alg.imooc.dp.impl;

import alg.imooc.dp.BestTimeToBuyStockWithTransactionFee;

public class BestTimeToBuyStockWithTransactionFeeImpl implements BestTimeToBuyStockWithTransactionFee {
    @Override
    public int maxProfit(int[] prices, int fee) {
        if(prices == null || prices.length <= 1) return 0;
        int[] own = new int[prices.length]; // own[i] represents minimal debt one could own for range 0, i
        int[] sell = new int[prices.length]; // sell[i] represent the maxProfit one could get for range 0, i
        int res = 0;

        // base case:
        sell[0] = 0; //how much we gain
        own[0] = -prices[0]; // stock own, negtive,

        // induction rule:
        // sell[i] = Math.max(sell[i-1], prices[i] - own[i-1] - fee); // not sell: sell[i-1] | sell at day i, gain prices[i], lose own[i-1];
        // own[i] = Math.min(own[i-1], prices[i] - sell[i]); //not buy: own[i-1] | buy at day i, cost sell[i-1] - prices[i]

        for(int i = 1; i < prices.length; i++) {
            own[i] = Math.max(own[i-1],  sell[i-1] - prices[i]);
            sell[i] = Math.max(sell[i-1], own[i-1] + prices[i] - fee); // pay fee at sell
        }
        return sell[sell.length - 1];

    }
}
