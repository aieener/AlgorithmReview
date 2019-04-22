package Class_02_BinSearch;

public class BinarySearch {
  public int binarySearch(int[] array, int target) {
    if (array == null || array.length == 0) {
      return -1;
    }
    int start = 0;
    int end = array.length - 1;
    while (start <= end) { // will cross
      int mid = start + (end - start) / 2;
      if(target == array[mid]) {
        return mid;
      } else if (target < array[mid]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return -1;
  }
}
