package alg.leedcodeFav.slidingwindow.impl;

import alg.leedcodeFav.slidingwindow.SlidingWindowMedian;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeSet;

public class SlidingWindowMedianImpl implements SlidingWindowMedian {
    static class Pair{
        Integer idx, val;
        public Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
    static class MinComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair base, Pair other) {
            if(base.val.compareTo(other.val) > 0) return 1;
            else if (base.val.compareTo(other.val) < 0) return -1;
            else return base.idx - other.idx;// the smaller idx, the toper
        }
    }
    static class MaxComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair base, Pair other) {
            if(other.val.compareTo(base.val) > 0) return 1;
            else if (other.val.compareTo(base.val) < 0) return -1;
            else return base.idx - other.idx;// the smaller idx, the toper
        }
    }
    public double[] medianSlidingWindow(int[] nums, int k) {
        TreeSet<Pair> maxHeap = new TreeSet<>(new MaxComparator());  // smaller half len = k - k / 2; they store the index
        TreeSet<Pair> minHeap = new TreeSet<>(new MinComparator());  // greater half len = k / 2

        double [] res = new double[nums.length - k + 1];
        for(int winEnd = 0; winEnd < nums.length; winEnd++) {
            if(!minHeap.isEmpty() && nums[winEnd] > minHeap.first().val) {
                minHeap.add(new Pair(winEnd, nums[winEnd]));
            } else {
                maxHeap.add(new Pair(winEnd, nums[winEnd]));
            }
            if(winEnd >= k - 1) {
                int winStart = winEnd - k + 1;
                res[winStart] = getMedian(minHeap, maxHeap, k);
                Pair toDelete = new Pair(winStart, nums[winStart]);
                if(minHeap.contains(toDelete)) minHeap.remove(toDelete);
                else maxHeap.remove(toDelete);
            }
        }
        return res;
    }

    private double getMedian(TreeSet<Pair> minHeap, TreeSet<Pair> maxHeap, int k) {
        balance(minHeap, maxHeap, k);
        if(k % 2 == 0) {
            return (new Double(maxHeap.first().val) + new Double(minHeap.first().val)) / 2.0;
        } else {
            return 1.0 * maxHeap.first().val;
        }
    }

    private void balance(TreeSet<Pair> minHeap, TreeSet<Pair> maxHeap, int k) {
        int maxHeapSize = k - k / 2;
        while(maxHeap.size() < maxHeapSize) {
            maxHeap.add(minHeap.pollFirst());
        }
        while(maxHeap.size() > maxHeapSize) {
            minHeap.add(maxHeap.pollFirst());
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,3,-1,-3,5,3,6,7};
        new SlidingWindowMedianImpl().medianSlidingWindow(input, 3);
    }
}
