package alg.laioffer.class8.stringII;

import java.util.HashSet;
import java.util.Set;

/**
 * last visit April 12 2019
 * took about 2 hours to debug..
 *
 * current version uses same scan direction for both cases
 */
public class StringReplace {
  public String replace(String input, String source, String target) {
    char[] inputArray = input.toCharArray();
    if (source.length() >= target.length()) {
      return handleSourceIsLonger(inputArray, source, target);
    }
    return handleTargetIsLonger(inputArray, source, target);
  }

  private String handleSourceIsLonger(char[] input, String source, String target) {
    int slow = 0;
    int fast = 0;
    slow = copyFastToSlowOrSubstitute(input, source, target, slow, fast);
    return new String(input, 0, slow);
  }

  private int copyFastToSlowOrSubstitute(char[] input, String source, String target, int slow, int fast) {
    while (fast < input.length) {
      if (isSubstring(input, fast, source)) {
        substitute(input, slow, target);
        fast += source.length();
        slow += target.length();
      } else {
        input[slow++] = input[fast++];
      }
    }
    return slow;
  }

  private String handleTargetIsLonger(char[] input, String source, String target) {
    int diff = target.length() - source.length();
    Set<Integer> occurSet = findNumOfOccurSet(input, source);
    int bufSize = diff * occurSet.size();
    int resSize = input.length + bufSize;

    char[] res = new char[resSize];
    cpyInputToRes(res, input);
    int slow = 0;
    int fast = bufSize;
    while(fast < resSize) {
      if(occurSet.contains(fast - bufSize)) {
        substitute(res, slow, target);
        slow += target.length();
        fast += source.length();
      } else {
        res[slow++] = res[fast++];
      }
    }
    return new String(res);
  }

  private void cpyInputToRes(char[] res, char[] input) {
    for (int i = 0; i < input.length; i++) {
      res[res.length - 1 - i] = input[input.length - 1 - i];
    }
  }

  private void substitute(char[] input, int start, String target) {
    for (int i = 0; i < target.length(); i++) {
      input[start + i] = target.charAt(i);
    }
  }

  private Set<Integer> findNumOfOccurSet(char[] input, String source) {
    Set<Integer> res = new HashSet<>();
    for (int i = 0; i < input.length - source.length() + 1; i++) {
      if (isSubstring(input, i, source)) {
        res.add(i);
        i += source.length() - 1;
      }
    }
    return res;
  }

  private boolean isSubstring(char[] input, int start, String source) {
    for (int i = 0; i < source.length(); i++) {
      if (start + i >= input.length) return false;
      if (input[start + i] != source.charAt(i)) return false;
    }
    return true;
  }


  public static void main(String[] args) {
    StringReplace sr = new StringReplace();
    String input = "Studentdentdendent";
    String s = "den";
    String t = "xx";
    String out = sr.replace(input, s, t);
    System.out.println(out);

    input = "aaa";
    s = "aa";
    t = "";
    System.out.println(sr.replace(input, s, t));
  }
}
