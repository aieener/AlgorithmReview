package Class_06_DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Tried at Jan 3 failed, check solution
 * DFS's for loop is for each layer and inside each
 * iteration, it then 一头扎到地　后回溯
 *                         root(99)
 *              /        |         |          \
 *  25        0(99)     1(74)      2(49)      3(24)
 *           /|||||||||\
 *  10     0(99) 1(89)...
 *
 *  5
 *
 *  1
 */
public class CombinationsCoins {
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
