package alg.laioffer.class10.bit.impl;

import alg.laioffer.class10.bit.AllUniqCharsTwo;

public class AllUniqCharsTwoImpl implements AllUniqCharsTwo {
    /*
        use bit vector
     */
    @Override
    public boolean allUnique(String word) {
        int[] vec = new int[8];
        char[] array = word.toCharArray();
        for (char c : array) {
            if ((vec[c / 32] >>> (c % 32) & 1) != 0) {
                return false;
            }
            vec[c / 32] |= 1 << (c % 32);
        }
        return true;
    }
}
