package alg.leetcode.amazon.string.impl;

import alg.leetcode.amazon.string.MostCommonWord;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWordImpl implements MostCommonWord {
  @Override
  public String mostCommonWord(String paragraph, String[] banned) {
    paragraph += "."; // to terminate the paragraph;
    Set<String> bannedSet = new HashSet<>();
    for (String ban : banned) bannedSet.add(ban);
    Map<String, Integer> count = new HashMap<>();
    String ans = "";
    int curMax = 0;
    StringBuilder word = new StringBuilder();

    for (char c : paragraph.toCharArray()) {
      if (Character.isLetter(c)) {
        word.append(Character.toLowerCase(c));
      } else if (word.length() > 0) {
        String completeWord = word.toString();
        if (!bannedSet.contains(completeWord)) {
          count.put(completeWord, count.getOrDefault(completeWord, 0) + 1);
          if (count.get(completeWord) > curMax) {
            curMax = count.get(completeWord);
            ans = completeWord;
          }
        }
        word = new StringBuilder();
      }
    }
    return ans;
  }
}
