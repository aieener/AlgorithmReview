package alg.leetcode.microsoft.highFreq.review;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
leetcode 1239
 */
public class MaxLenOfConcatenatedStringWithUniqChar {
  public int maxLength(List<String> arr) {
    int[] maxLen = new int[]{0};
    dfs(arr, new HashSet<>(), maxLen, 0);
    return maxLen[0];
  }

  private void dfs(List<String> arr, Set<Character> fullSet, int[] maxLen, int level) {
    // base case
    if (level == arr.size()) {
      maxLen[0] = Math.max(maxLen[0], fullSet.size());
      return;
    }
    // not add
    dfs(arr, fullSet, maxLen, level + 1);
    String curStr = arr.get(level);
    // add
    if (isValidate(fullSet, curStr)) {
      addAllCharToSet(fullSet, curStr);
      dfs(arr, fullSet, maxLen, level + 1);
      removeAllCharFromSet(fullSet, curStr);
    }

  }

  private boolean isValidate(Set<Character> set, String str) {
    Set<Character> localSet = new HashSet<>();
    for (Character ch : str.toCharArray()) {
      if (!localSet.contains(ch) && !set.contains(ch)) {
        localSet.add(ch);
      } else {
        return false;
      }
    }
    return true;

  }

  private void addAllCharToSet(Set<Character> set, String str) {
    for (Character ch : str.toCharArray()) {
      set.add(ch);
    }
  }

  private void removeAllCharFromSet(Set<Character> set, String str) {
    for (Character ch : str.toCharArray()) {
      set.remove(ch);
    }
  }
}

