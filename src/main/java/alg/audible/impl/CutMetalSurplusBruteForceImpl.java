package alg.audible.impl;

import alg.audible.CutMetalSurplus;

public class CutMetalSurplusBruteForceImpl implements CutMetalSurplus {
    public static void main(String[] args) {
        CutMetalSurplus engine = new CutMetalSurplusBruteForceImpl();
        int cutCost1 = 1, price1 = 10;
        int[] nums1 = {26, 59, 103};
        int cutCost2 = 100, price2 = 10;
        int[] nums2 = {26, 59, 103};
        int cutCost3 = 1, price3 = 10;
        int[] nums3 = {30, 59, 110};
        System.out.println(engine.maxProfit(nums1, cutCost1, price1));
        System.out.println(engine.maxProfit(nums2, cutCost2, price2));
        System.out.println(engine.maxProfit(nums3, cutCost3, price3));
    }

    @Override
    public int maxProfit(int[] nums, int cutCost, int price) {
        int maxLen = nums[0];
        for (int num : nums) {
            maxLen = Math.max(num, maxLen);
        }
        int max = getCost(nums, cutCost, price, 1);
        for (int i = 2; i < maxLen + 1; i++) {
            max = Math.max(getCost(nums, cutCost, price, i), max);
        }
        return max;
    }

    private int getCost(int[] nums, int cutCost, int price, int len) {
        if (len == 0) return 0;
        int profit = 0;
        int cost = 0;
        for (int num : nums) {
            int amt = num / len;
            profit += amt * price * len;
            if (num % len == 0) {
                cost += cutCost * (amt - 1);
            } else {
                cost += cutCost * amt;
            }
        }
        return profit - cost;
    }
}
