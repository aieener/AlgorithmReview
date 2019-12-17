package alg.laioffer.class9.stringII.impl;

import alg.laioffer.class9.stringII.LongestSubarrayContainsOnlyOnes;


public class LongestSubarrayContainsOnlyOnesImpl implements LongestSubarrayContainsOnlyOnes {

    /*
        [slow, fast) contains at most k 0s
        len = fast - slow
     */
    @Override
    public int longestConsecutiveOnes(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int count = 0;
        int slow = 0;
        int fast = 0;
        int res = 0;
        // window [slow, fast) including fast
        // 0,1,1,1,1,1,0,1,1,0,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0
        //                                                 f
        //   s
        for(; fast < nums.length; fast++) {
            if(nums[fast] == 0) count++;
            while(slow < nums.length && count > k) {
                if(nums[slow] == 0) {
                    count--;
                }
                slow++;
            }
            res = Math.max(res, fast - slow + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[]{0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0};
        LongestSubarrayContainsOnlyOnes engine = new LongestSubarrayContainsOnlyOnesImpl();

        System.out.println(engine.longestConsecutiveOnes(input, 4));
    }
}
