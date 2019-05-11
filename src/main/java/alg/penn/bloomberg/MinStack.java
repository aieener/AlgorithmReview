package alg.penn.bloomberg;

import java.awt.print.PrinterGraphics;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by yuding on 2/10/18.
 * LeetCode 155, LaiCode also have this one
 */
public class MinStack {
    /**
     * My Impl
     *  stack     -2  0 -3
     *  minStack  -2 -2 -3
     */
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push (int x) {
        stack.offerFirst(x);
        int elem = stack.peekFirst();
        if(minStack.isEmpty() || elem < minStack.peekFirst()){
            minStack.offerFirst(x);
        } else {
            minStack.offerFirst(minStack.peekFirst());
        }
    }

    public void pop () {
        stack.pollFirst();
        minStack.pollFirst();
    }

    public int top () {
        return stack.peekFirst();
    }

    public int getMin() {
        return minStack.peekFirst();
    }

    /**
     * Lai Optimized version
     */
    public void push2 (int x) {
        stack.offerFirst(x);
        int elem = stack.peekFirst();
        if(minStack.isEmpty() || elem <= minStack.peekFirst()){
            minStack.offerFirst(x);
        }
    }

    public void pop2 () {
        if(stack.isEmpty()){
            return ;
        }
        Integer res = stack.pollFirst();
        if(minStack.peekFirst().equals(res)){
            minStack.pollFirst();
        }
    }

    public int top2 () {
        return stack.peekFirst();
    }

    public int getMin2() {
        return minStack.peekFirst();
    }

}

class minStack {
    /** initialize your data structure here. */
    private Deque <Integer> stack;
    private Deque <Integer> minStack;
    public minStack() {
        stack = new LinkedList();
        minStack = new LinkedList();
    }

    public void push(int x) {
        if(minStack.isEmpty()) {
            minStack.offerFirst(x);
        } else if (x <= minStack.peekFirst()) {
            minStack.offerFirst(x);
        }
        stack.offerFirst(x);
    }

    public void pop() {
        if(stack.isEmpty()) {
            return;
        }
        int val = stack.peekFirst();
        if(val <= minStack.peekFirst()) {
            minStack.pollFirst();
        }
        stack.pollFirst();
    }

    public int top() {
        return stack.peekFirst();
    }

    public int getMin() {
        return minStack.peekFirst();
    }
}
