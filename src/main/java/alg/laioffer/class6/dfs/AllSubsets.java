package alg.laioffer.class6.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS EX 1
 * Last Review Mar 13, 2019
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

public class AllSubsets {

  // in class example 在最后一层打印subset
  // Time O(2^n)
  // space O(n) n is 层数
  public List<String> subSets(String set) {
    List<String> res = new ArrayList<>();
    if(set == null) return res;
    StringBuilder curSol = new StringBuilder();
    dfs(res, curSol, 0, set);
    return res;
  }

  private void dfs(List<String> res, StringBuilder curSol, int level, String input) {
    // base case
    if(level == input.length()) {
      res.add(curSol.toString());
      return;
    }
     // not add 'A'
    dfs(res, curSol, level+1, input);

    // add 'A'
    curSol.append(input.charAt(level));
    dfs(res, curSol, level+1, input);
    curSol.deleteCharAt(curSol.length() - 1);
  }

  public static void main(String[] args) {
    AllSubsets sl = new AllSubsets();
    String input = "abc";
    List<String> res = sl.subSets(input);
    System.out.println(res);
  }


}
