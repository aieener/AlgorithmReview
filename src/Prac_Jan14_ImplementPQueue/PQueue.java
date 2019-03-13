package Prac_Jan14_ImplementPQueue;

/**
 * Created by yuding on 1/16/18.
 */

/**
 * Key points
 *
 * 1. child index -> parent index
 *      a. parent = (child - 1) / 2;
 * 2. parent index -> child index
 *      a. leftchild = parent * 2 + 1;
 *      b. rightchild = parent * 2 + 2;
 * 3. Heapify from n / 2 - 1;
 * 4. Basic internal operation of heap:
 *      a. percolateUp(int index)
 *          i. offer()
 *          ii. update()
 *      b. percolateDown(int index)
 *          i. poll()
 *          ii. update()
 *          iii. heapify()
 */
public class PQueue {
    /**
     * Here we implement a minHeap
     */
    private Integer[] array;
    private int size;
    private static final int INITIAL_CAP = 10;
    private static final int SCALE_FACTOR = 2;

    public PQueue() {
        array = new Integer[INITIAL_CAP];
    }

    public PQueue(Integer[] input) {
        this.array = input;
        this.size = input.length;
        heapify();
    }
    private void heapify(){
        for(int i = size / 2 - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }
    // the hardest one!
    private void percolateDown(int index){
        // index can't be leaf --> 0 to last leaf's parent
        // stop when index == size / 2 - 1
        while (index <= size / 2 - 1 ) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int candidate = left;
            if(right <= size - 1 && array[right] < array[left]) {
                candidate = right;
            }
            // Then just swap with the candidate
            if(array[index] > array[candidate]) {
                swap(array,index, candidate);
            } else {
                break;
            }
            index = candidate;
        }
    }

    private void percolateUp(int index) {
        // stop when index > 0
        while(index > 0) {
            int parentIndex = (index - 1) / 2;
            if(array[parentIndex] > array[index]){
                swap(array,parentIndex, index);
            } else {
                break;
            }
            index = parentIndex;
        }
    }

    private void resize() {
        Integer[] newArray = new Integer[SCALE_FACTOR * array.length];
        for(int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;

    }

    private void swap(Integer [] array, int i, int j) {
        Integer temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Dijkstra's use update a lot!-->changes key values
     * @param index
     * @param element
     * @return
     */
    public Integer update (int index, Integer element) {
        if(index < 0 || index >= size) {
            return null;
        }
        Integer value = array[index];
        array[index] = element;
        if(element < value) {
            percolateUp(index);
        } else {
            percolateDown(index);
        }
        return value;
    }

    public void offer(Integer element){
        if(size > array.length) {
            resize();
        }
        size++;
        array[size - 1] = element;
        percolateUp(size - 1);
    }

    public Integer poll() {
        if(size == 0) {
            return null;
        }
        // swap the last one with the root
        Integer value = array[0];
        array[0] = array[size - 1];
        size--;
        percolateDown(0);
        return value;
    }

    public Integer peek() {
        if(size == 0) {
            return null;
        }
        return array[0];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
