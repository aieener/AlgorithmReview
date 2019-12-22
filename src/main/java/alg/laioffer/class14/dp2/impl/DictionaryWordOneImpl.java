package alg.laioffer.class14.dp2.impl;

import alg.laioffer.class14.dp2.DictionaryWordOne;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DictionaryWordOneImpl implements DictionaryWordOne {
    @Override
    public boolean canBreak(String input, String[] dict) {
        if (dict == null || dict.length == 0) return false;
        Set<String> dictSet = makeDict(dict);
        boolean[] M = new boolean[input.length() + 1];
        // M[i] represents input[0:i), not including i canBreak
        M[0] = true;  // no cut
        for (int i = 1; i < input.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (M[j] && dictSet.contains(input.substring(j + 1, i))) {
                    M[i] = true;
                    break;
                }
            }
        }
        return M[M.length - 1];
    }

    private Set<String> makeDict(String[] dict) {
        return new HashSet<>(Arrays.asList(dict));
    }

    public static void main(String[] args) {
        System.out.println(new DictionaryWordOneImpl().canBreak("bcdef", new String[]{"abc","bcd","def"}));
    }
}
