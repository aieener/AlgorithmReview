package CIT_596;

import java.util.Arrays;

/**
 * Created by yuding on 1/22/18.
 */
public class BuySellStock {
    /**
     * O(n^2)
     */
    public int[] SP(int[] input) {
        int[] res = new int[3];

        int globalMax = Integer.MIN_VALUE;

        for(int i = 0; i < input.length;i++) {
            int buyingPrice = input[i];
            for(int j = i; j < input.length; j++) {
                int sellPrice = input[j];
                int profit = sellPrice - buyingPrice;
                if(profit > globalMax){
                    globalMax = profit;
                    res[0] = i;
                    res[1] = j;
                    res[2] = globalMax;
                }
            }
        }
        return res;
    }

    /**
     * O(n)
     * Buying_Selling Stock LeetCode 121
     *
     *      { 7,1,5,3,6,4};
     */
    public int[] SP2(int[] input) {
        int[] res = new int[3];
        int minIndex = 0;
        for( int i = 0; i < input.length; i++) {
            int profit = input[i] - input[minIndex];
            if(profit > res[2]) {
                res[0] = minIndex;
                res[1] = i;
                res[2] = profit;
            } else if( profit < 0) {
                minIndex = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BuySellStock sp = new BuySellStock();
//        int[] input = new int[] {1,3,275,-14,9,14,2,1,1, -9, 125,-123};
        int[] input = new int[] { 7,1,5,3,6,4};
//        int[] res = sp.SP(input);
        int[] res = sp.SP2(input);
        System.out.println(Arrays.toString(res));

    }
}
