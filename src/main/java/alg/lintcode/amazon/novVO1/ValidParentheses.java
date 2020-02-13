package alg.lintcode.amazon.novVO1;

import java.util.HashMap;
import java.util.Map;

/*
linkcode 423
 */
public class ValidParentheses {
    public boolean isValidParentheses(String s) {
        int slow = -1; // slow ptr simulate a stack, to the left of slow are all left brackets
        int fast = 0;
        Map<Character, Character> lkup = getLkup();
        char[] input = s.toCharArray();
        for(; fast < input.length; fast++) {
            if(lkup.containsKey(input[fast])) { // is left bracket
                input[++slow] = input[fast];
            } else { // is right bracket
                if(slow < 0 || input[fast] != lkup.get(input[slow])) {
                    return false;
                } else {
                    slow--;
                }
            }
        }
        return slow == -1;
    }
    private Map<Character, Character> getLkup() {
        Map<Character, Character> lkup = new HashMap<>();
        lkup.put('(',')');
        lkup.put('[',']');
        lkup.put('{','}');
        return lkup;
    }
}
