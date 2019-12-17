package alg.laioffer.class9.stringII.impl;

import alg.laioffer.class9.stringII.LongestStrWithoutRepeatChars;

import java.util.HashMap;
import java.util.Map;

public class LongestStringWithoutRepeatCharLastOccurImpl implements LongestStrWithoutRepeatChars {
    /*
        bcdfbd --> bcdf
     */
    @Override
    public int longest(String input) {
        if (input == null || input.length() == 0) return 0;
        Map<Character, Integer> lastOccurLkup = new HashMap<>();
        int res = 0;
        int slow = 0;

        for (int fast = 0; fast < input.length(); fast++) {
            int lastOccurredIdx = lastOccurLkup.getOrDefault(input.charAt(fast), -1);
            if (lastOccurredIdx >= slow) {
                slow = lastOccurredIdx + 1;
            }
            res = Math.max(fast - slow + 1, res);
            lastOccurLkup.put(input.charAt(fast), fast);
        }
        return res;
    }
}
