package alg.laioffer.class3.stackqueue.impl;

import alg.laioffer.class3.stackqueue.QueueBy2Stack;

import java.util.Deque;
import java.util.LinkedList;

public class QueueBy2StackImpl implements QueueBy2Stack {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public QueueBy2StackImpl() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    @Override
    public Integer poll() {
        if (isEmpty()) return null;
        if (outStack.isEmpty()) {
            dumpInToOut();
        }
        return outStack.poll();
    }

    private void dumpInToOut() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }

    @Override
    public void offer(int element) {
        inStack.push(element);
    }

    @Override
    public Integer peek() {
        if (isEmpty()) return null;
        if (outStack.isEmpty()) {
            dumpInToOut();
        }
        return outStack.peek();
    }

    @Override
    public int size() {
        return inStack.size() + outStack.size();
    }

    @Override
    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
