package alg.laioffer.class31.adv5bfsIIRainWater.impl;


import alg.laioffer.class31.adv5bfsIIRainWater.MaxWaterTrappedOne;

public class MaxWaterTrappedOneImpl implements MaxWaterTrappedOne {
    @Override
    public int maxTrapped(int[] array) {
        if(array == null || array.length == 0) return 0;
        int totalAmt = 0;
        int leftMax = array[0];
        int rightMax = array[array.length - 1];
        int left = 0;
        int right = array.length - 1;
        while(left < right) {
            if(leftMax < rightMax) {
                totalAmt += Math.max(0, leftMax - array[left++]);
                leftMax = Math.max(leftMax, array[left]);
            } else {
                totalAmt += Math.max(0, rightMax - array[right--]);
                rightMax = Math.max(rightMax, array[right]);
            }
        }
        return totalAmt;
    }
}
