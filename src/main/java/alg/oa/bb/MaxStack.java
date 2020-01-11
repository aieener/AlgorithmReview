package alg.oa.bb;

import java.util.Deque;
import java.util.LinkedList;

class MaxStack {
    static class Pair {
        int val, count;
        public Pair (int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
    private Deque<Integer> stack;
    private Deque<Pair> decreasingStack;


    /** initialize your data structure here. */
    public MaxStack() {
        stack = new LinkedList<>();
        decreasingStack = new LinkedList<>(); // max is at top
    }

    public void push(int x) {
        stack.push(x);
        if(decreasingStack.isEmpty() || decreasingStack.peek().val < x) {
            decreasingStack.push(new Pair(x, 1));
        } else if (decreasingStack.peek().val >= x) {
            decreasingStack.peek().count++;
        }
    }

    public int pop() {
        if(stack.isEmpty()) return 0;
        if(decreasingStack.peek().count > 1) {
            decreasingStack.peek().count--;
        } else {
            decreasingStack.pop();
        }
        return stack.pop();
    }

    public int top() {
        if(stack.isEmpty()) return 0;
        return stack.peek();
    }

    public int peekMax() {
        if(decreasingStack.isEmpty()) return 0;
        return decreasingStack.peek().val;
    }

    public int popMax() {
        Integer ret = decreasingStack.peek().val;
        // find max in stack
        // int count = 0;
        Deque<Integer> bufStack = new LinkedList<>();
        while(!stack.isEmpty() && !stack.peek().equals(ret)) {
            bufStack.push(pop());
            // count++;
        }
        pop();

        while(!bufStack.isEmpty()){
            push(bufStack.pop());
        }
        return ret;
    }
}
