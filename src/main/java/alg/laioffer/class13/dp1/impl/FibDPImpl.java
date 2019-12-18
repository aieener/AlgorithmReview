package alg.laioffer.class13.dp1.impl;

import alg.laioffer.class13.dp1.Fib;

public class FibDPImpl implements Fib {
    @Override
    public long fibonacci(int k) {
        if (k <= 0) return 0;
        if (k == 1) return 1;
        long prev = 0;
        long cur = 1;
        for (int i = 2; i <= k; i++) {
            long buf = cur;
            cur = prev + cur;
            prev = buf;
        }
        return cur;
    }
}
