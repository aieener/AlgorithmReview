package alg.audible.impl;

import alg.audible.ShoppingOffers;

import java.util.*;

public class ShoppingOffersImpl implements ShoppingOffers {
    @Override
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int[] res = new int[]{Integer.MAX_VALUE};
        int[] spacialsTaken = new int[special.size()];
        Set<Integer> memo = new HashSet<>();
        dfs(price, special, needs, res, spacialsTaken, 0, memo);
        return res[0];
    }

    private Integer hash(int[] specialsTaken, int level) {
        int code = 0;
        int prime = 31;
        for (int i = 0; i < level; i++) {
            code = code * prime + specialsTaken[i];
        }
        return code;
    }

    private void dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int[] res, int[] specialsTaken,
                     int level, Set<Integer> memo) {
        // base case
        if (memo.contains(hash(specialsTaken, level))) return;
        if (level == specialsTaken.length) {
            Integer cost = cost(specialsTaken, price, needs, special);
            res[0] = Math.min(res[0], cost);
            return;
        }
        List<Integer> currentCoupon = special.get(level);
        int maxItemAmtFromCoupon = 0;
        for (int i = 0; i < currentCoupon.size() - 1; i++) {
            maxItemAmtFromCoupon = Math.max(currentCoupon.get(i), maxItemAmtFromCoupon);
        }
        int maxItemAmtFromNeeds = 0;
        for (int i = 0; i < needs.size(); i++) {
            maxItemAmtFromNeeds = Math.max(needs.get(i), maxItemAmtFromNeeds);
        }

        int amtCouponCanbeTaken = maxItemAmtFromNeeds / maxItemAmtFromCoupon;
        // pruning here
        memo.add(hash(specialsTaken, level));
        for (int i = 0; i <= amtCouponCanbeTaken; i++) {
            for (int j = 0; j < needs.size(); j++) {
                needs.set(j, needs.get(j) - i * currentCoupon.get(j));
            }
            for (int j = 0; j < needs.size(); j++) {
                specialsTaken[level] = i;
                dfs(price, special, needs, res, specialsTaken, level + 1, memo);
            }
            for (int j = 0; j < needs.size(); j++) {
                needs.set(j, needs.get(j) + i * currentCoupon.get(j));
            }
        }
    }

    private int cost(int[] specialsTaken, List<Integer> price, List<Integer> needs, List<List<Integer>> special) {
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) < 0) return Integer.MAX_VALUE;
        }
        int cost = 0;
        int couponPriceIdx = special.get(0).size() - 1;
        for (int i = 0; i < specialsTaken.length; i++) {
            int couponCost = specialsTaken[i] * special.get(i).get(couponPriceIdx);
            cost += couponCost;
        }

        for (int i = 0; i < needs.size(); i++) {
            int buyItemCost = price.get(i) * needs.get(i);
            cost += buyItemCost;
        }
        return cost;
    }

    public static void main(String[] args) {
        ShoppingOffers engine = new ShoppingOffersImpl();
        List<Integer> price = Arrays.asList(4, 3, 2, 9, 8, 8);
        List<List<Integer>> special = Arrays.asList(Arrays.asList(1, 5, 5, 1, 4, 0, 18), Arrays.asList(3, 3, 6, 6, 4, 2, 32));
        List<Integer> needs = Arrays.asList(6, 5, 5, 6, 4, 1);
        System.out.println(engine.shoppingOffers(price, special, needs));
    }
}
