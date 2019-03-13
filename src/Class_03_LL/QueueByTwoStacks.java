package Class_03_LL;

import Class_01.QuickSort;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yuding on 12/19/17.
 *  4 star basic problem!
 *  Need review!
 */
public class QueueByTwoStacks {
    private Deque<Integer> in;
    private Deque<Integer> out;

    public QueueByTwoStacks() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public Integer poll() {
        move();
        if(out.isEmpty()) {
            return null;
        } else {
            return out.pollFirst();
        }

    }

    public Integer peek() {
        move();
        if(out.isEmpty()){
            return null;
        } else {
            return out.peekFirst();
        }
    }

    public void offer (int value) {
        in.offerFirst(value);
    }

    private void move() {
        if(out.isEmpty()) {
            while(!in.isEmpty()){
                out.offerFirst(in.pollFirst());
            }
        }
    }

    public int size() {
        return in.size() + out.size();
    }

    public boolean isEmpty() {
        return in.size() == 0 && out.size() == 0;
    }
}
