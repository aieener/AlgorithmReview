package alg.laioffer.crosstraining1;

public class LargestAndSmallest {
  public int[] largestAndSmallest(int[] array) {
    int n = array.length;
    for (int i = 0; i < n / 2; i++) {
      if (array[i] < array[n - 1 - i]) {
        swap(array, i, n - 1 - i);
      }
    }
    return new int[]{largest(array, 0, (n - 1) / 2), smallest(array, n / 2, n - 1)};
  }

  private int largest(int [] array, int start, int end) {
    int res = array[start];
    for(int i = start = 1; i <= end; i++) {
      res = Math.max(res, array[i]);
    }
    return res;
  }

  private int smallest(int[] array, int start, int end) {
    int res = array[start];
    for(int i = start = 1; i <= end; i++) {
      res = Math.min(res, array[i]);
    }
    return res;
  }


  private void swap(int[] array, int base, int other) {
    int temp = array[base];
    array[base] = array[other];
    array[other] = temp;
  }
}
