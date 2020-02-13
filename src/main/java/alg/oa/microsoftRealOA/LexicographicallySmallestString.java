package alg.oa.microsoftRealOA;

import java.util.Deque;
import java.util.LinkedList;

/*
Lexicographically smallest string formed by removing at most one character.

the easy version of removeKdigits
Example 1:

Input: "abczd"
Output: "abcd"
 */
public class LexicographicallySmallestString {
  public String getSmallString(String s) {
    Deque<Character> deque = new LinkedList<>();
    int counter = 0;
    for (int i = 0; i < s.length(); i++) {
      char cur = s.charAt(i);
      if (!deque.isEmpty() && deque.peek() > cur && counter < 1) {
        deque.pop();
        counter++;
      }
      deque.push(cur);
    }
    if (counter == 0) deque.pop();
    return makeString(deque);
  }

  private String makeString(Deque<Character> deque) {
    StringBuilder sb = new StringBuilder();
    while (!deque.isEmpty()) {
      sb.append(deque.pollLast());
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    LexicographicallySmallestString engine = new LexicographicallySmallestString();
    System.out.println(engine.getSmallString("abjczd"));
    System.out.println(engine.getSmallString("abcde"));
  }
}
