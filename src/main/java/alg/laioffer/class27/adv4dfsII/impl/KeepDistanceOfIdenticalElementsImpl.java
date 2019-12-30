package alg.laioffer.class27.adv4dfsII.impl;

import alg.laioffer.class27.adv4dfsII.KeepDistanceForIndenticalElements;

import java.util.Arrays;

/**
 * 参考 Piazza https://piazza.com/class/j0eqhhdregb3i?cid=827
 * Space: O(k)
 * Time: O(2k!) upper bound, but will be better
 */
public class KeepDistanceOfIdenticalElementsImpl implements KeepDistanceForIndenticalElements {
  public static void main(String[] args) {
    KeepDistanceForIndenticalElements engine = new KeepDistanceOfIdenticalElementsImpl();
    System.out.println(Arrays.toString(engine.keepDistance(7)));
  }

  @Override
  public int[] keepDistance(int k) {
    // Write your solution here.
    int[] arr = new int[2 * k];
    int[] res = new int[2 * k];
    Arrays.fill(arr, 0);
    dfs(arr, k, res);
    return isValid(res) ? res : null;
  }

  private void dfs(int[] arr, int curNum, int[] res) {
    if(curNum == 0) {
      if(isValid(arr)){
        for(int i = 0; i < arr.length; i++) {
          res[i] = arr[i];
        }
      }
      return;
    }

    int spaceNeedAfter = curNum + 1;// filling from k, k-1, k-2 ... 0
    for(int i = 0; i < arr.length - spaceNeedAfter;i++) {
      if(arr[i] == 0 && arr[i + spaceNeedAfter] == 0) { // not fill
        arr[i] = curNum;
        arr[i + spaceNeedAfter] = curNum;
        dfs(arr, curNum - 1, res);
        arr[i] = 0;
        arr[i + spaceNeedAfter] = 0;
      }
    }
  }

  private boolean isValid(int[] arr) {
    for(int i = 0; i < arr.length; i++){
      if(arr[i] == 0) return false;
    }
    return true;
  }
}
