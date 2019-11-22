package alg.laioffer.class27.adv4dfsII.impl;

import alg.laioffer.class27.adv4dfsII.TwoSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumImpl implements TwoSum {
    @Override
    public List<List<Integer>> allPairs(int[] array, int target) {
        Arrays.sort(array);
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int curVar = array[start] + array[end];
            if (curVar == target) {
                res.add(Arrays.asList(new Integer[]{array[start], array[end]}));
                start++;
                end--;
                while (start < end && array[start] == array[start - 1]) start++;
            } else if (curVar > target) {
                end--;
            } else {
                start++;
            }
        }
        return res;
    }
}
