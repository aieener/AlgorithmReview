package alg.oracle.onsite;

/*
leetcode 518
knapsack problem
 */
public class CoinChangeII {
  /*
  dp[i][j] : the number of combinations to make up amount j by using the first i types of coins
State transition:
  case 1: not using the ith coin, only using the first i-1 coins to make up amount j, then we have dp[i-1][j] ways.
  case 2: using the ith coin, since we can use unlimited same coin, we need to know how many ways to make up amount j - coins[i-1]
    by using first i coins(including ith), which is dp[i][j-coins[i-1]]
  Initialization: dp[i][0] = 1
   */
  public int change(int amount, int[] coins) {
    int[][] dp = new int[coins.length + 1][amount + 1];
    dp[0][0] = 1;

    for (int i = 1; i <= coins.length; i++) {
      dp[i][0] = 1;
      for (int j = 1; j <= amount; j++) {
        dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
      }
    }
    return dp[coins.length][amount];
  }

  /*
  Initiate number of combinations array with the base case "no coins": dp[0] = 1, and all the rest = 0.

  Loop over all coins:

  For each coin, loop over all amounts from 0 to amount:
  For each amount x, compute the number of combinations: dp[x] += dp[x - coin].
  Return dp[amount].
   */

  public int changeOptSpace(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;
    for (int coin : coins) {
      for (int i = coin; i <= amount; i++) {
        dp[i] += dp[i - coin];
      }
    }
    return dp[amount];
  }
}
