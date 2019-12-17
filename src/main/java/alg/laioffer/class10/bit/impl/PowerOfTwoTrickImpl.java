package alg.laioffer.class10.bit.impl;

import alg.laioffer.class10.bit.PowerOfTwo;

public class PowerOfTwoTrickImpl implements PowerOfTwo {
    @Override
    public boolean isPowerOfTwo(int number) {
        return number > 0 && ((number - 1) & number) == 0;
    }
}
