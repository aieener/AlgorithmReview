package Bloomberg_71_leetCode;


import java.util.LinkedList;
import java.util.Queue;

public class ImplStackUsingQueue {
    /** Initialize your data structure here. */
    Queue<Integer> inQueue;
    Queue<Integer> outQueue;

    /**
     * --> end e --> front
     * --> end a d f  --> front
     */

    public ImplStackUsingQueue() {
        inQueue = new LinkedList<>();
        outQueue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(inQueue.isEmpty()) {
            inQueue.offer(x);
        } else {
            transferIntoOut();
            inQueue.offer(x);
            reset();
        }
        return;
    }
    private void reset() {
        while(!outQueue.isEmpty()) {
            inQueue.offer(outQueue.poll());
        }
        return;
    }

    private void transferIntoOut() {
        while(!inQueue.isEmpty()) {
            outQueue.offer(inQueue.poll());
        }
        return;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(! empty()) {
            return inQueue.poll();
        }
        return -1;
    }

    /** Get the top element. */
    public int top() {
        if(! empty()) {
            return inQueue.peek();
        }
        return -1;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return inQueue.isEmpty();
    }
}

class MyStack2 {
    private Queue<Integer> q1;
    private Queue<Integer> qbuffer;
    /**
     * S | 1 2 3 4
     * Q 4 3 2 1
     * Q
     */
    /** Initialize your data structure here. */
    public MyStack2() {
        q1 = new LinkedList<>();
        qbuffer = new LinkedList<>();
    }

    private void moveToBuffer() {
        if(qbuffer.isEmpty()) {
            while(!q1.isEmpty()) {
                qbuffer.offer(q1.poll());
            }
        }
        return;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        moveToBuffer();
        q1.offer(x);
        while(!qbuffer.isEmpty()) {
            q1.offer(qbuffer.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.poll();
    }

    /** Get the top element. */
    public int top() {
        return q1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && qbuffer.isEmpty();
    }
}

