package alg.oa.microsoftRealOA;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedStringLenWithUniqChar {
  public int maxLength(List<String> arr) {
    int[] maxLen = new int[]{0};
    dfs(arr, new HashSet<>(), 0, maxLen);
    return maxLen[0];
  }

  private void dfs(List<String> arr, Set<Character> set, int index, int[] maxLen) {
    if (index == arr.size()) {
      return;
    }
    // not add
    dfs(arr, set, index + 1, maxLen);

    // add
    String curStr = arr.get(index);
    if (isUniq(set, curStr)) {
      maxLen[0] = Math.max(maxLen[0], set.size() + curStr.length());
      addStrCharToSet(set, curStr);
      dfs(arr, set, index + 1, maxLen);
      removeStrFromSet(set, curStr);
    }
  }

  private void addStrCharToSet(Set<Character> fullSet, String curStr) {
    for (Character ch : curStr.toCharArray()) {
      fullSet.add(ch);
    }
  }

  private void removeStrFromSet(Set<Character> fullSet, String curStr) {
    for (Character ch : curStr.toCharArray()) {
      fullSet.remove(ch);
    }
  }

  private boolean isUniq(Set<Character> fullSet, String curStr) {
    Set<Character> set = new HashSet<>();
    for (char ch : curStr.toCharArray()) {
      if (fullSet.contains(ch) || set.contains(ch)) return false;

      set.add(ch);
    }
    return true;
  }
}
