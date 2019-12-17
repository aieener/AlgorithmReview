package alg.laioffer.class8.stringI.hashtable.impl;

import alg.laioffer.class8.stringI.hashtable.RemoveAdjRepeatedCharsOne;
import alg.laioffer.class8.stringI.hashtable.RemoveCertainChars;

public class RemoveAdjacentRepeatedCharsOneImpl implements RemoveAdjRepeatedCharsOne {
    @Override
    public String deDup(String input) {
        char[] inputArr = input.toCharArray();
        int slow = 0;
        /*
            [0, s] will be result
            (s, f) buffer zone
            [f, end] unexplored
            abccde
                s
                 f
         */
        for (int fast = 1; fast < inputArr.length; fast++) {
            if(inputArr[fast] != inputArr[slow]) {
                inputArr[++slow] = inputArr[fast++];
            }
        }
        return new String(inputArr, 0, slow + 1);
    }
}
