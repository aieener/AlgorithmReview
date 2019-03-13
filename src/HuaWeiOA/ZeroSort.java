package HuaWeiOA;

import java.util.Arrays;

/**
 * Created by yuding on 1/16/18.
 */
public class ZeroSort {
    private void swap(int[] array, int l, int r) {
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }

    public void swapWithZero(int[] array, int len, int n) {
        int zidx = 0;
        for(Integer i : array) {
            if(i == 0) {
                break;
            }
            zidx++;
        }
        int nidx = 0;
        for(Integer i : array ){
            if(i == n) {
                break;
            }
            nidx++;
        }
        swap(array, zidx, nidx);
    }

    public void sort(int[] array, int len) {
        // 完成这个函数
        if(array == null || len == 0) {
            return;
        }
        swapWithZero(array,len,array[0]);
        for(int i = 1; i < len; i++) {
            int minIdx = i;
            for(int j = i; j < len; j++) {
                if(array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            swapWithZero(array,len,array[minIdx]);
            swapWithZero(array,len,array[i]);
            swapWithZero(array,len,array[0]);
        }
    }

//    public void sortqversion(int[] array, int len) {
//        if(array == null || len == 0) {
//            return;
//        }
//        // find the pos of 0
//        int zeroPos = findzPos(array);
//    }
//
//    private void findzPos(int[] array) {
//        int l = 0;
//        int r = array.length - 1;
//        while(l < r) {
//            if(array[l] < 0) {
//                l++;
//            } else if(array[r] > 0) {
//                r--;
//            } else {
//                swapWithZero(array,array.length,l);
//                swapWithZero(array,array.length,r);
//                swapWithZero(array,array.length,l);
//                l++;
//                r--;
//            }
//        }
//    }
    public static void main(String[] args) {
        ZeroSort sol = new ZeroSort();
        //No repeat and No neg num
        int[] array = new int[] {1,3,4,65,7,0,2,-1};

        sol.sort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
