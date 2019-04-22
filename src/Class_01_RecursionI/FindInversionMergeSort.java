package Class_01_RecursionI;

import java.util.Arrays;

public class FindInversionMergeSort {
    int counter = 0;
    public int[] mergeSort(int[] array){
       if(array== null || array.length == 0){
           return array;
       }

       int start = 0;
       int end = array.length - 1;
       int[] temp = new int[array.length];
       mSort(array, temp, start, end);
       return array;
    }

    private void mSort(int[] array, int[] temp, int start, int end){
        if(start >= end){
            return;
        }
        int mid = start + (end - start) / 2;
        mSort(array, temp, start, mid);
        mSort(array, temp, mid + 1, end);
        merge(array, temp, start, mid, end);
    }

    private void merge(int[] array, int[] temp, int start, int mid, int end){
        int i = start;
        int j = mid + 1;
        int k = start;
        while( i <= mid && j <= end){
            if(array[i] <= array[j]){
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
                counter += mid - i + 1;
            }
        }
        while( i <= mid){
            temp[k++] = array[i++];
        }
        while( j <= end){
            temp[k++] = array[j++];
        }

        for(int l = start; l <= end; l++){
            array[l] = temp[l];
        }
    }

    public static void main(String[] args) {
        FindInversionMergeSort sol = new FindInversionMergeSort();

        int[] array = null;

//        array = new int[] {4,1,3,2,9,5};
//        array = new int[] {0,3,3,7,5,3,11,1};
        array = new int[] {1,4,7,3,3,5};
        array = sol.mergeSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(sol.counter);

    }
}
