package alg.laioffer.crosstraining2;

import java.util.*;

public class MergeKSortedArray {
  static class Entry {
    int idx, arrIdx, value;
    Entry(int idx, int arrIdx, int value) {
      this.idx = idx;
      this.arrIdx = arrIdx;
      this.value = value;
    }
  }

  public int[] merge(int[][] arrayOfArarys) {
    int length = 0;
    Queue<Entry> minHeap = new PriorityQueue<>(new Comparator<Entry>() {
      @Override
      public int compare(Entry o1, Entry o2) {
        if(o1.value == o2.value) return 0;
        return o1.value > o2.value ? 1 : -1;
      }
    });
    for(int i = 0; i < arrayOfArarys.length; i++) {
      int [] arr = arrayOfArarys[i];
      length += arr.length;
      if(arr.length != 0) {
        minHeap.offer(new Entry(0, i, arr[0]));
      }
    }
    int [] res = new int[length];
    int curIdx = 0;
    // BFS
    while(!minHeap.isEmpty()) {
      Entry cur = minHeap.poll();
      res[curIdx++] = cur.value;
      if(cur.idx + 1 < arrayOfArarys[cur.arrIdx].length) {
        cur.idx++;
        cur.value =  arrayOfArarys[cur.arrIdx][cur.idx];
        minHeap.offer(cur);
      }
    }
    return res;
  }
}
