package alg.laioffer.class3.linkedlist.stack.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yuding on 12/19/17.
 * 5 star question !!!
 * this is basically another version of merge sort!
 * talked about this method in Class 1
 * s1 | 2 3 1 4 7 8 5 9
 * s2 |
 * s3 |
 */
public class SortWThreeStack {
  public void sort(LinkedList<Integer> s1) {
    Deque<Integer> s2 = new LinkedList<>();
    Deque<Integer> s3 = new LinkedList<>();
    sort(s1, s2, s3, s1.size());
  }

  private void sort(Deque<Integer> s1, Deque<Integer> s2,
                    Deque<Integer> s3, int len) {
    //base case
    if (len <= 1) {
      return;
    }
    // split
    int mid1 = len / 2;
    int mid2 = len - mid1;

    // put secHalfSize from s1 into s2
    for (int i = 0; i < mid1; i++) {
      s2.offerFirst(s1.pollFirst());
    }

    // do recur
    sort(s2, s3, s1, mid1);
    sort(s1, s3, s2, mid2);

    // after this recur, s2 and s1 will be sorted
    // merge s1 and s2;
    int i = 0;
    int j = 0;
    while (i < mid1 && j < mid2) {
      if (s2.peekFirst() < s1.peekFirst()) {
        s3.offerFirst(s2.pollFirst());
        i++;
      } else {
        s3.offerFirst(s1.pollFirst());
        j++;
      }
    }
    while (i < mid1) {
      s3.offerFirst(s2.pollFirst());
      i++;
    }

    while (j < mid2) {
      s3.offerFirst(s1.pollFirst());
      j++;
    }

    for(int idx = 0; idx < len; idx ++) {
      s1.offerFirst(s3.pollFirst());
    }
  }
}
