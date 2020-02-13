package alg.lintcode.amazon.novVO1;

import java.util.HashSet;
import java.util.Set;

/*
lintcode 683
 */
public class WordBreakIII {
    /*
     * @param : A string
     * @param : A set of word
     * @return: the number of possible sentences.
     * ignore cases
     */
    public int wordBreak3(String s, Set<String> dict) {
        if(s == null || s.length() == 0 || dict.size() == 0) return 0;
        int[] M = new int[s.length() + 1]; // M[i] represents numOfWays to break for [0, i);
        M[0] = 1;
        Set<String> lowerCaseDict = makeLowerCaseDict(dict);
        // induction rule : M[i] = sum (M[j]) if s.substring(j,i)) is in dict;  where j < i
        for(int i = 1; i <= s.length(); i++) {
            M[i] = 0;
            for(int j = 0; j < i; j++) {
                if(M[j] > 0 && lowerCaseDict.contains(s.substring(j, i).toLowerCase())) {
                    M[i] += M[j];
                }
            }
        }
        return M[M.length - 1];
    }

    private Set<String> makeLowerCaseDict(Set<String> dict) {
        Set<String> res = new HashSet<>();
        for(String val : dict) {
            res.add(val.toLowerCase());
        }
        return res;
    }
}
