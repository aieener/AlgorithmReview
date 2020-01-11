package alg.laioffer.class23.adv1ArrayLCA.impl;

import alg.laioffer.class23.adv1ArrayLCA.LargestAndSmallest;

public class LargestAndSmallestImpl implements LargestAndSmallest {
    @Override
    public int[] largestAndSmallest(int[] array) {
        int[] res = new int[2]; // res[0] max, res[1] min
        res[0] = Integer.MIN_VALUE;
        res[1] = Integer.MAX_VALUE;
        find(array,0, array.length -1, res);
        return res;
    }
    private void find(int[] array, int start, int end, int[] res) {
        // base case
        if(start == end) {
            res[0] = Math.max(array[start], res[0]);
            res[1] = Math.min(array[start] ,res[1]);
            return;
        } else if(start + 1 == end) {
            int bigger = Math.max(array[start], array[end]);
            int smaller = Math.min(array[start], array[end]);
            res[0] = Math.max(bigger, res[0]);
            res[1] = Math.min(smaller,res[1]);
            return;
        }
        int mid = start + (end - start) / 2;
        find(array, start, mid, res);
        find(array, mid + 1, end, res);
    }
}
