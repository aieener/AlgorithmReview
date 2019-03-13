package Class_01;

import java.util.Arrays;


public class SelectionSort {
//    static int count = 0;
    public int[] solve(int[] array) {
        if(array == null || array.length == 0) {
            return array;
        }

        for(int i = 0; i < array.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < array.length; j++) {
//                count++;
                if(array[j] < array[minIdx]){
                    minIdx = j;
                }
            }
            swap(array,i,minIdx);
        }
        return array;
    }

    private void swap(int[] array, int l ,int r) {
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }

    public static void main(String[] args) {
        SelectionSort sol = new SelectionSort();
        int [] array = new int[] {4,8,1,2,7,-1,3,5};
        array = sol.solve(array);
        System.out.println(Arrays.toString(array));
//        System.out.println(count);
    }
}
