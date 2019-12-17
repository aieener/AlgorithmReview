package alg.laioffer.class10.bit.impl;

import alg.laioffer.class10.bit.ReverseBitsOf32BitInteger;

public class ReverseBitsOf32BitIntImpl implements ReverseBitsOf32BitInteger {
    @Override
    public long reverseBits(long n) {
        long left = 0L;
        long right = 31L;
        while (left < right) {
            n = reversePair(n, left++, right--);
        }
        return n;
    }

    private long reversePair(long x, long left, long right) {
        /*
            bit version of swap
            x ^ bit_mask
            let left = 1, right = 6
            bit_mask = (1 << left | 1 << right) = 0 1 0 0 0 0 1 0
            x ^ bit_mask will reverse x value at left and right
         */
        long left_bit = ((x >> left) & 1L);
        long right_bit = ((x >> right) & 1L);
        if (left_bit != right_bit) {
            x = x ^ (1L << left);
            x = x ^ (1L << right);
        }
        return x;
    }
}
