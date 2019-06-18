package cit.penn.datastructure;

public class HWill {
    public static int findRepeat2(int [] A) {
        int i = 1;
        while (i < A.length) {
            if(A[i-1] != i) {
                return A[i-1];
            }
            i++;
        }
        return A.length - 1;
    }

    public static long findRepeat(int[] array) {
        // step 1:  sum over the array:
        long sum = 0;
        for(int i : array) {
            sum += i;
        }
        // step 2: sum from 1 to n - 1:
        long sumWithoutRepeat = 0;
        for(int i = 0; i < array.length; i++) {
            sumWithoutRepeat += i;
        }
        // step 3: calc tue repeated Number by subtract the two
        long result = sum - sumWithoutRepeat;
        return result;
    }


    public static void main(String[] args) {
//        int[] arr = {1,1,2,3,4,5,6,7};
        int[] arr = {1,4,3,2,4,5,6,7};
//        System.out.println(findRepeat2(arr));
        System.out.println(findRepeat(arr));
    }

}
