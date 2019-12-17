package alg.laioffer.class10.bit.impl;

import alg.laioffer.class10.bit.NumOfDiffBits;

public class NumOfDiffBitsImpl implements NumOfDiffBits {
    @Override
    public int diffBits(int a, int b) {
        int count = 0;
        int c = a^b; // a xor b : 000101 xor 000110 --> 000011, then count one
        while(c != 0) {
            count += (c & 1);
            c >>>=1; // >>> is the unsigned shift always add '0'
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NumOfDiffBitsImpl().diffBits(5, 8));
    }
}
