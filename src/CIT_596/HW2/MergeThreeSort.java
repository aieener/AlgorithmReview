package CIT_596.HW2;

import java.util.Arrays;

/**
 * Created by yuding on 1/31/18.
 */
public class MergeThreeSort {
    public int [] mergeTreeSort(int [] arr) {
        if(arr == null || arr.length == 0) {
            return arr;
        }
        int start = 0;
        int end = arr.length - 1;
        int [] temp = new int[arr.length];
        mTSort(arr, temp, start,  end );
        return arr;
    }

    private void mTSort(int[] arr, int[] temp, int start, int end) {
        // base case
        if(start >= end) {
            return;
        }

        int lmid = start + (end - start) / 3;
        int rmid = start + 2 * (end - start) / 3;
        mTSort(arr, temp ,start, lmid);
        mTSort(arr, temp ,lmid + 1, rmid);
        mTSort(arr, temp ,rmid + 1, end);
        merge(arr, temp, start,lmid,rmid,end);
    }
    private void merge(int[] arr, int[] temp, int start,
                       int lmid, int rmid, int end) {
        int i = start; // ptr for first part
        int j = lmid + 1;  // ptr for mid part
        int k = rmid + 1;  // ptr for last part
        int idx = start;

        while(i <= lmid && j <= rmid && k <= end) {
            if (arr[i] <= arr[j] && arr[i] <= arr[k]) {
                // arr[i] is the min
                temp[idx++] = arr[i++];
            } else if (arr[j] <= arr[i] && arr[j] <= arr[k]){
                // arr[j] is the min
                temp[idx++] = arr[j++];
            } else {
                // arr[k] is the min
                temp[idx++] = arr[k++];
            }
        }

        while( i <= lmid && j <= rmid) {
            if(arr[i] <= arr[j]){
                temp[idx++] = arr[i++];
            } else {
                temp[idx++] = arr[j++];
            }
        }
        while( j <= rmid && k <= end) {
            if(arr[j] <= arr[k]){
                temp[idx++] = arr[j++];
            } else {
                temp[idx++] = arr[k++];
            }
        }
        while( k <= end && i <= lmid) {
            if(arr[i] <= arr[k]){
                temp[idx++] = arr[i++];
            } else {
                temp[idx++] = arr[k++];
            }
        }
        while( i <= lmid) {
            temp[idx++] = arr[i++];
        }
        while( j <= rmid ) {
            temp[idx++] = arr[j++];
        }
        while( k <= end) {
            temp[idx++] = arr[k++];
        }

        for(int l = start; l <= end; l++) {
            arr[l] = temp[l];
        }
    }

    public static void main(String[] args) {
        MergeThreeSort sol = new MergeThreeSort();
//        int [] array = new int[] {4,8,1,2,7,-1,3,5};
        int [] array = new int[] {4,2,1,6,3,5};
        array = sol.mergeTreeSort(array);
        System.out.print(Arrays.toString(array));
    }
}
