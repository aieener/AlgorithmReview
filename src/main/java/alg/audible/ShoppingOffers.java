package alg.audible;

import java.util.List;

/*
leetcode 638
dfs
also look at coin change at imooc.dp : leetcode 322 --> knapsack problem
 */
public interface ShoppingOffers {
    int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs);
}
