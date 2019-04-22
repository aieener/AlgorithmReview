package Class_02_BinSearch;

import java.util.Arrays;

//中心开花
// Worth to do again! Dec 18
public class kClosest {
  public int[] kClosest(int[] array, int target, int k) {
    // first find the place near to the target
    if (array == null || array.length == 0 || k == 0) {
      return new int[0];
    }
    int closetIdx = findClosetIdx(array, target);
    int[] res = new int[k];
    int left = closetIdx - 1;
    int right = closetIdx + 1;
    res[0] = array[closetIdx];
    for (int i = 1; i < k; i++) {
      if (left < 0) {
        res[i] = array[right++];
      } else if (right >= array.length) {
        res[i] = array[left--];
      } else {
        int deltaLeft = Math.abs(target - array[left]);
        int deltaRight = Math.abs(target - array[right]);
        if (deltaLeft < deltaRight) {
          res[i] = array[left--];
        } else {
          res[i] = array[right++];
        }
      }

    }
    return res;
  }

  private int findClosetIdx(int[] array, int target) {
    int start = 0;
    int end = array.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (target < array[mid]) {
        end = mid;
      } else {
        start = mid;
      }
    }
    int deltaEnd = Math.abs(target - array[end]);
    int deltaStart = Math.abs(target - array[start]);
    return deltaEnd < deltaStart ? end : start;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(new kClosest().kClosest(new int[]{1}, 0, 0)));
  }
}
