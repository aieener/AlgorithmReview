package alg.laioffer.crosstraining1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
  /**
   * with sort
   * find i < j < k such that array[i] + array[j] + array[k] = target
   * time : O(n^2)
   */
  public List<List<Integer>> allTriples(int[] array, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(array);
    for(int i = 0; i < array.length; i++) {
      if(i > 0 && array[i] == array[i-1]) continue;
      int left = i + 1;
      int right = array.length - 1;
      while(left < right) {
        int curSum = array[left] + array[right];
        if(curSum == target - array[i]) {
          res.add(Arrays.asList(array[i], array[left], array[right]));
          left++;
          // skip dups
          while(left < right && array[left] == array[left - 1]) left++;
        } else if (curSum < target - array[i]) {
          left++;
        } else {
          right--;
        }
      }
    }
    return res;
  }
}
