package alg.laioffer.class11.recursionII.impl;

import alg.laioffer.class11.recursionII.APowerB;

public class APowerBImpl implements APowerB {
    @Override
    public long power(int a, int b) {
        if (a == 0) return 0L;
        if (b == 0) return 1L;
        if (b == 1 || a == 1) return a;
        // recursive rule
        int firstHalf = b / 2;
        int secondHalf = b - b / 2;
        long res = power(a, firstHalf);
        if (secondHalf == firstHalf) {
            return res * res;
        } else {
            return res * a * res;
        }
    }
}
