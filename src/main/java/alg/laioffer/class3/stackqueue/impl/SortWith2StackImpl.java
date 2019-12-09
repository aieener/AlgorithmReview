package alg.laioffer.class3.stackqueue.impl;

import alg.laioffer.class3.stackqueue.SortWith2Stack;

import java.util.Arrays;
import java.util.LinkedList;

public class SortWith2StackImpl implements SortWith2Stack {
    /*
        selection sort: each iteration, dump s1 to s2 and find the maxVal
        put that maxVal into s2
        lastly, s2 will be inversely sorted, we just have to
        dump it back to s1
     */
    @Override
    public void sort(LinkedList<Integer> s1) {
        if (s1 == null || s1.size() <= 1) return;
        LinkedList<Integer> s2 = new LinkedList<>();
        int totalSize = s1.size();
        while (!s1.isEmpty()) {
            int numToDumpBack = s1.size();
            int iterMin = dumpS1ToS2AndFindMin(s1, s2);
            dumpS2ToS1AndKeepMin(s1, s2, numToDumpBack, iterMin);
        }

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    private void dumpS2ToS1AndKeepMin(LinkedList<Integer> s1,
                                      LinkedList<Integer> s2,
                                      int numToDump, int iterMin) {
        boolean findMin = false;
        for (int i = 0; i < numToDump; i++) {
            int elemPoped = s2.pop();
            if (elemPoped != iterMin || findMin) {
                s1.push(elemPoped);
            } else {
                findMin = true;
            }
        }
        s2.push(iterMin);
    }

    private int dumpS1ToS2AndFindMin(LinkedList<Integer> s1,
                                     LinkedList<Integer> s2) {
        int min = s1.peek();
        while (!s1.isEmpty()) {
            min = Math.min(min, s1.peek());
            s2.push(s1.pop());
        }
        return min;
    }

    public static void main(String[] args) {
        SortWith2Stack engine = new SortWith2StackImpl();
        LinkedList<Integer> input = new LinkedList<>(Arrays.asList(4, 2, 3, 3, 3, 3, 2, 1));
        engine.sort(input);
        System.out.println(input.toString());
    }
}
