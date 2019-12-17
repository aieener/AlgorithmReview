package alg.laioffer.class9.stringII.impl;

import alg.laioffer.class9.stringII.LongestStrWithoutRepeatChars;

import java.util.HashMap;
import java.util.Map;

public class LongestStringWithoutRepeatFreqImpl implements LongestStrWithoutRepeatChars {
    @Override
    public int longest(String input) {
        if(input == null || input.length() == 0) return 0;
        Map<Character, Integer> freqLkup = new HashMap<>();
        int slow= 0;
        int fast = 0;
        int res = 1;

        for(; fast < input.length(); fast++) {
            char curVal = input.charAt(fast);
            freqLkup.put(curVal, freqLkup.getOrDefault(curVal, 0) + 1);
            while(freqLkup.containsKey(curVal) && freqLkup.get(curVal) > 1) {
                freqLkup.put(input.charAt(slow), freqLkup.get(input.charAt(slow)) - 1);
                slow++;
            }
            res = Math.max(res, fast - slow + 1);
        }
        return res;
    }

    /*
       Sliding Window pattern:
       int slow = 0;
       for(int fast = 0; fast < input.length(); fast++){
            // .. update current state with adding new fast here or at last
            while( .. if constrain is violated ..) {
                // .. update current state with dropping slow
                // .. update global vars like maxLen, minLen, if necessary etc
                slow++;
            }
            // .. update global vars like maxLen, minLen, if necessary etc
       }
     */
}
