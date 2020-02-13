package alg.oa.microsoftleetcodeMock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
 */
public class MajorityElem {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int slow = 0;
        int fast = 0;
        int threshold = nums.length / 3;
        for (; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                if (fast - slow > threshold) {
                    res.add(nums[slow]);
                }
                slow = fast;
            }
        }
        if (fast - slow > threshold) {
            res.add(nums[slow]);
        }
        return res;
    }
}
