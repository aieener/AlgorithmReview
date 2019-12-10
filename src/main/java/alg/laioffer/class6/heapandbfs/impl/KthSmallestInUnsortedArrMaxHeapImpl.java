package alg.laioffer.class6.heapandbfs.impl;

import alg.laioffer.class6.heapandbfs.KthSmallestInUnsortedArr;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestInUnsortedArrMaxHeapImpl implements KthSmallestInUnsortedArr {
    @Override
    public int[] kSmallest(int[] array, int k) {
        if (k == 0) return new int[]{};
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer val : array) {
            if (maxHeap.size() < k) {
                maxHeap.offer(val);
            } else if (val < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(val);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[k - i - 1] = maxHeap.poll();
        }
        return res;
    }
}
