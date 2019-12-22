package alg.laioffer.class14.dp2.impl;

import alg.laioffer.class13.dp1.ArrayHopperOne;
import alg.laioffer.class14.dp2.ArrayHopperTwo;

public class ArrayHopperTwoImpl implements ArrayHopperTwo {
    @Override
    public int minJump(int[] array) {
        if (array == null || array.length == 0) return -1;
        int[] M = new int[array.length];
        M[array.length - 1] = 0;
        for (int i = array.length - 2; i >= 0; i--) {
            M[i] = Integer.MAX_VALUE;
            for (int j = i + 1; j < array.length; j++) {
                if (M[j] != -1 && i + array[i] >= j) {
                    M[i] = Math.min(M[j] + 1, M[i]);
                }
            }
            if (M[i] == Integer.MAX_VALUE) M[i] = -1;
        }
        return M[0];
    }
}
