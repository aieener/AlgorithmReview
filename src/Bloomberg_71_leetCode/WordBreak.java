package Bloomberg_71_leetCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yuding on 2/13/18.
 * LaiOffer 切字典题！
 * Left Large chunk, right small chunk
 */
public class WordBreak {
    /**
     *  M[i] stands for weather s.substring[0. i] can be cut into dict
     *  M[] ranges from 0 to i, where i is the length of the string
     *  "absc" len = 4
     *  01234  M.len = 5  M[4] stands for substring[0,4], the whole string
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = formDict(wordDict);
        boolean M[] = new boolean[s.length() + 1];
        M[0] = true; // 一刀不切
        // i max will be s.length() so s.substring(0, s.length) will be the ori string
        for(int i = 1; i < M.length; i++) {
            for(int j = 0; j < i; j++) {
                M[i] = M[j] && dict.contains(s.substring(j, i));
                if(M[i]) {
                    break;
                }
            }
        }
        return M[M.length - 1];
    }
    private Set<String> formDict(List<String> wordDict ) {
        Set<String> res = new HashSet<>();
        for(String s : wordDict) {
            res.add(s);
        }
        return res;
    }

    //----- prac ---------

}
