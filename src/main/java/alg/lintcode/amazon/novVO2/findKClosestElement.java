package alg.lintcode.amazon.novVO2;

public class findKClosestElement {
    public int[] kClosestNumbers(int[] A, int target, int k) {
        if (A == null || A.length < k) return null;
        if (k == 0) return new int[0];
        int[] res = new int[k];
        int closestIdx = binSearchClosest(A, target);
        res[0] = A[closestIdx];
        int l = closestIdx - 1;
        int r = closestIdx + 1;
        k--;
        for (; l >= 0 && r < A.length && k > 0; k--) {
            int lDiff = Math.abs(A[l] - target);
            int rDiff = Math.abs(A[r] - target);
            if (lDiff < rDiff) {
                res[res.length - k] = A[l--];
            } else if (lDiff > rDiff) {
                res[res.length - k] = A[r++];
            } else {
                if (A[l] < A[r]) {
                    res[res.length - k] = A[l--];
                } else {
                    res[res.length - k] = A[r++];
                }
            }
        }

        while (l >= 0 && k > 0) {
            res[res.length - k] = A[l--];
            k--;
        }
        while (r < A.length && k > 0) {
            res[res.length - k] = A[r++];
            k--;
        }
        return res;

    }

    private int binSearchClosest(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target == A[mid]) return mid;
            else if (target > A[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        int startDiff = Math.abs(A[start] - target);
        int endDiff = Math.abs(A[end] - target);

        return startDiff <= endDiff ? start : end;
    }
}
