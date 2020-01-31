package alg.audible.impl;

import alg.audible.ClosestNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class ClosestNumberImpl implements ClosestNumber {
    @Override
    public List<int[]> closestNumber(int[] nums) {
        Arrays.sort(nums);
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        for (int i = 1; i < nums.length; i++) {
            map.putIfAbsent(nums[i] - nums[i - 1], new ArrayList<>());
            map.get(nums[i] - nums[i - 1]).add(new int[]{nums[i - 1], nums[i]});
        }
        return map.firstEntry().getValue();
    }
}
