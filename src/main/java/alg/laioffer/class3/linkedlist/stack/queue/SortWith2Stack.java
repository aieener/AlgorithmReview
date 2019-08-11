package alg.laioffer.class3.linkedlist.stack.queue;

import java.util.LinkedList;

/**
 * Bubble Sort : Good question for new hires
 * s1 | 4 3
 * s2 | 1 2
 * pollLast only
 * offerLast only
 */
public class SortWith2Stack {
  public static void main(String[] args) {
    LinkedList<Integer> input = new LinkedList<>();
    input.add(4);
    input.add(3);
    input.add(2);
    input.add(1);
    SortWith2Stack sorter = new SortWith2Stack();
    sorter.sort(input);
    System.out.println(input);

  }

  public void sort(LinkedList<Integer> s1) {
    if (s1 == null || s1.isEmpty()) return;
    LinkedList<Integer> s2 = new LinkedList<>();

    while (!s1.isEmpty()) {
      Integer cur = s1.pollLast();
      if (s2.isEmpty()) {
        s2.offerLast(cur);
      } else {
        Integer s2Top = s2.peekLast();
        if (cur < s2Top) {
          s2.offerLast(cur);
        } else {
          insert(cur, s2, s1);
        }
      }
    }

    while (!s2.isEmpty()) {
      s1.offerLast(s2.pollLast());
    }
  }

  private void insert(Integer target, LinkedList<Integer> s2, LinkedList<Integer> s1) {
    // use s1 as temp holder
    int s1InitialLen = s1.size();
    while (!s2.isEmpty() && target > s2.peekLast()) {
      s1.offerLast(s2.pollLast());
    }

    s2.offerLast(target);
    while (s1.size() > s1InitialLen) {
      s2.offerLast(s1.pollLast());
    }
  }
}
