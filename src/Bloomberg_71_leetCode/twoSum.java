package Bloomberg_71_leetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class twoSum {
    /**
     * if the array is sorted
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int [] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while(i < j) {
            if(nums[i] + nums[j] == target) {
                System.out.println(i + " " + j);
                System.out.println(nums[i] + " " + nums[j]);
                return new int[]{i, j};
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        twoSum ts = new twoSum();
        int[] arr = new int[] {3,2,4};
        System.out.println(Arrays.toString(ts.twoSum(arr,6)));
    }

    /**
     * if the array is not sorted
     */
    public int [] twoSum2(int[] nums, int target) {
        // using hashMap
        if(nums == null || nums.length == 0) {
            return new int[] {-1,-1};
        }
        Map<Integer, Integer> map = new HashMap<>();
        // map<numNeeded, idx of who needs that num>
        for(int i = 0; i < nums.length; i++) {
            int resIdx = map.getOrDefault(nums[i], -1);
            if(resIdx != -1) {
                return new int[] {resIdx, i};
            }
            map.put(target - nums[i],i);
        }
        return new int[] {-1, -1};
    }

    //-------- prac ----------
    public int[] twoSum4(int[] nums, int target) {
        // val : pos
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++ ) {
            Integer pos1 = map.getOrDefault(nums[i], null);
            if(pos1 != null) {
                return new int[] {pos1, i};
            }
            map.putIfAbsent(target - nums[i], i);
        }
        return new int[] {-1, -1};
    }
}
