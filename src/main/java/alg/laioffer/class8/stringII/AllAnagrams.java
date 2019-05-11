package alg.laioffer.class8.stringII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This one is the Sliding window　硬弹簧
 */
public class AllAnagrams {
  public List<Integer> allAnagrams(String sh, String lo) {
    List<Integer> res = new ArrayList<>();
    if (sh == null || sh.length() == 0) return res;
    Map<Character, Integer> dict = getTargetDict(sh);
    findAllAnagrams(lo.toCharArray(), dict, res, sh.length());
    return res;
  }

  private void findAllAnagrams(char[] input, Map<Character, Integer> dict, List<Integer> res, int tarSize) {
    int slow = 0;
    int fast = 0;
    int match = 0;
    while (fast < input.length) {
      while (fast < input.length && fast - slow < tarSize) {
        char curChar = input[fast];
        if (dict.containsKey(curChar)) {
          int curCount = dict.get(curChar);
          dict.put(curChar,  curCount - 1);
          if(curCount == 1) {
            match++;
          }
        }
        fast++;
      }
      if (match == dict.size()) {
        res.add(slow);
      }
      if(dict.containsKey(input[slow])) {
        int curCount = dict.get(input[slow]);
        dict.put(input[slow], curCount + 1);
        if(curCount == 0) {
          match--;
        }
      }
      slow++;
    }
  }
  private Map<Character, Integer> getTargetDict(String sh) {
    Map<Character, Integer> dict = new HashMap<>();
    for (char cur : sh.toCharArray()) {
      int curCount = dict.getOrDefault(cur, 0);
      dict.put(cur, curCount + 1);
    }
    return dict;
  }

  public static void main(String[] args) {
    AllAnagrams aa = new AllAnagrams();
    String l = "ababacbbaac";
    String s = "aab";
    List<Integer> res = aa.allAnagrams(s, l);
    System.out.println(res);
  }
}
