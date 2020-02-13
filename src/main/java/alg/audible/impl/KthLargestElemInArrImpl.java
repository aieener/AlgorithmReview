package alg.audible.impl;

import alg.audible.KthLargestElemInArr;

import java.util.PriorityQueue;
import java.util.Random;

/*
    qSelect T = n + n/2 + 4/n + ... --> 2n
    qSort T = n + n + ....+ n ---> n log n
    approach 1: qSelect : space O(logn) [like doing a binSearch to find kth] | time ave: O(n), worst n^2
    - space O(logn), time O(n)
    approach 2: heap : space O(k), time O(nlogk)
 */
public class KthLargestElemInArrImpl implements KthLargestElemInArr {
    @Override
    public int findKthLargest(int[] nums, int k) {
        if (nums.length < k) return -1;
        int start = 0;
        int end = nums.length - 1;
        int idx = partition(nums, start, end);
        while (idx != k - 1) {
            if (idx > k - 1) {
                end = idx - 1;
            } else {
                start = idx + 1;
            }
            idx = partition(nums, start, end); // only recursion on one side --> reduce nlogn to n
        }
        return nums[idx];
    }

    // partition return an index that [0, idx) are bigger than nums[idx] a,d (idx, end] are smaller
    private int partition(int[] nums, int start, int end) {
        if (start == end) return start;
        Random rand = new Random();
        int pivotIdx = rand.nextInt(end - start + 1) + start;
        int pivot = nums[pivotIdx];
        swap(nums, pivotIdx, end);
        int l = start;
        int r = end - 1;
        while (l <= r) {
            if (nums[l] > pivot) {
                l++;
            } else if (nums[r] <= pivot) {
                r--;
            } else {
                swap(nums, l++, r--);
            }
        }
        swap(nums, l, end);
        return l;
    }

    // space O(k)
    // time O(nlogk)
    public int findKthLargestHeap(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int rank = k - 1;

        for (int i = 0; i < nums.length; i++) {
            if (i <= rank) {
                minHeap.offer(nums[i]);
            } else if (minHeap.peek() < nums[i]) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        return minHeap.peek();
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
