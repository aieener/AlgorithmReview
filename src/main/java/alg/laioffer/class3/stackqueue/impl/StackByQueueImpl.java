package alg.laioffer.class3.stackqueue.impl;

import alg.laioffer.class3.stackqueue.StackByQueue;

import java.util.LinkedList;
import java.util.Queue;

/*
    make pop costly
 */
public class StackByQueueImpl implements StackByQueue {
    Queue<Integer>  queue;

    public StackByQueueImpl() {
        queue = new LinkedList<>();
    }

    /*
        O(n)
        原地rotate queue, queue is always in stack order!
        orig : 3 2 1, now push 4, shape queue to be 4 3 2 1
        step 1 | 3 2 1 4 offer (4)
        step 1 | 2 1 4 3 shuffle
        step 1 | 1 4 3 2 shuffle
        step 1 | 4 3 2 1 shuffle
     */
    @Override
    public void push(int x) {
        queue.offer(x);
        int size = queue.size();
        while(size > 1) {
            queue.offer(queue.poll());
            size--;
        }
    }

    @Override
    public Integer pop() {
        return queue.poll();
    }

    @Override
    public Integer top() {
        return queue.peek();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
