package Bloomberg_71_leetCode;


/**
 * Feb 20
 * LeetCode 122
 * Greedy
 * Created by yuding on 2/8/18.
 * You may complete as many transaction as you like
 * this one is asking to get all the profit! so if there
 * is a gap, take it
 *
 * Linear scan hui tou kan
 */
public class BuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int res = 0;
        for(int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if(diff > 0) {
                res += diff;
            }
            System.out.print(res);
        }
        return res;
    }

    public static void main(String[] args) {
        BuyAndSellStockII st = new BuyAndSellStockII();
        int [] prices = new int[] {3,3,5,0,0,3,1,4};
        st.maxProfit(prices);
    }

    //------------- prac ------------------
    public int maxProfit2(int[] prices) {
        // write your code here
        if(prices == null || prices.length == 0 ){
            return 0;
        }
        int res = 0;
        for(int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            if(profit > 0) {
                res += profit;
            }
        }
        return res;
    }

}
