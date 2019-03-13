package Class_01;

import java.util.Arrays;

/**
 * Created by yuding on 1/31/18.
 */
public class InsertionSort {
    public int[] solve(int[] array) {
        if(array == null || array.length == 0) {
            return array;
        }
        for(int i = 1; i < array.length; i++) {
            int key = array[i]; // record key
            int j = i - 1;
            while(j >= 0 && array[j] > key) {
                // stop at when array[j] > key otherwise swap j + 1 and j
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key; // put key back
            System.out.println(Arrays.toString(array));
        }
        return array;
    }

    public static void main(String[] args) {
        InsertionSort sol = new InsertionSort();
        int [] array = new int[] {4,8,1,2,7,-1,3,5};
        array = sol.solve(array);
        System.out.println('\n');
        System.out.println(Arrays.toString(array));
    }
    /**
     *                  compare     target
     * 4 8 1 2 7 -1 3 5   0         (4)
     * 4 8 1 2 7 -1 3 5   1         (8)
     * 1 4 8 2 7 -1 3 5   2         (1)
     * 1 2 4 8 7 -1 3 5   3         (2)
     * 1 2 4 7 8 -1 3 5   2         (7)
     *-1 1 2 4 7  8 3 5   5         (-1)
     *-1 1 2 3 4  7 8 5   4         (3)
     *-1 1 2 3 4  5 7 8   3         (5)
     */
}
