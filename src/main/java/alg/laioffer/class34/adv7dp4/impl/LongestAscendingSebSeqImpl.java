package alg.laioffer.class34.adv7dp4.impl;

import alg.laioffer.class34.adv7dp4.LongestAscendingSubSeq;

public class LongestAscendingSebSeqImpl implements LongestAscendingSubSeq {
    @Override
    public int longest(int[] array) {
        //          5 2 6 3 4 7 5
        // refine 0 2 3 4
        if(array == null || array.length ==0) return 0;
        int [] refine = new int[array.length + 1]; // refine [i] represents the smallest value ends with length i;
        refine[1] = array[0];
        int res = 1;
        for(int i = 1; i < array.length; i++) {
            int idx = binSearchLeftBiggest(refine, res, array[i]); // idx is the largest smaller value index
            if(idx == res) {
                res++;
                refine[idx + 1] = array[i];
            } else {
                // refine[idx + 1] = Math.min(refine[idx+1], array[i]); // NOT necessary!
                // this is because:
                // key insight 2: refine is increasing, refine = <pos=1, val=2> < 2,3 > <3,5 > |  arr= 2 3 5  <-- 4 or 6
                // say incoming element is 4, binSearch return pos = 2 , 4 < 5 ---> <1,2> < 2,3 > <3,4>
                // say incoming element is 6, binSearch return pos = 3 == refineLen, 6 > 5 ---> <1,2> < 2,3 > <3,5> <4,6>
                // if array[i] is ending at idx + 1, array[i] < refine[idx + 1]
                // otherwise, refine[idx + 1] has no value yet, thus refine[idx + 1] = array[i]
                refine[idx + 1] =  array[i];
            }
        }
        return res;
    }

    private int binSearchLeftBiggest(int[] refine, int rightBound, int target) {
        int leftBound = 1;
        while(leftBound <= rightBound) {
            int mid = leftBound + (rightBound - leftBound) / 2;
            if (refine[mid] >= target) {
                rightBound = mid - 1;
            } else {
                leftBound= mid + 1;
            }
        }
        return rightBound;
    }

    public static void main(String[] args) {
        int[] input = new int[]{5, 4, 2, 4, 3};
        System.out.println(new LongestAscendingSebSeqImpl().longest(input));
    }
}
