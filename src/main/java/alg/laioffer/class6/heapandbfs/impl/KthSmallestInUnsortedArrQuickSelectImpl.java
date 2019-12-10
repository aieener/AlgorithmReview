package alg.laioffer.class6.heapandbfs.impl;

import alg.laioffer.class6.heapandbfs.KthSmallestInUnsortedArr;

import java.util.Arrays;

public class KthSmallestInUnsortedArrQuickSelectImpl implements KthSmallestInUnsortedArr {
    @Override
    public int[] kSmallest(int[] array, int k) {
        if(k == 0) return new int[] {};
        int pivotPosition = partition(array, 0, array.length - 1, k);
        while (pivotPosition != k - 1) {
            if (pivotPosition > k - 1) {
                pivotPosition = partition(array, 0, pivotPosition - 1, k);
            } else {
                pivotPosition = partition(array, pivotPosition + 1, array.length - 1, k - pivotPosition - 1);
            }
        }

        int [] res = Arrays.copyOf(array, k);
//        int [] res = Arrays.copyOfRange(array, 0, k );
        Arrays.sort(res);
        return res;
    }


    /*
        will return the position of the randomly selected pivot!
     */
    private int partition(int[] array, int start, int end, int k) {
        int pivotIdx = (int) (Math.random() * (end - start + 1) + start); // [start, end];
        int pivotVal = array[pivotIdx];
        swap(array, end, pivotIdx);
        int left = 0;
        int right = end - 1;
        while (left < right + 1) { // make sure they cross
            if (array[left] < pivotVal) {
                left++;
            } else if (array[right] > pivotVal) {
                right--;
            } else {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        swap(array, left, end);
        return left;
    }

    private void swap(int[] array, int base, int other) {
        int temp = array[base];
        array[base] = array[other];
        array[other] = temp;
    }
}
