package alg.penn.bloomberg;

/**
 * Feb 20
 * LeetCode 121
 * This one is not in LaiCode yet, but BlackStone
 * will test on it, it is very similar to maxArraySum
 *
 *  A    7   1   5   3   6   4
 *  M    0  -6   4   2   5   3
 *
 * M[i]: represent the profit of selling at time i
 * Induction rule:
 * M[i] = if prices[i] - prices[minBuyIndex] < 0: set minBuyIndex to i
 *
 *        otherwise M[i] = prices[i] - prices[minBuyIndex]
 */
public class BuyAndSellStock {
    public int maxProfit(int [] prices ) {
        if(prices == null || prices.length == 0) {
            return 0;
        }

        int [] M = new int[prices.length];
        // base case
        M[0] = 0;
        int minBuyIndex = 0;
        int maxProfit = M[0];
        for(int i = 1; i < prices.length; i++) {
            int curProfit = prices[i] - prices[minBuyIndex];
            if(curProfit < 0) {
                minBuyIndex = i;
            } else {
                M[i] = curProfit;
            }
            maxProfit = Math.max(M[i] , maxProfit);
            System.out.println(maxProfit);
        }
        return maxProfit;
    }

    public int maxProfitOPT(int [] prices ) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            int profit = prices[i] - minPrice;
            if(profit < 0) {
                minPrice = prices[i];
            } else if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BuyAndSellStock bs = new BuyAndSellStock();
        int [] in = new int[]{7,1,5,3,6,4};
        System.out.println(bs.maxProfit(in));
    }

    //------------------ prac --------------------

    public int maxProfitOPT2(int [] prices ) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int minIdx = 0;
        int res = 0;
        for(int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[minIdx];
            if(profit < 0 ) {
                minIdx = i;
            } else {
                res = Math.max(res, profit);
            }
        }
        return res;
    }
}
