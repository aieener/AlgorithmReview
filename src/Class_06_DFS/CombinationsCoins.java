package Class_06_DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS EX 3
 * Last review Mar 13 2019
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
public class CombinationsCoins {
    // in class example
    public void findCombinatino(int moneyLeft, int level, int[] sol) {
        if(level == 3) {
            sol[level] = moneyLeft;
            // print sol here and return
        }
        for(int i = 0; sol[level] * i <= moneyLeft; i++) {
            sol[level] = i; // because this is not container class, we just override array value here
            findCombinatino(moneyLeft - sol[level] * i, level + 1, sol);
//            sol[level] = 0; // back track, not necessary for non-container class
        }
    }

    public List<List<Integer>> combinations(int target, int [] coins) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(coins, target, res, cur, 0);
        return res;
    }

    private void dfs(int[] coins, int target, List<List<Integer>> res, List<Integer> cur, int idx){
        // base case
        if(idx == coins.length - 1){
            if(target % coins[coins.length - 1] == 0){
                cur.add(target / coins[coins.length - 1]);
                res.add(new ArrayList<>(cur));
                cur.remove(cur.size() - 1);
            }
            return;
        }
        // for coins[idx], we can pick 0, 1, 2, ... , target / coins[idx] coins
        int max = target / coins[idx]; // ths max is the number of branch at each level
        for(int i = 0; i <= max; i++){
            cur.add(i);
            dfs(coins,target - i * coins[idx], res, cur,idx + 1);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationsCoins cc = new CombinationsCoins();
        List<List<Integer>> res = cc.combinations(4, new int[]{2,1});
        System.out.println(res);

    }

    // --- prac ---

}
