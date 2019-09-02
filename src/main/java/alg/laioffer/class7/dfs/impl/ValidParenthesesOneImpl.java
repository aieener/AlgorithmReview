package alg.laioffer.class7.dfs.impl;

import alg.laioffer.class7.dfs.ValidParenthesesOne;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS EX 2
 * Last Review Aug 31 2019
 * ------ initial review comment ----------
 * subset 升级版， 加A不加A 加上了 validation
 * () () () find all valid permutation using the parenthesis provided
 * valid for any ), there must have one ( to match it
 * 1. what does it store on each level? (每层代表什么意义， 一般解题前就知道DFS要recur多少层)
 *   6 levels, each level represents each position ---> base case controls this
 * 2. how many different states should we try to put on this level
 *   2 branches either use ( or ) ----> function body controls this
 * If not container like array, maybe there is no need to back-track!
 * T = O(2^2n)
 * S = O(2n)
 * curSol could be StringBuilder ---> this case we need to back track
 * curSol could also be char[] ---> this case we don't need to back track
 */
public class ValidParenthesesOneImpl implements ValidParenthesesOne {
  @Override
  public List<String> validParentheses(int n) {
    List<String> res = new ArrayList<>();
    if (n == 0) return res;
    dfs(res, n, n, new StringBuilder());
    return res;
  }

  private void dfs(List<String> res, int leftRemainAmt, int rightRemainAmt, StringBuilder sb) {
    // base case
    if (leftRemainAmt == 0 && rightRemainAmt == 0) {
      res.add(sb.toString());
      return;
    }
    // add (
    if (leftRemainAmt > 0) {
      sb.append('(');
      dfs(res, leftRemainAmt - 1, rightRemainAmt, sb);
      sb.deleteCharAt(sb.length() - 1);
    }
    // add )
    if (rightRemainAmt > 0 && leftRemainAmt < rightRemainAmt) {
      sb.append(')');
      dfs(res, leftRemainAmt, rightRemainAmt - 1, sb);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
