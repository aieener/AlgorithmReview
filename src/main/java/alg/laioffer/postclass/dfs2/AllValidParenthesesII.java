package alg.laioffer.postclass.dfs2;

import java.util.*;

/**
 * Class 28 Stack
 * generate all valid permutaions of
 * l pairs of ()
 * m pairs of <>
 * n pairs of {}
 */
public class AllValidParenthesesII {
  public List<String> validParentheses(int l, int m, int n) {
    Map<Character, Integer> dataMap = getDataMap(l, m, n);
    Deque<Character> stack = new LinkedList<>();
    List<String> result = new ArrayList<>();
    StringBuilder curSol = new StringBuilder();
    int height = 2 * (l + m + n);
    dfs(result, stack, dataMap, curSol, height);
    return result;
  }

  private Map<Character, Integer> getDataMap(int l, int m, int n) {
    Map<Character, Integer> res = new LinkedHashMap<>();
    res.put('(', l);
    res.put(')', l);
    res.put('<', m);
    res.put('>', m);
    res.put('{', n);
    res.put('}', n);
    return res;
  }

  private void dfs(List<String> res, Deque<Character> stack, Map<Character, Integer> dataMap, StringBuilder curSol, int height) {
    // base case
    if (curSol.length() == height) {
      res.add(curSol.toString());
      return;
    }

    int i = 0;
    Character prevChar = ' ';
    for (Character curChar : dataMap.keySet()) {
      if (i % 2 == 0) {
        // left
        if (dataMap.get(curChar) > 0) {
          curSol.append(curChar);
          stack.offerFirst(curChar);
          dataMap.put(curChar, dataMap.get(curChar) - 1);
          dfs(res, stack, dataMap, curSol, height);
          curSol.deleteCharAt(curSol.length() - 1);
          stack.pollFirst();
          dataMap.put(curChar, dataMap.get(curChar) + 1);
        }
      } else {
        // right
        if (!stack.isEmpty() && stack.peekFirst() == prevChar) {
          curSol.append(curChar);
          stack.pollFirst();
          dataMap.put(curChar, dataMap.get(curChar) - 1);
          dfs(res, stack, dataMap, curSol, height);
          curSol.deleteCharAt(curSol.length() - 1);
          stack.offerFirst(prevChar);
          dataMap.put(curChar, dataMap.get(curChar) + 1);
        }
      }
      prevChar = curChar;
      i++;
    }
  }

  public static void main(String[] args) {
    System.out.println(new AllValidParenthesesII().validParentheses(1, 1, 2));

  }
}
