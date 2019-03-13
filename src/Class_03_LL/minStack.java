package Class_03_LL;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yuding on 12/19/17.
 * using Deque to implement minStack
 * Need to review!!
 * Stack    || 3 1 -7 -6 -8
 * minStack || 3 1 -7 -7 -8
 *
 */
public class minStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public minStack(){
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
    }

    public Integer pop(){
        if(stack.isEmpty()){
            return null;
        }
        Integer res = stack.pollFirst();
        if(minStack.peekFirst().equals(res)){
            minStack.pollFirst();
        }
//        minStack.pollFirst();
        return res;
    }

    public void push (int element) {
        stack.offerFirst(element);

        if(minStack.isEmpty() || element <= minStack.peekFirst()){
            minStack.offerFirst(element);
        }
//        else {
//            minStack.offerFirst(minStack.peekFirst());
//        }
    }

    public Integer top () {
        if(stack.isEmpty()){
            return null;
        }
        return stack.peekFirst();
    }

    public Integer min() {
        if(minStack.isEmpty()){
            return null;
        }
        return minStack.peekFirst();
    }
}
