package alg.laioffer.class10.bit.impl;

import alg.laioffer.class10.bit.AllUniqCharsOne;

public class AllUniqCharsOneImpl implements AllUniqCharsOne {
    @Override
    public boolean allUnique(String word) {
        // O(1) space impl, assume only 26 lower case letter
//        boolean[] occurredChars = new boolean[26];
        int occurredChars = 0;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
//            if (occurredChars[pos]) {
            if (((occurredChars >> pos) & 1) == 1) { // check occurredChars kth is 1
                return false;
            }
//            occurredChars[pos] = true;
            occurredChars = (occurredChars | (1 << pos)); // set occuredChars k-th to one
        }
        return true;
    }
}
