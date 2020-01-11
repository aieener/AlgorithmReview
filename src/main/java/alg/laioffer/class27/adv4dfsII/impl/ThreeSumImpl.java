package alg.laioffer.class27.adv4dfsII.impl;

import alg.laioffer.class27.adv4dfsII.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumImpl implements ThreeSum {
    @Override
    public List<List<Integer>> allTriples(int[] array, int target) {
        Arrays.sort(array);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < array.length - 2; i++) {
            if (i > 0 && array[i] == array[i - 1]) continue; // DEDUP
            int curTar = target - array[i];
            twoSum(array, i, curTar, result);
        }
        return result;
    }

    private void twoSum(int[] array, int leftBorder, int target, List<List<Integer>> res) {
        int start = leftBorder + 1;
        int end = array.length - 1;
        while (start < end) {
            int curVal = array[start] + array[end];
            if (curVal == target) {
                res.add(Arrays.asList(new Integer[]{array[leftBorder], array[start], array[end]}));
                start++;
                end--;
                while (start < end && array[start] == array[start - 1]) start++; // DEDUP
            } else if (curVal > target) {
                end--;
            } else {
                start++;
            }
        }
    }

    public static void main(String[] args) {
        int[] input = new int[] {1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(new ThreeSumImpl().allTriples(input, 3).toString());
    }
}
