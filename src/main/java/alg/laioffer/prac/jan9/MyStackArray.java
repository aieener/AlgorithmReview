package alg.laioffer.prac.jan9;

public class MyStackArray {
    private int head = 0;
    private Integer [] array;

    public MyStackArray(int cap) {
        // check capacity
        array = new Integer[cap];
        head = -1;
    }

    public boolean push(int ele) {
        if(head == array.length - 1) {
            return false;
        }

        array[++head] = ele;
        return true;
    }

    public Integer pop() {
        return head == -1 ? null : array[head--];
    }

    public Integer top() {
        return head == -1 ? null : array[head];
    }
}
