package alg.laioffer.class9.stringII.impl;

import alg.laioffer.class9.stringII.LongestSubarrayContainsOnlyOnes;


public class LongestSubarrayContainsOnlyOnesImpl implements LongestSubarrayContainsOnlyOnes {

    /*
        [slow, fast) contains at most k 0s
        len = fast - slow
     */
    @Override
    public int longestConsecutiveOnes(int[] nums, int k) {
        if(k > 0 && nums.length == 1) return 1;
        int slow = 0;
        int counter = 0;
        int globalRes = 0;
        for(int fast = 0; fast < nums.length; fast++) {
            if(nums[fast] == 0) counter++;
            while(counter > k && slow <= fast) { // this is crucial, we have to make sure they cross to handle edge cases
                if(nums[slow] == 0) counter--;
                slow++;
            }
            globalRes = Math.max(fast - slow + 1, globalRes);
        }
        return globalRes;
    }

    public static void main(String[] args) {
        int [] input = new int[] {0};
        LongestSubarrayContainsOnlyOnes engine = new LongestSubarrayContainsOnlyOnesImpl();
        System.out.println(engine.longestConsecutiveOnes(input,0));
    }
}
