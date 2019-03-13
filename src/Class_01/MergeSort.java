package Class_01;

import java.util.Arrays;
import java.util.List;


public class MergeSort {

    /**
     * last review : 2/10/19
     */
    public int[] mergeSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }

        int start = 0;
        int end = array.length - 1;
        int[] temp = new int[array.length];
        mSort(array, temp, start, end);
        return array;
    }

    private void mSort(int[] array, int[] temp, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mSort(array, temp, start, mid);
        mSort(array, temp, mid + 1, end);
        merge(array, temp, start, mid, end);
    }

    private void merge(int[] array, int[] temp, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = start;
        while (i <= mid && j <= end) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= end) {
            temp[k++] = array[j++];
        }

        for (int l = start; l <= end; l++) {
            array[l] = temp[l];
        }
    }

    public static void main(String[] args) {
        MergeSort sol = new MergeSort();

        int[] array = new int[]{4, 8, 1, 2, 7, -1, 3, 5};

        int[] cpyArray = new int[array.length];
        System.arraycopy(array, 0, cpyArray, 0, array.length);
        System.out.println(Arrays.toString(array));
        sol.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    public List<Long> mergeList(List<Long> list) {
        if (list == null && list.size() == 0) {
            return list;
        }
        int start = 0;
        int end = list.size() - 1;
        return mergeSortHelper(list, start, end);
    }

    private List<Long> mergeSortHelper(List<Long> list, int start, int end) {
        // base case
        if (start >= end) {
            return list;
        }
        int mid = start + (end - start) / 2;
        List<Long> firstHalf = mergeSortHelper(list, start, mid);
        List<Long> secondHalf = mergeSortHelper(list, mid + 1, end);
        return mergeThem(firstHalf, secondHalf);
    }

    private List<Long> mergeThem(List<Long> firstHalf, List<Long> secondHalf) {
        return null;
    }
}
