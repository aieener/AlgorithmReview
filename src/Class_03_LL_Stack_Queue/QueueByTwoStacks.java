package Class_03_LL_Stack_Queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yuding on 12/19/17.
 * 4 star basic problem!
 * Need review!
 * Queue FIFO : offerFirst, pollLast
 * Stack LIFO : offerFirst, pollFirst;
 * <p>
 * in |  1 2 3 4
 * out |
 */
public class QueueByTwoStacks {
  private Deque<Integer> in;
  private Deque<Integer> out;

  public QueueByTwoStacks() {
    in = new LinkedList<>();
    out = new LinkedList<>();
  }

  public Integer poll() {
    if (out.isEmpty()) {
      putInToOut();
    }
    return out.pollFirst();
  }

  private void putInToOut() {
    while (!in.isEmpty()) {
      out.offerFirst(in.pollFirst());
    }
  }

  public void offer(int element) {
    in.offerFirst(element);
  }

  public Integer peek() {
    if(out.isEmpty()) {
      putInToOut();
    }
    return out.peekFirst();
  }

  public int size() {
    return in.size() + out.size();
  }

  public boolean isEmpty() {
    return in.isEmpty() && out.isEmpty();
  }
}
