package alg.oa.google.impl;

import alg.oa.google.OddEvenJumps;

/*
Time exceed, pass 61/64 test leetcode cases
 */
public class OddEvenJumpsNaiveImpl implements OddEvenJumps {
    @Override
    public int oddEvenJumps(int[] A) {
        if (A == null || A.length == 0) return 0;
        if (A.length == 1) return 1;
        /*
            MOdd[i] means it's a Odd turn, at i, the idx it must jump to
            MEven[i] means it's a even turn, at i, the idx it must jump to
            -1 means can't jump anymore
         */

        int[] MOdd = new int[A.length];
        int[] MEven = new int[A.length];
        fillLkupTables(A, MOdd, MEven);
        int res = 0;

        for (int startIdx = 0; startIdx < A.length; startIdx++) {
            boolean odd = true;
            int curIdx = startIdx;
            while (curIdx != -1 && curIdx != A.length - 1) {
                if (odd) {
                    curIdx = MOdd[curIdx];
                } else {
                    curIdx = MEven[curIdx];
                }
                odd = !odd;
            }
            if (curIdx == A.length - 1) res++;
        }
        return res;
    }

    /*
        This method is the bottle neck O(n^2), can be optimized to O(nlogn)
        using TreeMap or monotonic stack 单调栈
        TreeMap<value, Idx>
     */
    private void fillLkupTables(int[] A, int[] MOdd, int[] MEven) {
        //base case
        MOdd[MOdd.length - 1] = MOdd.length - 1;
        MEven[MEven.length - 1] = MEven.length - 1;

        // fill MOdd .. A[left] <= A[right] && A[right] is smallest , increasing
        //  0  1  2  3  4
        // [5, 1, 3, 4, 2]
        // [-1, 4, 4, -1, 4]
        for (int i = MOdd.length - 2; i >= 0; i--) {
            int jumpOddIdx = -1;
            int jumpOddVal = Integer.MAX_VALUE;
            int jumpEvenIdx = -1;
            int jumpEvenVal = Integer.MIN_VALUE;
            for (int j = i + 1; j < MOdd.length; j++) {
                // fill MEven
                if (A[j] >= A[i]) {
                    if (A[j] < jumpOddVal) {
                        jumpOddVal = A[j];
                        jumpOddIdx = j;
                    }
                }
                // fill MOdd
                if (A[j] <= A[i]) {
                    if (A[j] > jumpEvenVal) {
                        jumpEvenVal = A[j];
                        jumpEvenIdx = j;
                    }
                }
            }
            MOdd[i] = jumpOddIdx;
            MEven[i] = jumpEvenIdx;
        }
    }
}
