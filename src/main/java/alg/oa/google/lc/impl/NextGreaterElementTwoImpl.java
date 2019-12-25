package alg.oa.google.lc.impl;

import alg.oa.google.lc.NextGreaterElementTwo;

import java.util.Deque;
import java.util.LinkedList;

public class NextGreaterElementTwoImpl implements NextGreaterElementTwo {
    @Override
    public int[] nextGreaterElement(int[] nums) {
        int[] res = new int[nums.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            int curIdx = (i % nums.length);
            while (!stack.isEmpty() && nums[curIdx] >= stack.peek()) {
                stack.pop();
            }
            res[curIdx] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[curIdx]);
        }
        return res;
    }
}
