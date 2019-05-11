package alg.laioffer.class6.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS EX 2
 * Last Review Mar 13 2019
 * subset 升级版， 加A不加A 加上了 validation
 * () () () find all valid permutation using the parenthesis provided
 * valid for any ), there must have one ( to match it
 * 1. what does it store on each level? (每层代表什么意义， 一般解题前就知道DFS要recur多少层)
 * 6 levels, each level represents each position ---> base case controls this
 * 2. how many different states should we try to put on this level
 * 2 branches either use ( or ) ----> function body controls this
 * <p>
 * If not container like array, maybe there is no need to back-track!
 * T = O(2^2n)
 * S = O(2n)
 * 没思路， 参考了答案， 需要重做 Jan 2
 * 需要再多思考几遍！
 *
 * curSol could be StringBuilder ---> this case we need to back track
 * curSol could also be char[] ---> this case we don't need to back track
 */
public class ValidParentheses {
  // in class example n = 3 ,l ( r )
  public List<String> validParentheses(int n) {
    List<String> result = new ArrayList<>();
    char[] curSol =new char[n * 2];
    dfs(result, curSol, 0, 0, n, 0);
    return result;
  }

  // left is the number of ( we have used
  private void dfs(List<String> result, char[] curSol, int left, int right, int n, int level) {
    // base case
    if (level == 2*n) {
      result.add(new String(curSol));
      return;
    }

    // add left
    if (left < n) {
      curSol[level] = '(';
      dfs(result, curSol, left + 1, right, n, level + 1);
    }

    // add right
    if (right < n && left > right) {
      curSol[level] = ')';
      dfs(result, curSol, left, right + 1, n, level + 1);
    }
  }


  // why even there is no back tracking, the code is till working?

  /**
   * 1. we are setting the char at index and when back tracking, what we need
   * is just 1) remove the char at index and 2) add a different char at index
   * 2. only when we fill in all the position in cur, we have a complete solution
   * <p>
   * The code itself actually already suffices the above two points and is already does
   * the correct removing operation when back tracked to the previous level
   */

  public static void main(String[] args) {
    ValidParentheses vp = new ValidParentheses();
    List<String> res = vp.validParentheses(3);
    System.out.println(res);
  }

  // --- prac ---

}
