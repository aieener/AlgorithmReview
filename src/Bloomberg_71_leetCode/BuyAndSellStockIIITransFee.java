package Bloomberg_71_leetCode;

/**
 * Feb 20 ** revisit! want to Own Less !!
 * Created by yuding on 2/12/18.
 * If use DFS, this takes (2^n), everyday has two choices, buy or not buy
 * If use DP, this is O(n)
 * maintain two states: own and sell
 *
 * This one uses DP
 * This one is hard! Need to revisit
 */
public class BuyAndSellStockIIITransFee {
    public static int maxProfit(int [] prices, int fee) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int sell = 0;
        int own = - prices[0];
        for(int i = 1; i < prices.length; i++) {
            sell = Math.max(sell, own + prices[i] - fee);
            own = Math.max(own , sell - prices[i]);
        }
        return sell;

    }

    /**
     * O[i] stands for the max Own (负的最少,故用max) at day i
     * S[i] stands for the max profit at day i
     * S[i] = max(S[i - 1], prices[i] + O[i - 1] - fee); // use previous day's Own do transaction
     * O[i] = max(O[i - 1], S[i] - prices[i]); // S already including fees
     */
    public static int maxProfitDP(int []prices, int fee) {
        int O[] = new int[prices.length];
        int S[] = new int[prices.length];
        O[0] = -prices[0];
        S[0] = 0;

        for(int i = 1; i < prices.length; i++) {
            S[i] = Math.max(S[i - 1], prices[i] + O[i - 1] -fee);
            O[i] = Math.max(O[i - 1], S[i] -prices[i]);
        }
        return S[S.length - 1];
    }

    public static void main(String[] args) {

        int [] input  = new int[] {1,3,2,8,4,9};
        int [] input2 = new int[] {1,3,7,5,10,3};
        System.out.println(maxProfit(input, 2));
        System.out.println(maxProfitDP(input, 2));
        System.out.println(maxProfitDP(input2, 3));
        System.out.println(maxProfit(input2, 3));
    }

    // ---------- prac -----------
    /**
     * O[i] stands for the max Own (负的最少,故用max) at day i 买便宜的！
     * S[i] stands for the max profit at day i
     * S[i] = max(S[i - 1], prices[i] + O[i - 1] - fee); // use previous day's Own do transaction
     * O[i] = max(O[i - 1], S[i] - prices[i]); // S already including fees
     */

    public static int maxProfitDP2(int []prices, int fee) {
        int O[] = new int[prices.length];
        int S[] = new int[prices.length];
        O[0] = prices[0]; // stock own, will be a used to subtract
        S[0] = 0;
        for(int i = 1; i < prices.length; i++) {
            int profit = prices[i] - O[i-1] - fee; // sell the stock
            S[i] = Math.max(S[i-1], profit);
            O[i] = Math.min(O[i - 1], prices[i] - S[i]); // S already including trans fee! 最优 S
            //想欠银行欠的少
        }
        return S[S.length - 1];
    }

}
