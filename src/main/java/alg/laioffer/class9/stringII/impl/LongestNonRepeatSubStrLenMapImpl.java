package alg.laioffer.class9.stringII.impl;

import alg.laioffer.class9.stringII.LongestNonRepeatSubStrLen;

import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatSubStrLenMapImpl implements LongestNonRepeatSubStrLen {
  @Override
  public int longest(String input) {
    int res = 0;
    Map<Character, Integer> lastOccurred = new HashMap<>();
    int slow = 0;
    for(int fast = 0; fast < input.length(); fast++) {
      Character cur = input.charAt(fast);
      if(lastOccurred.containsKey(cur) && lastOccurred.get(cur) >= slow) {
       slow = lastOccurred.get(cur) + 1;
      }
      res = Math.max(res, fast - slow + 1);
      lastOccurred.put(cur, fast);
    }
    return res;
  }
}
