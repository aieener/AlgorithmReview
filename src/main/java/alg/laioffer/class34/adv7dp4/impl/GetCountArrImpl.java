package alg.laioffer.class34.adv7dp4.impl;

import alg.laioffer.class34.adv7dp4.GetCountArr;

/*
  we never mutate the original arr, Nor sort the array!
  we only mess around with the index array!
  // start--left --- mid | (mid + 1) ---- right --- end|
  whenever left is smaller, that means there are amt = [(right-1) - (mid + 1) + 1] = (right - mid - 1) amount of items from
  right are sitting in front of left ! so count[indices[left]] += right - mid - 1;
 */
public class GetCountArrImpl implements GetCountArr {
    @Override
    public int[] countArray(int[] array) {
        int[] count = new int[array.length];
        if (array == null || array.length == 0) return count;
        int[] indices = getIndexArr(array);
        recur(array, 0, array.length - 1, count, indices);
        return count;
    }

    private int[] getIndexArr(int[] arr) {
        int[] indices = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            indices[i] = i;
        }
        return indices;
    }

    private void recur(int[] array, int start, int end, int[] count, int[] indices) {
        // base case
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        recur(array, start, mid, count, indices);
        recur(array, mid + 1, end, count, indices);
        mergeAndCount(array, start, mid, end, count, indices);
    }

    private void mergeAndCount(int[] array, int start, int mid, int end, int[] count, int[] indices) {
        int[] indicesBuf = new int[array.length];
        int left = start;
        int right = mid + 1;
        int runner = start;
        while(left <= mid && right <= end) {
            if(array[indices[left]] <= array[indices[right]]) {
                count[indices[left]] += (right - mid  - 1);
                indicesBuf[runner++] = indices[left++];
            } else {
                indicesBuf[runner++] = indices[right++];
            }
        }

        while(left <= mid) {
            count[indices[left]] += (right - mid  - 1);
            indicesBuf[runner++] = indices[left++];
        }

        while(right <= end) {
            indicesBuf[runner++] = indices[right++];
        }

        for (int i = start; i <= end; i++) {
            indices[i] = indicesBuf[i];
        }
    }

    //--- 更优美的谁小移谁写法：
    private void mergeAndCountElegant(int[] array, int start, int mid, int end, int[] count, int[] indices) {
        int[] indicesCpy = new int[array.length];
        for (int i = start; i <= end; i++) {
            indicesCpy[i] = indices[i];
        }

        int left = start;
        int right = mid + 1;
        int runner = start;
        while(left <= mid) {
            if(right > end || array[indicesCpy[left]] <= array[indicesCpy[right]]) {
                count[indicesCpy[left]] += (right - mid  - 1);
                indices[runner++] = indicesCpy[left++];
            } else {
                indices[runner++] = indicesCpy[right++];
            }
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{4,1,3,2};
        new GetCountArrImpl().countArray(input);

    }
}
