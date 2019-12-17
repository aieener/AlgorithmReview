package alg.laioffer.class14.dp2.impl;

import alg.laioffer.class14.dp2.DictionaryWordI;

import java.util.HashSet;
import java.util.Set;

public class DictionaryWord1Impl implements DictionaryWordI {
  /**
   * new String(inputArr, j, i-j)
   * equivalent to
   * input.substring(j,i); // beginIdx, endIdx
   */
  @Override
  public boolean canBreak(String input, String[] dict) {
    Set<String> dictSet = buildDictionary(dict);
    char[] inputArr = input.toCharArray();
    boolean[] M = new boolean[input.length() + 1]; // M[i] means input[0, i) canBreak; length = i - 0
    M[0] = true; // no cut, important!!
    for (int i = 1; i < input.length() + 1; i++) {
      boolean curVal = false;
      for (int j = 0; j < i; j++) {
        if (dictSet.contains(new String(inputArr, j, i - j)) && M[j]) {
          curVal = true;
          break;
        }
      }
      M[i] = curVal;
    }
    return M[input.length()];
  }

  private Set<String> buildDictionary(String[] dict) {
    Set<String> dictSet = new HashSet<>();
    for (String word : dict) {
      dictSet.add(word);
    }
    return dictSet;
  }
}
