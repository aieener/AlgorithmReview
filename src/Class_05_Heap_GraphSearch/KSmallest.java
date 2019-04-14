package Class_05_Heap_GraphSearch;

import Class_03_LL.PartitionLL;

import java.lang.reflect.Parameter;
import java.util.*;

/***
 *  if not specify, The default PriorityQueue is implemented with Min-Heap,
 *  that is the top element is the minimum one in the heap.　+
 *
 *  minheap, poll() 丢掉的是最小的数， 无脑pop掉小数，留大的 --> (Top K largest numbers!)
 *  maxheap poll() 丢掉的是最大的数，无脑pop掉大的数, 在top!，留小的 -->
 *

 */

public class KSmallest {
    // Method 1 Priority Queue
    // this one is K sized max Heap
    public int[] kSmallest(int[] array, int k) {
        if (array == null || array.length == 0 || k == 0) {
            return new int[0];
        }
        int[] result = new int[k];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                // o1 > o2 ---> -1 reversely comparator!
                return o1 > o2 ? -1 : 1;
            }
        });

        for (int i = 0; i < array.length; i++) {
            if (i < k) {
                maxHeap.offer(array[i]);
            } else if (array[i] < maxHeap.peek()) {
                // only offer if it is smaller than max val at max Heap
                maxHeap.poll(); //pop the current max val
                maxHeap.offer(array[i]); // add the new small val
            }
        }

        for (int i = k - 1; i >= 0; i--) {
            // the top one is max val (Max Heap) , thus we have reverse order
            result[i] = maxHeap.poll();
        }
        return result;
    }


    // Method 2 quick select : this is like quick sort
    public int[] kSmallestII(int[] array, int k) {
        if (array.length == 0 || k == 0) {
            return new int[0];
        }
        quickSelect(array, 0, array.length - 1, k - 1);
        // after quickSelect is called, the first k elements in the array
        // will be the k smallest ones but not sorted
        int[] res = Arrays.copyOf(array, k); // construct an array by copying
        // first k from array
        Arrays.sort(res);
        return res;
    }

    private void quickSelect(int[] array, int left, int right, int target) {
        int mid = partition(array, left, right);
        if (mid == target) {
            return;
        } else if (target < mid) {
            // this part is very similar to binary search
            quickSelect(array, left, mid - 1, target);
        } else {
            quickSelect(array, mid + 1, right, target);
        }
    }

    private int partition(int[] array, int left, int right) {
        int pivotIdx = pivotIndex(left, right);
        int pivot = array[pivotIdx];
        swap(array, pivotIdx, right);

        //------- or use the rightmost one -------
//        int pivot = array[right];
        int start = left;
        int end = right - 1;
        while (start <= end) {
            if (array[start] < pivot) {
                start++;
            } else if (array[end] >= pivot) {
                end--;
            } else {
                swap(array, start++, end--);
            }
        }
        swap(array, start, right); // put the pivot back to it's position
        return start;
    }

    private int pivotIndex ( int left, int right){
        return left + (int) (Math.random() * (right - left + 1));
    }

    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    //-------------------------------------
    public static void main(String[] args) {
        KSmallest ks = new KSmallest();
        int [] array;
        array = new int[] {5,3,4,2,1,1,2,8,4,4,9,13,5,8};
        int [] res = ks.kSmallest(array,5);
        System.out.println(Arrays.toString(res));
        res = ks.kSmallestII(array,5);
        System.out.println(Arrays.toString(res));
    }


    // practice draft qselect
}
