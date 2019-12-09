package alg.laioffer.class3.stackqueue.impl;

import alg.laioffer.class3.stackqueue.MinStack;

import java.util.Deque;
import java.util.LinkedList;
/*
    This problem: minStack is increasing stack as respect to top | i1 < i2 < i2 < top
        at all times, top is always smallest
        we also note down the size of mainStack when add elem to minStack
        when minStack.top.sizeIn > mainStack, then it's time to pop

    This is the easy version of max val in sliding window!
        maxValInSlidingWindow uses Decreasing Deque,
            if incoming element is BIGGER and NEWER then last, then remove last util not bigger,
            then append to last.
            at all times, the maxVal in Sliding window is always at front
 */
public class MinStackImpl implements MinStack {
    static class MinStruct {
        int val, sizeIn;
        public MinStruct(int val, int sizeIn) {
            this.val = val;
            this.sizeIn = sizeIn;
        }
    }
    private Deque<Integer> stack;
    private Deque<MinStruct> minStack;


    public MinStackImpl() {
        this.stack = new LinkedList<>();
        this.minStack = new LinkedList<>();
    }

    public int pop() {
        int res = -1;
        if(stack.size() > 0) {
            res = stack.pop();
            updateMinStack();
        }
        return res;
    }

    private void updateMinStack() {
        if(minStack.peek().sizeIn > stack.size()) {
            minStack.pop();
        }
    }

    public void push(int element) {
        stack.push(element);
        if(minStack.isEmpty() || element < minStack.peek().val) {
            minStack.push(new MinStruct(element, stack.size()));
        }
    }

    public int top() {
        return stack.size() > 0 ? stack.peek() : -1;
    }

    public int min() {
        return minStack.size() > 0 ? minStack.peek().val : -1;
    }
}
