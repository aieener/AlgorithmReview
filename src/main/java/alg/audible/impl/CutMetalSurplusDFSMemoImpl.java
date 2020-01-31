package alg.audible.impl;

import alg.audible.CutMetalSurplus;

public class CutMetalSurplusDFSMemoImpl implements CutMetalSurplus {
    public static void main(String[] args) {
        CutMetalSurplus engine = new CutMetalSurplusDFSMemoImpl();
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
        int maxLen = 0;
        for (int n : nums) {
            maxLen = Math.max(maxLen, n);
        }
        int[][] M = new int[maxLen + 1][maxLen + 1];
        return dfsWithMemo(nums, cutCost, price, 0, maxLen, M);
    }

    private int dfsWithMemo(int[] nums, int cutCost, int price, int left, int right, int[][] M) {
        if (left >= right) return 0;
        int res = 0;
        if (M[left][right] != 0) return M[left][right];
        int mid = left + (right - left) / 2;
        int leftRes = dfsWithMemo(nums, cutCost, price, left, mid, M);
        int rightRes = dfsWithMemo(nums, cutCost, price, mid + 1, right, M);

        res = Math.max(getCost(nums, cutCost, price, mid), res);
        res = Math.max(res, Math.max(leftRes, rightRes));
        M[left][right] = res;
        return res;
    }

    private int getCost(int[] nums, int cutCost, int price, int length) {
        if (length == 0) return Integer.MIN_VALUE; // base case
        int profit = 0;
        int cutCosts = 0;
        for (int i = 0; i < nums.length; i++) {
            int numOfCuts = nums[i] / length;
            profit += numOfCuts * length * price;
            if (nums[i] % length != 0) {
                cutCosts += numOfCuts * cutCost;
            } else {
                cutCosts += (numOfCuts - 1) * cutCost;
            }
        }
        return profit - cutCosts;
    }
}
