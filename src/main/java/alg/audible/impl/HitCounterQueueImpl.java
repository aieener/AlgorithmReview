package alg.audible.impl;

import alg.audible.HitCounter;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounterQueueImpl implements HitCounter {
    // like a sliding window!
    private Queue<Integer> q;

    public HitCounterQueueImpl() {
        q = new LinkedList<Integer>();

    }

    public void hit(int timestamp) {
        while (!q.isEmpty() && q.peek() + 300 <= timestamp) {
            q.poll();
        }
        q.add(timestamp);
    }

    public int getHits(int timestamp) {
        while (!q.isEmpty() && q.peek() + 300 <= timestamp) {
            q.poll();
        }
        return q.size();
    }
}
