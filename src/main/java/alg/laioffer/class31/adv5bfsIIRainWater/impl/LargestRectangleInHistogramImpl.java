package alg.laioffer.class31.adv5bfsIIRainWater.impl;

import alg.laioffer.class31.adv5bfsIIRainWater.LargestRectangleInHistogram;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleInHistogramImpl implements LargestRectangleInHistogram {
    @Override
    public int largest(int[] array) {
        int res = 0;
        Deque<Integer> stack = new LinkedList<>(); // stack store the idx!
        for (int i = 0; i <= array.length; i++) {
            int cur = i == array.length ? 0 : array[i];
            while (!stack.isEmpty() && array[stack.peekFirst()] > cur) {
                int height = array[stack.pollFirst()];
                int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
                res = Math.max(res, height * (i - left));
            }
            stack.offerFirst(i);
        }
        return res;
    }
}
