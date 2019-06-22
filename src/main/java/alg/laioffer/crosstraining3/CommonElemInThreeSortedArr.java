package alg.laioffer.crosstraining3;

import java.util.ArrayList;
import java.util.List;

public class CommonElemInThreeSortedArr {

  public List<Integer> common(int[] a, int[] b, int[] c) {
    int aIdx = 0;
    int bIdx = 0;
    int cIdx = 0;
    List<Integer> res = new ArrayList<>();
    while (aIdx < a.length && bIdx < b.length && cIdx < c.length) {
      int candidate = Math.max(Math.max(a[aIdx], b[bIdx]), c[cIdx]);
      aIdx = procceed(a, aIdx, candidate);
      bIdx = procceed(b, bIdx, candidate);
      cIdx = procceed(c, cIdx, candidate);
      if (a[aIdx] == b[bIdx] && b[bIdx] == c[cIdx]) {
        res.add(a[aIdx]);
      }
      aIdx++;
      bIdx++;
      cIdx++;
    }
    return res;
  }

  private int procceed(int[] cur, int idx, int candidate) {
    while (idx < cur.length - 1 && cur[idx] < candidate) {
      idx++;
    }
    return idx;
  }

  /**
   * basically the same, and my sol is prettier
   */
  public List<Integer> commonLai(int[] a, int[] b, int[] c) {
    int aIdx = 0;
    int bIdx = 0;
    int cIdx = 0;
    List<Integer> res = new ArrayList<>();
    while (aIdx < a.length && bIdx < b.length && cIdx < c.length) {
      if (a[aIdx] == b[bIdx] && b[bIdx] == c[cIdx]) {
        res.add(a[aIdx]);
        aIdx++;
        bIdx++;
        cIdx++;
      } else if (a[aIdx] <= b[bIdx] && a[aIdx] <= c[cIdx]) {
        aIdx++;
      } else if (b[bIdx] <= a[aIdx] && b[bIdx] <= c[cIdx]) {
        bIdx++;
      } else {
        cIdx++;
      }
    }
    return res;
  }

}
