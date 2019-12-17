package alg.laioffer.class8.stringI.hashtable.impl;

import alg.laioffer.class8.stringI.hashtable.CommonNumberOfTwoSortedArrs;

import java.util.ArrayList;
import java.util.List;

public class CommonNumberOfTwoSortedArrsTwoPtrImpl implements CommonNumberOfTwoSortedArrs {
    @Override
    public List<Integer> common(int[] A, int[] B) {
        int aPtr = 0;
        int bPtr = 0;
        List<Integer> res = new ArrayList<>();
        while(aPtr < A.length && bPtr < B.length) {
            if(A[aPtr] == B[bPtr]) {
                res.add(A[aPtr]);
                aPtr++;
                bPtr++;
            } else if (A[aPtr] < B[bPtr]) {
                aPtr++;
            } else {
                bPtr++;
            }
        }
        return res;
    }
}
