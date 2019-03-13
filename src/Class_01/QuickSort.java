package Class_01;
// This is the answer from laiOffer where we pick random
// This version is the same as from Alg text book
// index as pivot

// Review nov_5 video, ---> 1:45 to 1:50
// Two bars with 3 zone!
//  [0,... l) to the left of l, not including l, will be <=  pivot
//  (r, ... n-1] to the right of r, not including r, will be >= pivot
// in between, unexplored zone [l,r]

// QSort can do concurrently! better than mergeSort
//      Worst case O(n^2)
//      Average O(nlogn)
import java.util.Arrays;
/**
 * - Dec 31 revisit
 */
public class QuickSort {
    public int[] quickSort(int[] array){
       if(array == null || array.length == 0 ){
           return array;
       }
       qSort(array, 0, array.length - 1);
       return array;
    }

    // wrapper function
    public void qSort(int[] array, int start, int end){
        // base case
        if(start >= end){
            return;
        }

        int pivotPos = partition(array, start, end);
        // pivot is already sits at its position, when do the
        // recursive call, we don't include pivot in any of them
        qSort(array, start,pivotPos - 1);
        qSort(array, pivotPos + 1, end);
    }

    private int partition(int [] array, int start, int end){
        int pivotIndex = pivotIndex(start, end);
        int pivot = array[pivotIndex];
        //!!!!!!!!!!!!
        // swap the pivot with the right most elem first!!!
        swap(array, pivotIndex, end);

        int l = start;
        int r = end - 1;
        // Physical meaning: to the left of l <= pivot
        //                   to the right of r >= pivot
        // Program done until l and r CROSS
        while( l <= r){ // here has to be l <= r since we want to ensure they accross
//          if(array[l] <= pivot){ also work
            if(array[l] < pivot){
                l++;

//          } else if (array[r] >= pivot){
            } else if (array[r] > pivot){
                r--;
            } else {
                swap(array, l++, r--);
            }
        }

        // swap back pivot elem
        // since pivot is at end
        // when cross l is to the right of r
        swap(array, l, end);

        return l;
    }

    // 随机取pivot， 对极端确定输入任然可以是nlogn
    // 若不用随机， 极端输入会出n^2 (排过序的数组）
    // But when all input are the same --> n^2 for both
    private int pivotIndex(int left, int right){
        // Math.random() --> (0, 1)
        return left + (int) (Math.random() * (right - left + 1));
    }

    private void swap(int [] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }


    public static void main(String[] args) {
        QuickSort sol = new QuickSort();

        int[] array = null;

        array = new int[] {1,4,3,3,4,3,3,2,1};
        array = sol.quickSort2(array);
        System.out.println(Arrays.toString(array));

        array = new int[] {1,9,8,3,5,3,3,2,1,0};
        array = sol.quickSort2(array);
        System.out.println(Arrays.toString(array));

        array = new int[] {1,9,8,3,5,3,3,2,1,0};
        array = sol.quickSort2(array);
        System.out.println(Arrays.toString(array));
    }

    //---- prac -------
    public int[] quickSort2(int[] arr) {
        if(arr == null || arr.length == 0) {
            return arr;
        }
        qhelper(arr,0, arr.length - 1);
        return arr;
    }
    private void qhelper(int[] arr, int start, int end) {
        // base case
        if(start >= end) {
            return;
        }
        int pivotIdx =  partition2(arr, start, end);
        qhelper(arr, start, pivotIdx - 1);
        qhelper(arr, pivotIdx + 1, end);

    }

    private int partition2(int[] arr, int start, int end) {
        int pivotIdx = getPivot(start, end);
        int pivot = arr[pivotIdx];

        swap(arr, pivotIdx, end);
        int right = end - 1;
        int left = start;
        while(left <= right) {
            if(arr[left] < pivot) {
                left++;
            } else if (arr[right] > pivot) {
                right--;
            } else {
                swap(arr,left,right);
                left++;
                right--;
            }
        }
        swap(arr, end,left);
        return left;
    }

    private int getPivot(int start, int end) {
        return start + (int) (Math.random() * (end - start + 1));
    }

}


