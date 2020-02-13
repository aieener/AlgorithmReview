package alg.audible.impl;

import alg.audible.CommonWordSize;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CommonWordSizeImpl implements CommonWordSize {
    @Override
    public int commonWordSize(String input) {
        if (input == null || input.length() == 0) return 0;
        Map<Integer, Integer> lkup = new HashMap<>();
        int maxFreq = 0;
        // 1. removeSpace
        // 2. count sizeFreq
        // 3. return mostFreqSize
        /*
            01234
            the dog went
            s
               f
         */
        int slow = 0; // including slow ptr, represents start of current word
        int fast = 0; // not including fast ptr, represents end of current word, wordLen = fast - slow
        for (; fast < input.length(); fast++) {
            if (input.charAt(fast) == ' ') {
                if(fast != slow) {
                    int wordLen = fast - slow;
                    lkup.put(wordLen, lkup.getOrDefault(wordLen, 0) + 1);
                    maxFreq = Math.max(maxFreq, lkup.get(wordLen));
                }
                // proceed fast until input[fast] != ' ';
                while (fast < input.length() && input.charAt(fast) == ' ') {
                    fast++;
                }
                slow = fast;
                fast--;
            }
        }
        if(slow != fast) {
            int wordLen = fast - slow;
            lkup.put(wordLen, lkup.getOrDefault(wordLen, 0) + 1);
            maxFreq = Math.max(maxFreq, lkup.get(wordLen));
        }
        return maxFreq;
    }

    public static void main(String[] args) {
        String input = "        ths dog      went to the sto";
        CommonWordSize engine = new CommonWordSizeImpl();
        System.out.println(engine.commonWordSize(input));
    }
}
