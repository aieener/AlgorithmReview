package alg.leedcodeFav.slidingwindow.impl;

import alg.leedcodeFav.slidingwindow.MinimumWindowSubstring;

import java.util.*;

public class MinimumWindowSubstringImpl implements MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring engine = new MinimumWindowSubstringImpl();
        System.out.println(engine.minWindow("A", "B"));
    }
    @Override
    public String minWindow(String s, String t) {
        if(s == null || s.length() < t.length()) return "";
        Map<Character, Integer> stateTracker = loadTarget(t);
        int slow = 0;
        int fast = 0; // chunk = [slow, ... fast] including fast, len = fast - slow + 1
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int resLeft = slow;
        for(; fast < s.length() ;fast++) {
            if(stateTracker.containsKey(s.charAt(fast))) {
                stateTracker.put(s.charAt(fast), stateTracker.get(s.charAt(fast)) - 1);
                if(stateTracker.get(s.charAt(fast)) >= 0) {
                    count++;
                }
                while(count == t.length()) {
                    int chunkLen = fast - slow + 1;
                    if(chunkLen < minLen) {
                        minLen = chunkLen;
                        resLeft = slow;
                    }
                    if(stateTracker.containsKey(s.charAt(slow))) {
                        stateTracker.put(s.charAt(slow), stateTracker.get(s.charAt(slow)) + 1);
                        if(stateTracker.get(s.charAt(slow)) > 0) count--;
                    }
                    slow++;
                }
            }
        }
        if(minLen == Integer.MAX_VALUE) return "";
        return s.substring(resLeft, resLeft + minLen);
    }


    private Map<Character, Integer> loadTarget(String t){
        Map<Character, Integer> lkup = new HashMap<>();
        for(Character cur : t.toCharArray()) {
            lkup.put(cur, lkup.getOrDefault(cur, 0) + 1);
        }
        return lkup;
    }
}
