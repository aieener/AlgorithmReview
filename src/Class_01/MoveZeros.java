package Class_01;

import java.util.Arrays;


public class MoveZeros {
    public int[] moveZero (int[] array){
        // 1 3 4 2 3 | 0 0 0 0
        //   i     j
        // to the left of i are non zero
        // to the right of j are 0
        if(array.length == 0){
            return array;
        }

        // Opposite direction
        int i = 0;
        int j = array.length - 1;
        int k = 0;

        while( i <= j){
            if(array[k] == 0){
                swap(array, k ,j );
                j--;
            } else {
                i++;
                k++;
            }
        }
        return array;
    }

    public int[] moveZeroInplace (int[] array){
        // 1 3 4 2 3 | 0 0 0 0
        //   i     j
        // to the left of i are non zero
        // to the right of j are 0
        if(array.length == 0){
            return array;
        }

        // same direction
        int i = 0;
        int j = 0;

        while(j != array.length){
            if(array[j] != 0){
                swap(array, i ,j );
                i++;
            }
            j++;
        }
        return array;
    }

    // laiOffer sol
    public int[] moveZeros( int [] array){
        if(array == null || array.length == 0){
            return array;
        }
        int left = 0;
        int right = array.length - 1;

        while(left <= right ){
            if(array[left] != 0){
                left++;
            } else if (array[right] == 0){
                right--;
            } else{
                swap(array, left++, right--);
            }
        }
        return array;
    }

    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int[] moveZeross(int[] array) {
        // Write your solution here.
        if(array == null || array.length == 0) {
            return array;
        }
        int left = 0;
        int right = 0;
        while(right != array.length ) {
            if(array[right] != 0){
                array[left++] = array[right++];
            } else {
                right++;
            }
        }
        while(left != array.length ) {
            array[left] = 0;
            left++;
        }
        return array;
    }
    public static void main(String[] args) {
        MoveZeros sol  = new MoveZeros();

        int [] array = new int[] {1,2,0,3,4,0,2,3,0,0,8};
//        array = sol.moveZeros(array);
        array = sol.moveZero(array);
        System.out.println(Arrays.toString(array));
//
        array = new int[] {1,2,0,3,4,0,2,3,0,0,8};
        array = sol.moveZeroInplace(array);
        System.out.println(Arrays.toString(array));

        array = new int[] {1,1,0,0,1,1};
        array = sol.moveZeross(array);
        System.out.println(Arrays.toString(array));
    }

}
