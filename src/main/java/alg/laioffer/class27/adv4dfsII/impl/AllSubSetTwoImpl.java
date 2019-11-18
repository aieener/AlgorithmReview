package alg.laioffer.class27.adv4dfsII.impl;

import alg.laioffer.class27.adv4dfsII.AllSubsetTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 高速公路
 */
public class AllSubSetTwoImpl implements AllSubsetTwo {
  @Override
  public List<String> subSets(String set) {
    List<String> res = new ArrayList<>();
    char[] inputArr = set.toCharArray();
    Arrays.sort(inputArr);
    dfs(inputArr, res, new StringBuilder(), 0);
    return res;
  }

  private void dfs(char[] set, List<String> res, StringBuilder sb, int idx) {
    // base case
    if (idx == set.length) {
      res.add(sb.toString());
      return;
    }
    // add
    sb.append(set[idx]);
    dfs(set, res, sb, idx + 1);
    sb.deleteCharAt(sb.length() - 1);
    // not add
    char curVal = set[idx];
    // high-way
    while (idx < set.length && set[idx] == curVal) {
      idx++;
    }
    dfs(set, res, sb, idx);
  }
}
