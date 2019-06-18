package alg.laioffer.crosstraining1;

import java.util.HashMap;
import java.util.Map;

public class FourSum {
  static class Pair{
    int left;
    int right;
    Pair(int left, int right) {
      this.left = left;
      this.right = right;
    }
  }
  public boolean exist(int[] array, int target) {
    Map<Integer, Pair> lkUp = new HashMap<>();
    for(int i = 1; i < array.length; i++) {
      for(int j = 0; j < i; j++) {
        int curSum = array[i] + array[j];
        if(lkUp.containsKey(target - curSum) && lkUp.get(target - curSum).right < j){
          return true;
        }
        if(!lkUp.containsKey(curSum)) {
          lkUp.put(curSum, new Pair(j, i));
        }
      }
    }
    return false;
  }
}
