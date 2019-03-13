package Prac_Jan_9;

/**
 * Using Array to implement Queue
 * Assume capacity is fixed, then add resize to work for all size
 *
 * Need a Circular Struct (circular array)
 * 满的时候 head and tail will cross : tail == head and size == 0 empty
 *                                    tail == head and size !=0  full
 *                                    OR
 *                                    use a dummy node, when head = tail + 1
 *                                    ---> full!
 *
 *  quick tip:
 *  head = (head + 1) % array.length
 *
 *  做 6 个class!!!
 */
public class MyQueueArray {
    private int size = 0;
    private Integer [] array;
    private int head = 0;
    private int tail = 0;
    // 注意Coding Style
    private static final int SCALE_FACTOR = 2;
    private static final int INITIAL_CAP = 10;

    public MyQueueArray() {
        array = new Integer[INITIAL_CAP];
    }

    //--------
    private void reSize() {
        int newLen = array.length * SCALE_FACTOR;
        Integer[] newArray = new Integer[newLen];
        //TODO fix it cong head copy dao tail!!!
        int j = 0;
        for(int i = head; i != tail; i = (i + 1 ) % array.length) {
            newArray[j] = array[i];
            j++;
        }
        array = newArray;
        head = 0;
        tail = j;
    }
    //--------

    public void offer(int a) {
        if(size == array.length) {
            reSize();
        }
        array[tail] = a;
        tail = ( tail + 1) % array.length;
        size++;
        return ;
    }

    public Integer poll() {
        if(size == 0) {
            return null;
        }
        Integer cur = array[head];
        head = (head + 1) % array.length;
        size--;
        return cur;

    }

    public Integer size() {
        return size;
    }

    public Integer peek() {
        if(size == 0) {
            return null;
        }
        return array[head];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
