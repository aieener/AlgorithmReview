package alg.laioffer.class3.stackqueue.impl;

import alg.laioffer.class3.stackqueue.SortWith3Stack;

import java.util.LinkedList;

public class SortWith3StackImpl implements SortWith3Stack {
    @Override
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> buf = new LinkedList<>();
        LinkedList<Integer> otherHalf = new LinkedList<>();
        sort(s1, s1.size(), buf, otherHalf); // res is in buf in reversed Order
    }


    private void sort(LinkedList<Integer> s1, int size,
                      LinkedList<Integer> buf, LinkedList<Integer> otherHalf) {
        if (size <= 1) return;
        int otherHalfSize = size / 2;
        int baseSize = size - size / 2;
        // move size / 2 of s1 to s3;
        for (int i = 0; i < otherHalfSize; i++) {
            otherHalf.push(s1.pop());
        }
        sort(s1, baseSize, buf, otherHalf); // s1 will hold first size / 2 sorted
        sort(otherHalf, otherHalfSize, buf, s1); // otherHalf hold other half sorted
        /*
         At this moment,
            - baseSize of sorted chunk will be at s1,
            - otherHalfSize of sorted chuck will be at otherHalf
            so we just have to merge result to buf
        */
        int base = 0;
        int other = 0;
        while (base < baseSize && other < otherHalfSize) {
            if (s1.peek() < otherHalf.peek()) {
                buf.push(s1.pop());
                base++;
            } else {
                buf.push(otherHalf.pop());
                other++;
            }
        }
        while (base < baseSize) {
            buf.push(s1.pop());
            base++;
        }
        while (other < otherHalfSize) {
            buf.push(otherHalf.pop());
            other++;
        }
        // dup buf to s1
        for (int count = 0; count < size; count++) {
            s1.push(buf.pop());
        }
    }
}
