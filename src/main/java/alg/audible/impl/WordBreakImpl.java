package alg.audible.impl;

import alg.audible.WordBreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakImpl implements WordBreak {
    @Override
    public List<String> wordBreakII(String s, List<String> wordDict) {
        return null;
    }

    /*
        DP 切字典
        leetcode
        j  i
     */
    @Override
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;

        boolean M[] = new boolean[s.length() + 1];
        Set<String> dict = new HashSet<>(wordDict);
        //M[i] represents s[0,i) can be break or not, NOT including i
        // induction rule : M[i] = M[j] && dict.contains(str[j,i]) where j < i;
        M[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            boolean curVal = false;
            for (int j = 0; j < i; j++) {
                if (M[j] && dict.contains(s.substring(j, i))) { // beginIdx, endIdx
                    curVal = true;
                    break;
                }
            }
            M[i] = curVal;
        }
        return M[M.length - 1];
    }
}
