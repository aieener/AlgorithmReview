package alg.laioffer.crosstraining3;

import java.util.HashSet;
import java.util.Set;

public class LargestProductOfLength {
  /**
   * My O(k*n^2) way
   */
  public int largestProduct(String[] dict) {
    /**
     * dictionary = [“abcde”, “abcd”, “ade”, “xy”],
     */
    Set<Word> wordSet = new HashSet<>();
    int res = 0;
    for (String cur : dict) {
      for (Word word : wordSet) {
        char[] curArr = cur.toCharArray();
        boolean valid = true;
        for (Character i : curArr) {
          if (word.chars.contains(i)) {
            valid = false;
          }
        }
        if (valid) {
          res = Math.max(res, word.len * cur.length());
        }
      }
      wordSet.add(constructWord(cur));
    }
    return res;
  }

  private Word constructWord(String word) {
    Set<Character> chars = new HashSet<Character>();
    for (Character cur : word.toCharArray()) {
      chars.add(cur);
    }
    return new Word(chars, word.length());
  }

  static class Word {
    Set<Character> chars;
    int len;

    Word(Set<Character> chars, int len) {
      this.chars = chars;
      this.len = len;
    }
  }

  /**
   * LaiOffer's bitMask Sol
   * O(n^2)
   * Class 25: bitMask
   */
}
