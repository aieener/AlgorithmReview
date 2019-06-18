package alg.laioffer.crosstraining2;

/**
 * B[i] represents how many elements A[j] (j > i)
 * in array A that are smaller than A[i]
 */
public class GetCountArray {
  public int[] countArray(int[] array) {
    int[] indexArr = initialIndexArray(array);
    int[] countArr = new int[array.length];
    int[] helper = new int[array.length];
    mergeSort(array, indexArr, countArr, helper, 0, array.length - 1);
    return countArr;
  }

  private int[] initialIndexArray(int[] arr) {
    int[] indices = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      indices[i] = i;
    }
    return indices;
  }

  private void mergeSort(int[] array, int[] indexArr, int[] countArr, int[] helper, int left, int right) {
    if (left >= right) {
      return;
    }
    int mid = left + (right - left) / 2;
    mergeSort(array, indexArr, countArr, helper, left, mid);
    mergeSort(array, indexArr, countArr, helper, mid + 1, right);
    merge(array, indexArr, countArr, helper, left, mid, right);
  }

  private void merge(int[] array, int[] indexArr, int[] countArr, int[] helper, int left, int mid, int right) {
    copyArray(indexArr, helper, left, right);
    int l = left;
    int r = mid + 1;
    int cur = left;
    while (l <= mid) {
      if (r > right || array[helper[l]] <= array[helper[r]]) {
        countArr[helper[l]] += (r - mid - 1);
        /** left and right are sorted,
         *  so if array[helper[l]] > array[helper[r]], all right elem to the mid are smaller, hence we add r - mid - 1
         */
        indexArr[cur++] = helper[l++];
      } else {
        indexArr[cur++] = helper[r++];
      }
    }

  }

  private void copyArray(int[] indexArr, int[] helper, int left, int right) {
    for (int i = left; i <= right; i++) {
      helper[i] = indexArr[i];
    }
  }
}
