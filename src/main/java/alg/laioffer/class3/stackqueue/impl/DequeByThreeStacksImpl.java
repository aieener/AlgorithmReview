package alg.laioffer.class3.stackqueue.impl;

import alg.laioffer.class3.stackqueue.DequeByThreeStacks;

import java.util.Deque;
import java.util.LinkedList;

public class DequeByThreeStacksImpl implements DequeByThreeStacks {
    /*
        1 3 5 7 6 4 --> into Queue:
        1 3 5 | stack 1 firstOps
        4 6 7 | stack 2 lastOps
     */

    Deque<Integer> firstStack, lastStack, bufferStack;

    public DequeByThreeStacksImpl() {
        firstStack = new LinkedList<>();
        lastStack = new LinkedList<>();
        bufferStack = new LinkedList<>();
    }

    @Override
    public void offerFirst(int element) {
        firstStack.push(element);
    }

    /*
        make | firstStack.len - lastStack.len | <= 1
     */
    private void makeTwoStackBalance() {
        int targetSize = (firstStack.size() + lastStack.size()) / 2;
        Deque<Integer> bigger, smaller;
        bigger = firstStack.size() > lastStack.size() ? firstStack : lastStack;
        smaller = firstStack.size() < lastStack.size() ? firstStack : lastStack;

        // take targetSize elem from bigger stack to buf
        int count = 0;
        while (count < targetSize) {
            bufferStack.push(bigger.pop());
            count++;
        }
        // move the overhead from bigger to smaller stack
        while (!bigger.isEmpty()) {
            smaller.push(bigger.pop());
        }
        // move buffer back to bigger
        while (!bufferStack.isEmpty()) {
            bigger.push(bufferStack.pop());
        }
    }

    @Override
    public void offerLast(int element) {
        lastStack.push(element);
    }

    @Override
    public Integer pollFirst() {
        if (isEmpty()) return null;
        if (firstStack.isEmpty()) {
            makeTwoStackBalance();
        }
        return firstStack.pop();
    }

    @Override
    public Integer pollLast() {
        if (isEmpty()) return null;
        if (lastStack.isEmpty()) {
            makeTwoStackBalance();
        }
        return lastStack.pop();
    }

    @Override
    public Integer peekFirst() {
        if (isEmpty()) return null;
        if (firstStack.isEmpty()) {
            makeTwoStackBalance();
        }
        return firstStack.peek();
    }

    @Override
    public Integer peekLast() {
        if (isEmpty()) return null;
        if (lastStack.isEmpty()) {
            makeTwoStackBalance();
        }
        return lastStack.peek();
    }

    @Override
    public int size() {
        return firstStack.size() + lastStack.size();
    }

    @Override
    public boolean isEmpty() {
        return firstStack.isEmpty() && lastStack.isEmpty();
    }
}
