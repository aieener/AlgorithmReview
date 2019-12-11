package alg.laioffer.class7.dfs.impl;

import alg.laioffer.class7.dfs.CombinationOfCoins;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS EX 3
 * Last review Aug 31 2019
 * USE Arr will be faster than use List!
 * <p>
 * ------ initial review comment ----------
 * Coin value 25 10 5 1
 * print all combination of coins that sum up to a total value k
 * 1. what does it store on each level? (每层代表什么意义， 一般解题前就知道DFS要recur多少层)
 * 4 level (if take 99/n level , it can cause stack over flow!)
 * 2. how many different states should we try to put on this level
 * depends on input value (25 : 4; 10 : 10 + 8 + 5 + 2 < 99; 5 : ...)
 * <p>
 * T = O (n^4)
 * space = O(4)
 * iteration, it then 一头扎到地　后回溯
 * root(99)
 * /        |         |          \
 * 25        0(99)     1(74)      2(49)      3(24)
 * /|||||||||\
 * 10     0(99) 1(89)...
 * 5
 * 1
 */
public class CombinationOfCoinsImpl implements CombinationOfCoins {
    @Override
    public List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(target, coins, 0, res, new int[coins.length]);
        return res;
    }

    private void dfs(int target, int[] coins, int level, List<List<Integer>> res, int[] freq) {
        // base case reach last level
        if (level == coins.length - 1) {
            // check last level and add if targetNum made
            if (target % coins[level] == 0) {
                freq[level] = target / coins[level];
                res.add(getList(freq));
            }
            return;
        }

        int curVal = coins[level];
        int numOfBranch = target / curVal;
        for (int i = 0; i <= numOfBranch; i++) {
            int newTarget = target - i * curVal;
            freq[level] = i;
            dfs(newTarget, coins, level + 1, res, freq);
        }
    }

    private List<Integer> getList(int[] freq) {
        List<Integer> res = new ArrayList<>();
        for (Integer val : freq) {
            res.add(val);
        }
        return res;
    }
}
