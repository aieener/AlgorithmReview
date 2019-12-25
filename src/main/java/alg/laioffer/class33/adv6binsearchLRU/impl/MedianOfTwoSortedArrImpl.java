package alg.laioffer.class33.adv6binsearchLRU.impl;

import alg.laioffer.class33.adv6binsearchLRU.MedianOfTwoSortedArr;

public class MedianOfTwoSortedArrImpl implements MedianOfTwoSortedArr {
    static class Bundle {
        int aStart, bStart, value, k;

        public Bundle(int aStart, int bStart, int value, int k) {
            this.aStart = aStart;
            this.bStart = bStart;
            this.value = value;
            this.k = k;
        }
    }

    private double findMedian (int [] num) {
        if(num.length % 2 == 0) {
            return (num[num.length / 2] + num[num.length / 2 - 1]) / 2.0;
        }
        return num[num.length / 2 ];
    }

    public double median(int[] a, int[] b) {
        if(a.length == 0) return findMedian(b);
        else if (b.length == 0) return findMedian(a);
        int totalLen = a.length + b.length;
        Bundle res = findKth(a, 0, b, 0, totalLen / 2);
        int next = findNext(a, b, res);
        if(totalLen % 2 == 0) {
            return (res.value + next) / 2.0;
        }
        return next;
    }

    private int findNext(int[] a, int[] b, Bundle res) {
        if(res.aStart < a.length && res.bStart < b.length) {
            // then val == a | b [start]
            if(res.value == a[res.aStart]) {
                if(res.aStart + 1 < a.length) return Math.min(a[res.aStart + 1], b[res.bStart]);
                return b[res.bStart];
            } else {
                if(res.bStart + 1 < b.length) return Math.min(b[res.bStart + 1], a[res.aStart]);
                return a[res.aStart];
            }
        } else if(res.aStart < a.length) {
            return a[res.aStart + res.k];
        }
        return b[res.bStart + res.k];
    }

    private Bundle findKth(int[] a, int aStart, int[] b, int bStart, int k) {
        if (aStart >= a.length) return new Bundle(aStart, bStart, b[bStart + k - 1], k);
        if (bStart >= b.length) return new Bundle(aStart, bStart, a[aStart + k - 1], k);
        if (k == 1) {
            int res = Math.min(a[aStart], b[bStart]);
            return new Bundle(aStart, bStart, res, k);
        }

        // recursive rule
        int aMidPos = aStart + k / 2 - 1;
        int bMidPos = bStart + k / 2 - 1;
        int aVal = aMidPos >= a.length ? Integer.MAX_VALUE : a[aMidPos];
        int bVal = bMidPos >= b.length ? Integer.MAX_VALUE : b[bMidPos];
        if (aVal < bVal) {
            return findKth(a, aMidPos + 1, b, bStart, k - k / 2);
        }
        return findKth(a, aStart, b, bMidPos + 1, k - k / 2);
    }

    public static void main(String[] args) {
        int [] a = new int[] {1,1,2, 4,4,6};
        int[] b = new int[]{1,2,3,5,9};
        MedianOfTwoSortedArr engine = new MedianOfTwoSortedArrImpl();
        System.out.println(engine.median(a,b));
    }
 }
