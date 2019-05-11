package alg.penn.bloomberg;

import java.util.PriorityQueue;

public class KthLargestInArray {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 ) {
            return Integer.MIN_VALUE;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //there are only k elements in the minHeap, the top one is Kth largest
        for(int i = 0; i < nums.length; i++) {
            if(i < k) {
                minHeap.offer(nums[i]);
            } else if (minHeap.peek() < nums[i]){
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargestInArray kl = new KthLargestInArray();
        int [] in = {-1,2, 0,9,10,3};

        int res = kl.findKthLargest(in, 3);
        int res2 = kl.findKthLargest2(in, 3);
        System.out.println(res);
        System.out.print(res2);
    }

    //--------- prac --------------
    // method 2 Qselect
    public int findKthLargest2(int [] nums, int k) {
        if(nums.length == 0 || k == 0) {
            return Integer.MIN_VALUE;
        }
        int len = nums.length - 1;
        int tar = len - k + 1;
        Qselect(nums,0, nums.length-1,tar);

        return nums[tar];
    }

    private void Qselect(int[] nums, int start, int end, int tar) {
        int idx = partition(nums,start, end);
        if(idx == tar) {
            return;
        } else if(idx > tar) {
                Qselect(nums, start, idx - 1,tar);
        } else {
            Qselect(nums, idx + 1, end, tar);
        }
    }

    private int partition(int[] nums, int start, int end){
        int pivotIdx = genRandIdx(start,end);
        int pivot = nums[pivotIdx];
        swap(nums, pivotIdx, end);
        int l = start;
        int r = end - 1;
        while(l <= r) {
            if(nums[l] < pivot) {
                l++;
            } else if (nums[r] >= pivot) {
                r--;
            } else {
                swap(nums,l, r);
                l++;
                r--;
            }
        }
        swap(nums, l, end);
        return l;
    }

    private void swap(int [] nums, int l,int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    private int genRandIdx (int start, int end) {
        return start + (int) Math.random()*(end - start + 1);
    }
}
