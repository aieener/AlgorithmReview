package alg.imooc.dp.impl;

import alg.imooc.dp.CoinChange;

import java.util.Arrays;

public class CoinChangeImpl implements CoinChange {
    @Override
    public int coinChangeDP(int[] coins, int amount) {
        int[] M = new int[amount + 1]; // M[i] represents minCoinAmt to make amount i;
        M[0] = 0;
        //recursive rule M[i] = min(M[i - coins[j]]) + 1;
        for (int i = 1; i <= amount; i++) {
            int curMin = Integer.MAX_VALUE;
            for (int coinVal : coins) {
                if (i - coinVal >= 0 && M[i - coinVal] != -1) {
                    curMin = Math.min(curMin, M[i - coinVal] + 1);
                }
            }
            M[i] = curMin == Integer.MAX_VALUE ? -1 : curMin;
        }
        return M[amount];
    }


    // ------ dfs with memo, each level have num of coins branches! tree can be very high
    @Override
    public int coinChangeDFSMemo(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] memo = new int[amount + 1]; // memo[i] represents minAmtOfCoin for amount i
        memo[0] = 0;
        return dfs(coins, amount, memo);
    }

    private int dfs(int[] coins, int amount, int[] memo) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (memo[amount] != 0) return memo[amount];
        int min = Integer.MAX_VALUE;
        for (int coinVal : coins) {
            int childRes = dfs(coins, amount - coinVal, memo);
            if (childRes >= 0 && childRes + 1 < min) {
                min = childRes + 1;
            }
        }
        memo[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return memo[amount];
    }

    //------------- Naive --------- tree is short, only num of coin types level
    @Override
    public int coinChangeDFSNaive(int[] coins, int amount) {
        if (amount < 1) return 0;
        return dfsNaive(coins, amount, 0);
    }


    private int dfsNaive(int[] coins, int amount, int level) {
        if (amount == 0) return 0;
        if (level < coins.length && amount > 0) {
            int coinVal = coins[level];
            int maxAmt = amount / coinVal;
            int minCost = Integer.MAX_VALUE;
            for (int i = 0; i <= maxAmt; i++) {
                if (amount - i * coinVal >= 0) {
                    int childRes = dfsNaive(coins, amount - i * coinVal, level + 1);
                    if (childRes != -1) {
                        minCost = Math.min(minCost, childRes + i);
                    }
                }
            }
            return (minCost == Integer.MAX_VALUE) ? -1 : minCost;
        }
        return -1;
    }

    //------ coin Level recurTree with memo ---> this case we have to sort the coin first!!!!
    @Override
    public int coinChangeDFSCoinLevelMemo(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] memo = new int[amount + 1];
        memo[0] = 0;
        Arrays.sort(coins);
        return dfsCoinLevelWithMemo(coins, amount, 0, memo);
    }

    private int dfsCoinLevelWithMemo(int[] coins, int amount, int level, int[] memo) {
        if (amount == 0) return 0;
        if (memo[amount] != 0) return memo[amount];
        if (level < coins.length && amount > 0) {
            int coinVal = coins[level];
            int maxAmt = amount / coinVal;
            int minCost = Integer.MAX_VALUE;
            for (int i = 0; i <= maxAmt; i++) {
                if (amount - i * coinVal >= 0) {
                    int childRes = dfsCoinLevelWithMemo(coins, amount - i * coinVal, level + 1, memo);
                    if (childRes != -1) {
                        minCost = Math.min(minCost, childRes + i);
                    }
                }
            }
            memo[amount] = (minCost == Integer.MAX_VALUE) ? -1 : minCost;
            return memo[amount];
        }
        return -1;
    }
}
