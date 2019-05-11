package alg.laioffer.class3.linkedlist.stack.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yuding on 12/19/17.
 * using Deque to implement minStack
 * Need to review!!
 * Stack    || 3 1 -7 -6 -8
 * minStack || 3 1 -7 -7 -8
 */
public class minStack {
  private Deque<Integer> stack;
  private Deque<Integer> minStack;

  public minStack() {
    stack = new LinkedList<Integer>();
    minStack = new LinkedList<Integer>();
  }

  public int pop() {
    if (!stack.isEmpty()) {
      minStack.pollFirst();
      return stack.pollFirst();
    }
    return -1;
  }

  public void push(int element) {
    if (stack.isEmpty()) {
      stack.offerFirst(element);
      minStack.offerFirst(element);
    } else {
      stack.offerFirst(element);
      if (element < minStack.peekFirst()) {
        minStack.offerFirst(element);
      } else {
        minStack.offerFirst(minStack.peekFirst());
      }
    }
  }

  public int top() {
    if (!stack.isEmpty()) {
      return stack.peekFirst();
    }
    return -1;
  }

  public int min() {
    if (!stack.isEmpty()) {
      return minStack.peekFirst();
    }
    return -1;
  }
}
