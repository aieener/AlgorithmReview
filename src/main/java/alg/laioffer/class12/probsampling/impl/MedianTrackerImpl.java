package alg.laioffer.class12.probsampling.impl;

import alg.laioffer.class12.probsampling.MedianTracker;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianTrackerImpl implements MedianTracker {
    private Queue<Integer> minHeap = new PriorityQueue<>();
    private Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    @Override
    public void read(int value) {
        if(minHeap.isEmpty()) {
            minHeap.offer(value);
        } else {
            int midBigger = minHeap.peek();
            if (value > midBigger) {
                minHeap.offer(value);
            } else {
                maxHeap.offer(value);
            }
        }
    }

    @Override
    public Double median() {
        int size = getSize();
        if (size == 0) {
            return null;
        } else if (size % 2 == 0) {
            balance(size / 2); // minHeap = maxHeap = size / 2
            int smaller = maxHeap.peek();
            int bigger = minHeap.peek();
            return (1.0 * smaller + 1.0 * bigger)/ 2;
        } else {
            balance(size / 2 + 1); // minHeap = size / 2 + 1
            return (double) minHeap.peek();
        }
    }

    private void balance(int targetMinHeapSize) {
        while (minHeap.size() > targetMinHeapSize) {
            maxHeap.offer(minHeap.poll());
        }
        while (minHeap.size() < targetMinHeapSize) {
            minHeap.offer(maxHeap.poll());
        }
    }

    private int getSize() {
        return minHeap.size() + maxHeap.size();
    }
}
