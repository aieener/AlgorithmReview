package alg.laioffer.class9.stringII.impl;

import alg.laioffer.class8.stringI.hashtable.impl.RemoveSpaceImpl;
import alg.laioffer.class9.stringII.ReOrderArray;

import java.util.Arrays;

public class ReOrderArrayImpl implements ReOrderArray {
    /*
        len = 10
        A B | C D E | 1 2 | 3 4 5
        l    ml       m     mr
        0     2       5     7
        A B   1 2 C   D E  3 4 5
        A1B2    C3D4E5
        constraint:
            ml - l = mr - m
            m - ml = len - mr
        l = left; known
        ml = left + len / 4
        mr = left + 3 * len / 4
        m = left + len / 2
     */
    @Override
    public int[] reorder(int[] array) {
        recur(array, 0, array.length);
        return array;
    }

    private void recur(int[] array, int left, int len) {
        // base case
        if (len <= 3) {
            return;
        }
        int ml = left + len / 4;
        int mr = left + 3 * len / 4;
        int m = left + len / 2;

        reverseWord(array, ml, m - 1, mr - 1);
        int leftChunkLen = ml - left;
        int rightChunkLen = m - ml;
        recur(array, left, 2 * leftChunkLen);
        recur(array, left + 2 * leftChunkLen, 2 * rightChunkLen);
    }

    private void reverseWord(int[] array, int start, int firstWordEnd, int end) {
        reverse(array, start, firstWordEnd);
        reverse(array, firstWordEnd + 1, end);
        reverse(array, start, end);
    }

    private void reverse(int[] array, int start, int end) {
        while (start < end) {
            swap(array, start++, end--);
        }
    }

    private void swap(int[] input, int l, int r) {
        int temp = input[l];
        input[l] = input[r];
        input[r] = temp;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(new ReOrderArrayImpl().reorder(input)));
    }
}
