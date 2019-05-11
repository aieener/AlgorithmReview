package alg.laioffer.prac.jan2;

import java.util.Arrays;

public class QuickSort {
    public int[] quickSort (int[] arr){
        if(arr == null || arr.length <= 1){
            return arr;
        }
        qSort(arr, 0, arr.length);
        return arr;
    }
    private void qSort(int[] arr, int start, int end){
        if(start >= end) {
            return;
        }
        int pivotIdx = partition(arr, start, end);
        qSort(arr, start, pivotIdx - 1 );
        qSort(arr, pivotIdx + 1, end );
    }

    private int partition(int[] arr, int start, int end) {
        int pivotIdx = randPivotIdx(start, end);
        int pivot = arr[pivotIdx];
        swap(arr, pivotIdx, end);

        int left = start;
        int right = end - 1;

        while(left <= right) {
            if(arr[left] < pivot){
                left++;
            } else if (arr[right] > pivot){
                right--;
            } else {
                swap(arr, left++, right--);
            }
        }
        swap(arr, left, end);
        return left;
    }

    private void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private int randPivotIdx(int start, int end){
        return start + (int) Math.random() * (end - start + 1);
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] in = new int[]{9,-3,-4,5,2,5,1,6,7};
        int[] res = qs.quickSort(in);
        System.out.println(Arrays.toString(res));
    }
}
