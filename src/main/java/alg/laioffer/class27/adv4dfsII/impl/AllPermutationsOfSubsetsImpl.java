package alg.laioffer.class27.adv4dfsII.impl;

import alg.laioffer.class27.adv4dfsII.AllPermutationsOfSubsets;

import java.util.ArrayList;
import java.util.List;

/**
 * 参考piazza 答案
 *                                ''("")
 *                      /            |              \
 *  0  str|res      bc(a)          ac(b)            ab(c)
 *                  /    \        /     \          /   \
 *  1  str|res   c(ab) b(ac)   c(ba) a(bc)       b(ca) a(cb)
 *                 |      |      |        |       |      |
 *  2  str|res   (abc)  (acb)  (bac)   (bca)    (cab) (cba)
 */
public class AllPermutationsOfSubsetsImpl implements AllPermutationsOfSubsets {
  @Override
  public List<String> allPermutationsOfSubsets(String set) {
    List<String> res = new ArrayList<>();
    StringBuilder cur = new StringBuilder();
    getPerm(set, cur, res);
    return res;
  }

  public void getPerm(String str, StringBuilder cur, List<String> res) {
    if (str == null) return;     //base case: nothing
    res.add(cur.toString());       //add each node in the path

    for (int i = 0; i < str.length(); i++) {
      String newStr = removeIthChar(str, i); //time: O(N)

      cur.append(str.charAt(i));
      getPerm(newStr, cur, res);
      cur.deleteCharAt(cur.length() - 1);
    }
  }

  private String removeIthChar(String input, int i) {
    return input.substring(0, i) + input.substring(i + 1);
  }

  public static void main(String[] args) {
    AllPermutationsOfSubsets engine = new AllPermutationsOfSubsetsImpl();
    engine.allPermutationsOfSubsets("abc");
  }
}
