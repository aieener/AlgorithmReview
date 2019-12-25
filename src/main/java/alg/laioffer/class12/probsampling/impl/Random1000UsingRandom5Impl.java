package alg.laioffer.class12.probsampling.impl;

import alg.laioffer.class12.probsampling.Random1000UsingRandom5;
import alg.laioffer.class12.probsampling.Random7ByRandom5;

public class Random1000UsingRandom5Impl implements Random1000UsingRandom5 {
    @Override
    public int random1000() {
        // 5^5 = 3125
        while(true) {
            int rand3125 = getRandom3125();
            if(rand3125 < 3000) {
                return rand3125 % 1000;
            }
        }
    }

    private int getRandom3125() {
        int res = RandomFive.random5();
        for(int i = 0; i < 4; i++) {
            res = res * 5 + RandomFive.random5();
        }
        return res;
    }
}
