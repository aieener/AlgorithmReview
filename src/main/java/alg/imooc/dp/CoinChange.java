package alg.imooc.dp;

/*
leetcode 322
You are given coins of different denominations and a total amount of money amount. Write a function to compute the
fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.

sol1: dfs naive
sol2: dfs with memo top down: 从大到小解决问题
sol3: dp: 从小到大解决问题
 */
public interface CoinChange {
    int coinChangeDP(int[] coins, int amount);

    int coinChangeDFSMemo(int[] coins, int amount);

    int coinChangeDFSNaive(int[] coins, int amount);

    int coinChangeDFSCoinLevelMemo(int[] coins, int amount);
}
