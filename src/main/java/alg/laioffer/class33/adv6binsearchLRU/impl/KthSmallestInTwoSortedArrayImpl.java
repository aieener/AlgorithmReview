package alg.laioffer.class33.adv6binsearchLRU.impl;

import alg.laioffer.class33.adv6binsearchLRU.KthSmallestInTwoSortedArray;

public class KthSmallestInTwoSortedArrayImpl implements KthSmallestInTwoSortedArray {
    @Override
    public int kth(int[] a, int[] b, int k) {
        return kth(a, 0, b, 0, k);
    }
    /*
        This is a binarySearch like recursion
        So it is NOT bottom up 3-step recursion
        Nor is DFS
        because at each branch, we are certain we only dive into one branch,
        and when we reach bottom/leaf, the computation is done
        Thus: T(n) = log(lenA + lenB) worst case
     */
    private int kth(int[] a, int aStart, int[] b, int bStart, int k) {
        // base case
        if (aStart >= a.length) return b[bStart + k - 1]; // done search with a
        if (bStart >= b.length) return a[aStart + k - 1];
        if (k == 1) return Math.min(a[aStart], b[bStart]);

        // recursive rule
        // compare k/2 th a's subarray to determine which k/2 partition to discard
        int aMidPos = aStart + k / 2 - 1;
        int bMidPos = bStart + k / 2 - 1;
        int aMidValue = aMidPos >= a.length ? Integer.MAX_VALUE : a[aMidPos];
        int bMidValue = bMidPos >= b.length ? Integer.MAX_VALUE : b[bMidPos];
        if (aMidValue < bMidValue) {// discard k / 2 a values
            return kth(a, aMidPos + 1, b, bStart, k - k / 2);
        }
        // discard
        return kth(a, aStart, b, bMidPos + 1, k - k / 2);
    }
}
