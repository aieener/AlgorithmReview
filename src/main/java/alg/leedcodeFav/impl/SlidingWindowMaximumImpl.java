package alg.leedcodeFav.impl;

import alg.leedcodeFav.SlidingWindowMaximum;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximumImpl implements SlidingWindowMaximum {
    @Override
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return nums;
        Deque<Integer> decreasingQueue = new LinkedList<>();
        int resLen = nums.length - k + 1;
        int[] res = new int[resLen];
        for(int i = 0; i < nums.length; i++) {
            while(!decreasingQueue.isEmpty() && nums[decreasingQueue.peekLast()] < nums[i]) {
                decreasingQueue.pollLast();
            }
            decreasingQueue.offerLast(i);
            int windowStart = i - k + 1;
            if(windowStart >= 0) {
                while(!decreasingQueue.isEmpty() && decreasingQueue.peekFirst() < windowStart) {
                    decreasingQueue.pollFirst();
                }
                res[windowStart] = nums[decreasingQueue.peekFirst()];
            }
        }
        return res;
    }
}
