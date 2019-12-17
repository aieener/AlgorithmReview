package alg.laioffer.class10.bit.impl;

import alg.laioffer.class10.bit.PowerOfTwo;

public class PowerOfTwoImpl implements PowerOfTwo {
    @Override
    public boolean isPowerOfTwo(int number) {
        return countOnes(number) == 1;
    }

    private int countOnes(int number) {
        int numOf1s = 0;
        while (number > 0) {
            numOf1s += (number & 1);
            number >>= 1;
        }
        return numOf1s;
    }

    public static void main(String[] args) {
        System.out.println(new PowerOfTwoImpl().isPowerOfTwo(256));
    }
}
