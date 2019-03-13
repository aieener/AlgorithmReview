package Class_13_DPII;

import java.util.HashSet;
import java.util.Set;

/**
 * last reviewed at Feb 26, 2019
 * Created by yuding on 2/9/18.
 * left BigChunk + right small chunk
 */
public class CutDictionary {
    public boolean canBreak(String input, String[] dict) {
        Set<String> dicSet = toSet(dict);
        boolean[] canbreak = new boolean[input.length() + 1];
        canbreak[0] = true;
        for(int i = 1; i < canbreak.length; i++) {
            for(int j = 0; j < i; j++) {
                if(dicSet.contains(input.substring(j,i))&& canbreak[j]) {
                    canbreak[i] = true;
                    break;
                }
            }
        }
        return canbreak[canbreak.length - 1];
    }

    private Set<String> toSet(String[]dict) {
        Set<String> res = new HashSet<>();
        for(String str : dict) {
            res.add(str);
        }
        return res;
    }

    // ---------- prac --------------
    public boolean canBreak2(String input, String[] dict) {
        //M[i] stands for the word = substring (1st, i] canBreak
        boolean[] M = new boolean[input.length() + 1]; // default all false
        M[0] = true; // invalid 一刀也不切
        Set<String> dicSet = getSet(dict);

        for(int i = 1; i < input.length() + 1; i++) {
            for(int j = 0; j < i; j++) {
                if( M[j] && dicSet.contains(input.substring(j,i))) {
                    M[i] = true;
                    break;
                }
            }
        }
        return M[input.length()];
    }

    private Set<String> getSet(String[] dict) {
        Set<String> res = new HashSet<>();
        for(String cur : dict) {
            res.add(cur);
        }
        return res;
    }

}
