package alg.laioffer.class33.adv6binsearchLRU.impl;

import alg.laioffer.class33.adv6binsearchLRU.MaxValOfKSizeSlidingWindow;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class MaxValOfKSizeSlidingWindowTreeSetImpl implements MaxValOfKSizeSlidingWindow {

  static class Pair {
    int idx , val;
    public Pair(int idx, int val) {
      this.idx = idx;
      this.val = val;
    }
  }
  public List<Integer> maxWindows(int[] array, int k) {
    TreeSet<Pair> maxHeap = new TreeSet<Pair>(new Comparator<Pair>(){
      @Override
      public int compare(Pair base, Pair other) { // the greater val the --> -1, on top // the smaller idx, on top
        if(other.val < base.val) return -1;
        else if (other.val > base.val) return 1;
        else return base.idx - other.idx;
      }
    });
    List<Integer> res = new ArrayList<>();
    for(int winEnd = 0; winEnd < array.length; winEnd++){
      int winStart = winEnd - k + 1;
      maxHeap.add(new Pair(winEnd, array[winEnd]));
      if(winEnd >= k - 1) {
        // while(!maxHeap.isEmpty() && maxHeap.first().idx < winStart) maxHeap.pollFirst(); ---> lasy deletion, same as pQueue approach
        res.add(maxHeap.first().val);
        maxHeap.remove(new Pair(winStart, array[winStart])); // TreeSet can do this in O(log n), for pQueue this is O(n)
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] input = new int[]{1,2,3,4,5,6,7,8,9,1,1};
    new MaxValOfKSizeSlidingWindowTreeSetImpl().maxWindows(input,2);
  }
}
