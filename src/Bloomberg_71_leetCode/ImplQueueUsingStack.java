package Bloomberg_71_leetCode;

import java.util.Deque;
import java.util.LinkedList;


public class ImplQueueUsingStack {
    /**
     * My Sol
     *  the crutial part is move st1 and st2
     *  only move when st2 is empty!!!
     */
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;
    private int size;

    public ImplQueueUsingStack() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
        size = 0;
    }

    public void push(int x) {
        stack1.offerFirst(x);
        size++;
    }

    public int pop() {
        stackShuffle();
        if(stack2.isEmpty()) {
            return 0;
        } else {
            size--;
            return stack2.pollFirst();
        }
    }

    public int peek() {
        stackShuffle();
        if(stack2.isEmpty()) {
            return 0;
        } else {
            return stack2.peekFirst();
        }
    }

    public boolean empty() {
        return size == 0;
    }

    private void stackShuffle() {
        if(stack2.isEmpty()) { // this line is crutial!!
            while(! stack1.isEmpty()) {
                stack2.offerFirst(stack1.pollFirst());
            }
        }
        return;
    }
}

class MyQueue2 {
    Deque<Integer> inStack ;
    Deque<Integer> outStack;

    /**
     *  Q 1 2 3 4 5
     *
     * S1 4
     * S2 3 2 1
     *
     */

    /** Initialize your data structure here. */
    public MyQueue2() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    private void shuffle() {
        // only allowed to shuffle when outStack is empty
        if(outStack.isEmpty()) {
            while(!inStack.isEmpty()) {
                outStack.offerFirst(inStack.pollFirst());
            }
        }
    }
    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.offerFirst(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        shuffle();
        return outStack.pollFirst();
    }

    /** Get the front element. */
    public int peek() {
        shuffle();
        return outStack.peekFirst();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();

    }
}
