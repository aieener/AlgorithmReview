package alg.laioffer.class8.stringI.hashtable.impl;

import alg.laioffer.class8.stringI.hashtable.MissingNumberOne;

/*
    XOR : ^
    1 xor 0 = 1
    0 xor 1 = 1
    0 xor 0 = 0
    1 xor 1 = 0
    --->
    prop 1: num xor num = 0;
    prop 2: 0 ^ num = num, num xor 0 = num;
    prop 3: a xor b = b xor a;
    prop 4: a xor (b xor c ) = (a xor b) xor c;
    --->
    (1 xor 2 xor 3) xor (1 xor 2) = (1 xor 1) xor (2 xor 2 ) xor 3 = 0 xor 0 xor 3 = 3
 */
public class MissingNumberOneImpl implements MissingNumberOne {
    @Override
    public int missing(int[] array) {
        int xorSum = getXorSum(array.length + 1);
        return findMissing(array, xorSum);
    }

    private int findMissing(int[] array, int xorSum) {
        for (Integer val : array) {
            xorSum ^= val;
        }
        return xorSum;
    }

    private int getXorSum(int num) {
        int res = 0;
        for (int i = 1; i <= num; i++) {
            res ^= i;
        }
        return res;
    }
}
