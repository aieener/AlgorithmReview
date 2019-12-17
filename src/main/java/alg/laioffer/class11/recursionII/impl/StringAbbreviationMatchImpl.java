package alg.laioffer.class11.recursionII.impl;

import alg.laioffer.class11.recursionII.StringAbbreviationMatch;

public class StringAbbreviationMatchImpl implements StringAbbreviationMatch {
  /**
   * book -> 4, b3, b2k --> true
   */
  @Override
  public boolean match(String input, String pattern) {
    return recurHelper(input, pattern, 0, 0);
  }

  private boolean recurHelper(String input, String pattern, Integer sourceIdx, Integer patternIdx) {
    // base case
    if (sourceIdx == input.length() && patternIdx == pattern.length()) return true;
    else if (sourceIdx >= input.length() || patternIdx >= pattern.length()) return false;

    if (isNumeric(pattern.charAt(patternIdx))) {
      return handleNumericCase(input, pattern, sourceIdx, patternIdx);
    } else {
      return handleNonNumericCase(input, pattern, sourceIdx, patternIdx);
    }
  }

  private boolean handleNonNumericCase(String input, String pattern, Integer sourceIdx, Integer patternIdx) {
    boolean curMatch = input.charAt(sourceIdx++) == pattern.charAt(patternIdx++);
    return curMatch && recurHelper(input, pattern, sourceIdx, patternIdx);
  }

  private boolean handleNumericCase(String input, String pattern, Integer sourceIdx, Integer patternIdx) {
    int count = 0;
    for (; patternIdx < pattern.length() && isNumeric(pattern.charAt(patternIdx)); patternIdx++) {
      count = 10 * count + (pattern.charAt(patternIdx) - '0');
    }
    // move sourceIdx;
    sourceIdx += count;
    return recurHelper(input, pattern, sourceIdx, patternIdx);
  }

  private boolean isNumeric(Character input) {
    return input <= '9' && input >= '0';
  }
}
