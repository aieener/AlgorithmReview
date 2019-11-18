package alg.laioffer.class9.stringII.impl;

import alg.laioffer.class9.stringII.StrReplace;

import java.util.HashSet;
import java.util.Set;

/**
 * input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
 * input = "laicode", S = "code", T = "offer", input becomes "laioffer"
 */

public class StrReplaceImpl implements StrReplace {
  public static void main(String[] args) {
    String input = "dogcatdogcat";
    StrReplace engine = new StrReplaceImpl();
    System.out.println(engine.replace(input, "cat", "apple"));
  }

  @Override
  public String replace(String input, String source, String target) {
    char[] inputArr = input.toCharArray();
    if (source.length() > target.length()) {
      return replaceWhenSourceIsLonger(inputArr, source, target);
    }
    return replaceWhenTargetIsLonger(inputArr, source, target);
  }

  private String replaceWhenSourceIsLonger(char[] input, String source, String target) {
    Set<Integer> indexesToReplace = findIdxesToReplace(input, source);
    int endIdx = doReplace(0, indexesToReplace, input, source, target);
    return new String(input, 0, endIdx);
  }

  private String replaceWhenTargetIsLonger(char[] input, String source, String target) {
    Set<Integer> indexesToReplace = findIdxesToReplace(input, source);
    // padding
    int diff = indexesToReplace.size() * (target.length() - source.length());
    char[] result = copyInputToResult(input, diff);
    // replace
    doReplace(diff, indexesToReplace, result, source, target);
    return new String(result);
  }

  private int doReplace(int fast, Set<Integer> placeToReplace, char[] input, String source, String target) {
    int slow = 0;
    int origin = fast;
    while (fast < input.length) {
      if (placeToReplace.contains(fast - origin)) {
        substitute(input, slow, target);
        slow += target.length();
        fast += source.length();
      } else {
        input[slow++] = input[fast++];
      }
    }
    return slow;
  }

  private char[] copyInputToResult(char[] input, int diff) {
    char[] result = new char[input.length + diff];
    for (int i = 0; i < input.length; i++) {
      result[result.length - i - 1] = input[input.length - i - 1];
    }
    return result;
  }

  private Set<Integer> findIdxesToReplace(char[] input, String source) {
    Set<Integer> result = new HashSet<>();
    for (int i = 0; i <= input.length - source.length(); i++) {
      if (isSubString(input, i, source)) result.add(i);
    }
    return result;
  }

  private void substitute(char[] input, int start, String target) {
    for (Character cur : target.toCharArray()) {
      input[start++] = cur;
    }
  }

  private boolean isSubString(char[] input, int start, String source) {
    if (start + source.length() > input.length) return false;
    for (int i = start; i < source.length() + start; i++) {
      if (input[i] != source.charAt(i - start)) return false;
    }
    return true;
  }
}
