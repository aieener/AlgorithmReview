package alg.laioffer.prac.jan2;

import java.util.Arrays;

public class SelectionSort {
    public int [] selection(int[] arr){
        if (arr == null || arr.length == 0) {
            return arr;
        }

        for(int i = 0; i < arr.length ; i++){
            int min = Integer.MAX_VALUE;
            int idx =  i;
            for(int j = i; j < arr.length; j++){
                if(arr[j] < min){
                    min = arr[j];
                    idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        int[] in = new int[]{9,-3,-4,5,2,5,1,6,7};
        int[] res = ss.selection(in);
        System.out.println(Arrays.toString(res));
    }

}
