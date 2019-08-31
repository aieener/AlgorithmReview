package alg.laioffer.class7.dfs.impl;

import alg.laioffer.class7.dfs.CombinationOfCoins;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS EX 3
 * Last review Aug 31 2019
 * USE Arr will be faster than use List!
 *
 * Coin value 25 10 5 1
 * print all combination of coins that sum up to a total value k
 * 1. what does it store on each level? (每层代表什么意义， 一般解题前就知道DFS要recur多少层)
 *      4 level (if take 99/n level , it can cause stack over flow!)
 * 2. how many different states should we try to put on this level
 *      depends on input value (25 : 4; 10 : 10 + 8 + 5 + 2 < 99; 5 : ...)
 *
 * T = O (n^4)
 * space = O(4)
 * iteration, it then 一头扎到地　后回溯
 *                         root(99)
 *              /        |         |          \
 *  25        0(99)     1(74)      2(49)      3(24)
 *           /|||||||||\
 *  10     0(99) 1(89)...
 *  5
 *  1
 */
public class CombinationOfCoinsImpl implements CombinationOfCoins {
  @Override
  public List<List<Integer>> combinations(int target, int[] coins) {
    List<List<Integer>> res = new ArrayList<>();
    if (coins == null || coins.length == 0) return res;
    dfs(res, target, coins, 0, new int[coins.length]);
    return res;
  }

  private void dfs(List<List<Integer>> res, int target, int[] coins, int curLevel, int[] solution) {
    //base case
    if (curLevel == coins.length - 1) {
      int curCoinValue = coins[coins.length - 1];
      if (target % curCoinValue == 0) {
        solution[curLevel] = target / curCoinValue;
        res.add(arrToList(solution));
      }
      return;
    }

    int numOfBranch = target / coins[curLevel]; // 99 / 10 = 9
    for (int i = 0; i <= numOfBranch; i++) {
      int newTarget = target - i * coins[curLevel];
      if (newTarget < 0) break;
      solution[curLevel] = i;
      dfs(res, newTarget, coins, curLevel + 1, solution);
    }
  }

  private List<Integer> arrToList(int[] arr) {
    List<Integer> res = new ArrayList<>();
    for (Integer i : arr) res.add(i);
    return res;
  }
}
