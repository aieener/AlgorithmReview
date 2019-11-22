package alg.laioffer.class27.adv4dfsII.impl;

import alg.laioffer.class27.adv4dfsII.FourSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FourSumImpl implements FourSum {
    static class Pair {
        int left, right;

        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    @Override
    public boolean exist(int[] array, int target) {
        Map<Integer, Pair> lkup = new HashMap<>();
        Arrays.sort(array);
        for (int right = 0; right < array.length; right++) {
            for (int left = 0; left < right; left++) {
                int curSum = array[left] + array[right];
                if (!lkup.containsKey(curSum)) lkup.put(curSum, new Pair(left, right));
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                Pair leftPair = new Pair(i, j);
                int curTar = target - array[leftPair.left] - array[leftPair.right];
                if (lkup.containsKey(curTar) && lkup.get(curTar).right < i) {
                    return true;
                }
            }
        }
        return false;
    }
}
