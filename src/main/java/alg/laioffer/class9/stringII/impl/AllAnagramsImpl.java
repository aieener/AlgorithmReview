package alg.laioffer.class9.stringII.impl;

import alg.laioffer.class9.stringII.AllAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagramsImpl implements AllAnagrams {
    @Override
    public List<Integer> allAnagrams(String lo, String sh) {
        List<Integer> res = new ArrayList<>();
        if(sh == null || sh.length() == 0) return res;
        Map<Character, Integer> freqLkup = getFreq(lo);
        int count = freqLkup.size();

        for (int i = 0; i < lo.length(); i++) {
            if (freqLkup.containsKey(sh.charAt(i))) {
                freqLkup.put(sh.charAt(i), freqLkup.get(sh.charAt(i)) - 1);
                if (freqLkup.get(sh.charAt(i)) == 0) count--;
            }
        }
        if (count == 0) {
            res.add(0);
        }

        for (int begin = 1; begin <= sh.length() - lo.length(); begin++) {
            char incomingVal = sh.charAt(begin + lo.length() - 1);
            char leavingVal = sh.charAt(begin - 1);

            // add incomingVal
            if (freqLkup.containsKey(incomingVal)) {
                freqLkup.put(incomingVal, freqLkup.get(incomingVal) - 1);
                if (freqLkup.get(incomingVal) == 0) {
                    count--;
                }
            }
            // remove leavingVal
            if (freqLkup.containsKey(leavingVal)) {
                if (freqLkup.get(leavingVal) == 0) {
                    count++;
                }
                freqLkup.put(leavingVal, freqLkup.get(leavingVal) + 1);
            }
            if (count == 0) res.add(begin);

        }
        return res;
    }

    private Map<Character, Integer> getFreq(String lo) {
        Map<Character, Integer> res = new HashMap<>();
        for (Character ch : lo.toCharArray()) {
            res.put(ch, res.getOrDefault(ch, 0) + 1);
        }
        return res;
    }
}
