package alg.laioffer.class7.dfs.impl;

import alg.laioffer.class7.dfs.AllSubsetsOne;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS EX 1
 * Last Review Aug 30, 2019
 * Subset do i + 1
 * Permutation do idx + 1
 * <p>
 * Note from class Mar 13 2019::
 * DFS: {a, b, c}
 * 1. what does it store on each level? (每层代表什么意义， 一般解题前就知道DFS要recur多少层)
 * three levels
 * 2. how many different states should we try to put on this level
 * two states, take A or Not take A, 加A 不加A
 * {}
 * a             {a}                   {}
 * b      {a,b}       {a}         {b}      {}
 * c  {a,b,c} {a,b} {a} {a,c}  {bc} {b}  {c} ｛｝
 * <p>
 * DFS Time complecity must be exponential of factorial!
 * DFS 一定不是 polynomial!
 */
public class AllSubsetsOneImpl implements AllSubsetsOne {
  @Override
  public List<String> subSets(String set) {
    List<String> res = new ArrayList<>();
    if (set == null) return res;
    dfs(res, set, new StringBuilder(), 0);
    return res;
  }

  private void dfs(List<String> res, String set, StringBuilder sb, int curLevel) {
    // base case
    if (curLevel == set.length()) {
      res.add(sb.toString());
      return;
    }

    // add elem
    sb.append(set.charAt(curLevel));
    dfs(res, set, sb, curLevel + 1);
    sb.deleteCharAt(sb.length() - 1);
    // dont add elem
    dfs(res, set, sb, curLevel + 1);
  }
}
