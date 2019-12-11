package alg.leedcodeFav.impl;

import alg.leedcodeFav.LongestSubStrWithoutRepeatingChar;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStrWithoutRepeatingCharImpl implements LongestSubStrWithoutRepeatingChar {
    @Override
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastOccurredLkup = new HashMap<>();
        int slow = 0;
        int fast = 0;
        int res = 0;
        // substring = [slow, fast];
        for(; fast < s.length(); fast++) {
            if (lastOccurredLkup.containsKey(s.charAt(fast)) && lastOccurredLkup.get(s.charAt(fast)) >= slow) {
                slow = lastOccurredLkup.get(s.charAt(fast)) + 1;
            }
            lastOccurredLkup.put(s.charAt(fast), fast);
            res = Math.max(res, fast - slow + 1);
        }
        return res;
    }
}
