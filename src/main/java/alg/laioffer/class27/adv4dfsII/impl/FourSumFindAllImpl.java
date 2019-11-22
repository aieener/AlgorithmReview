package alg.laioffer.class27.adv4dfsII.impl;

import alg.laioffer.class27.adv4dfsII.FourSumFindAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Nov 21, 19
 */
public class FourSumFindAllImpl implements FourSumFindAll {
    @Override
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        /**
         * i   j| do two sum from j + 1 to end
         */
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int curTar = target - nums[i] - nums[j];
                twoSum(nums, j + 1, curTar, res, j, i);
            }
        }
        return res;
    }

    private void twoSum(int[] nums, int start, int target, List<List<Integer>> res, int j, int i) {
        int end = nums.length - 1;
        while (start < end) {
            int curSum = nums[start] + nums[end];
            if (curSum == target) {
                res.add(Arrays.asList(new Integer[]{nums[i], nums[j], nums[start], nums[end]}));
                start++;
                while (start < end && nums[start] == nums[start - 1]) start++;
            } else if (curSum > target) {
                end--;
            } else {
                start++;
            }
        }
    }
}
