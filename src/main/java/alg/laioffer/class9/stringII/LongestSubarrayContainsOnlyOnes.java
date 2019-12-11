package alg.laioffer.class9.stringII;

/*
    nums only has 0 and 1, we can swap k times to let 0 become 1
    this question really asking to find longest subarray that has at most k '0's
    sliding window
 */
public interface LongestSubarrayContainsOnlyOnes {
    int longestConsecutiveOnes(int[] nums, int k);
}
